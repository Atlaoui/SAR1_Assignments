#include <iostream>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <libnet.h>
//1 Tube anonyme
//Q1




//2 Tube nommé
//Q1
int write(const std::string & s, int fd){
    size_t sz=s.length();
    if(write(fd,&sz, sizeof(sz))!= sizeof(sz)){
        perror("write error sz");
        return -1;
    }

    if(write(fd,s.data(),sz)!=sz){
        perror("write error sz");
        return -1;
    }
    std::cout << "write string len = " << sz << " : " << s << '\n';
    return sz;
}

int read(std::string & s , int fd){
    size_t sz;
    int rd = read(fd,&sz, sizeof(sz));
    if(rd==0){
        return 0;
    }else if(rd!=sizeof(sz)){
        perror("read error");
        return -1;
    }
    char buff[sz];
    if(read(fd,buff,sz)!=sz){
        perror("read error");
        return -1;
    }
    s=std::string(buff,sz);
    return sz;
}

char * path;

//Q2
void handlerCtrlC(int sig){
    unlink(path);

    exit(0);
}
//code du writer
int main3 (int argc ,char **argv) {
    if(argc<2){
        std::cout << "nom du pipe?"<< '\n';
    }
    path = argv[1];

if(mkfifo(path,S_IRUSR |S_IWUSR)!=0){
    perror("mkfifo error");
    return 1;
}

int fd= open(path,O_WRONLY);
    if(fd<0){
        perror("Opent error");
        return 1;
    }
    signal(SIGINT,handlerCtrlC);
    while (true) {
        std::string line;
        std::cin >> line;
        if(write(line,fd)<0){
            break;
        }
    }
return 0;
}

//Q3
int main4(int argc ,char **argv){
    if(argc < 2){
        std::cerr << "nom du pipe ?" << '\n';
    }
    int fd = open(argv[1],O_RDONLY);
    if(fd<0){
        perror("open error");
        return 1;
    }
    while (true){
        std::string s;
        int rd =read(s,fd);
        if(rd==0)
            break;
        std::cout << s << '\n';
    }
    return 0;
}

//Q4
//





int main77() {
    //1 Tube anonyme
    //Q1
    pid_t P , F1 , F2;
    P=getpid();
    int pidesk[2];
    if(pipe(pidesk)!=0){
        perror("Error pipe");
        return 1;
    }
    F1 = fork();
    if(F1<0){
        perror("Error Fork");
        return 1;
    } else if (F1 == 0){
        F1 = getpid();
        close(pidesk[1]);
        if(read(pidesk[0],&F2, sizeof(size_t))== sizeof(pid_t)){
            std::cout << "Je suis " << getpid() << " P =" << P << "F1 = " << F1 << '\n';
        } else{
            perror("read error");
            return 1;
        }
        close (pidesk[0]);
        return 0;
    }
    F2 = fork();
    if(F2<0){
        perror("Error Fork");
        return 1;
    }
    else if(F2 == 0){
        F2 = getpid();
        close(pidesk[0]);
        if(write(pidesk[1],&F2, sizeof(pid_t))== sizeof(pid_t)){
            std::cout << "Je suis " << getpid() << " P =" << P << "F1 = " << F1 << '\n';
        }else{
            perror("Error Fork");
            return 1;
        }
        close (pidesk[1]);
        return 0;
    }
    close(pidesk[0]);
    close(pidesk[1]);
    wait(0);
    wait(0);
    return 0;
}
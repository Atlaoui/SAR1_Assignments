//
// Created by adrien on 19/11/2019.
//

#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

void fils_cre_fils(){
    int N=4;
    int pid;
    for (int i = 0; i <N && (pid=fork())==0 ; ++i) {
        std::cout << "pid=" << pid << std::endl;
    }
    if(pid!=0)
        wait(nullptr);
}


void N_fork(){
    int N=10;
    int pid;
    int ret;
    while (--N && ((pid=fork())!=0)){
    }
    std::cout << "N=" << N << " pid=" << pid << std::endl;
    if(pid!=0)
    for(N=10;N>0;--N) {
        wait(&ret);
        std::cout << "RET=" << ret << std::endl;
    }
}



int main3 () {
   /* int N=4,pid;
    int pids[N];
    for (int i = 0; i <N ; ++i) {
        pid=fork();
        if(pid==0){
            std::cout << "pid=" << getpid() << std::endl;
            return i;
        }else{
            pids[i]=pid;
        }
    }

    for (int i = 0; i <N ; ++i) {
        int status ;
         pid = waitpid(pids[i],&status,0);
       // WEXITSTATUS(status);
        std::cout << "pid=" << pid << " retourn " << WEXITSTATUS(status) << std::endl;
    }*/
    fils_cre_fils();

    return 0;
}


int main10 () {
   int N = 4;
   int i = 0;
   int pid;
   std::cout << "pid=" << getpid() << std::endl;
   while (i < N) {
       i++;
       int j = i;
       if ((pid=fork()) == 0) {
           if (i%2==0) {
               N = i - 1;
               i = 0;
           } else {
               N = 0;
           }
     //      std::cout << "pid=" << getpid() << " ppid=" << getppid() << " j=" << j <<
       //              " N=" << N << std::endl;
       }
   }

   if(pid!=0){
       for(;i>N;i--)
           wait(nullptr);
   }

    std::cout << "pid=" << getpid();

    return 0;
}
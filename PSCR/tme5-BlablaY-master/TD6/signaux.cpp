#include <csignal>
#include <iostream>
#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

//
// Created by adrien on 20/11/2019.
//

//ont cré un masque
volatile std::sig_atomic_t gSignalStatus;



void signal_handler(int signal)
{
    gSignalStatus = signal;

}
void handle_alarm(int sig){

}
int main (){
    // Install a signal handler
    int M=5;
    sigset_t t;

    sigset_t setpos;

    sigfillset(&setpos);

    sigfillset(&t);
    sigdelset(&t,SIGINT);



    signal(SIGINT,[](int sig){std::cout << " k:j:pid " << sig <<  std::endl;});
    pid_t pid = fork();
    if(pid==0){
        std::cout << " naissance " << getpid() <<  std::endl;
        for(int i =0;i<M;i++){
            sigsuspend(&t);
            std::cout << " fils "<< getpid() << std::endl;
            kill(getpid(),SIGINT);
        }
        std::cout << " mort " << getpid() <<  std::endl;
        return 0;
    }else{
        sleep(1);

        for(int i =0;i<M;i++){
            std::cout << " pere au tour "<< getpid() << std::endl;
            kill(getpid(),SIGINT);
            sigsuspend(&t);
        }
    wait(nullptr);

    }



    return 0;
}

int main2(){
    int N=4,T=3;
    std::cout << " main pid " << getpid() << '\n';
    int pids[N];
    for(int i =0;i<N;i++){
        int pid = fork();
        if(pid == 0){
            std::cout << " fils " << i << " pid =" << getpid() << '\n';
        signal(SIGINT,[](int sig) {std::cout << "quiting after SIGINT" << getpid() << '\n'; exit(0);});
        sigset_t set;
        sigfillset(&set);
        sigdelset(&set,SIGINT);
        sigsuspend(&set);
        }
        else{
            pids[i]=pid;
        }
    }
    alarm(T);
    signal(SIGALRM,[](int RR){});
    sigset_t setalarm;
    sigfillset(&setalarm);
    sigdelset(&setalarm,SIGINT);
    sigsuspend(&setalarm);
    for(int i =0;i<N;i++){
        kill(pids[i],SIGINT);
    }
    //OU
    signal(SIGINT,SIG_IGN);
    kill(0,SIGINT);
    for(int i =0;i<N;i++){
        wait(nullptr);
    }


    }

/*volatile std::sig_atomic_t gSignalStatus;



void signal_handler(int signal)
{
    gSignalStatus = signal;

}
void handle_alarm(int sig){

}
int main (){
    // Install a signal handler
    std::signal(SIGINT, signal_handler);


    int pid = fork();
    if(pid!=0){
        std::signal( SIGALRM, handle_alarm); // Install handler first,
        alarm( 1 );
    }
    else{

    }

    std::cout << "SignalValue: " << gSignalStatus << '\n';
    std::cout << "Sending signal " << SIGINT << '\n';
    std::raise(SIGINT);
    std::cout << "SignalValue: " << gSignalStatus << '\n';

    return 0;
}*/
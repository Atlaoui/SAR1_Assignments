#include <ctime>
#include <cstdlib>
#include <sys/wait.h>
#include <iostream>
#include <zconf.h>
#include "rsleep.h"

bool dodo = true;

void handler_siginit(int){
    dodo =false;
}

void sigalarm_handler(int){
    std::cout << "SIGALARM" << std::endl;
    dodo =false;
    signal(SIGINT,handler_siginit);
    signal(SIGINT, SIG_IGN);
    kill(0,SIGINT);

}

void randsleep() {
  int r = rand();
  double ratio = (double)r / (double) RAND_MAX;
  struct timespec tosleep;
  tosleep.tv_sec =0;
  // 300 millions de ns = 0.3 secondes
  tosleep.tv_nsec = 300000000 + ratio*700000000;
  struct timespec remain;
  while ( nanosleep(&tosleep, &remain) != 0) {
    tosleep = remain;
  }
}


int wait_till_pid(pid_t pid){
    int status,pid_ret=-1;
   while(pid_ret!=pid) {
       pid_ret = wait(&status);
       if(pid_ret==-1)
            return -1;
   }
    return pid_ret;
}

int wait_till_pid (pid_t pid, int sec){
    signal(SIGALRM, sigalarm_handler);
    signal(SIGCHLD,[](int){std::cout << "SIGCHLD" << std::endl;  dodo =false;});
    alarm(sec);
    sigset_t set;
    sigfillset(&set);
    sigdelset(&set,SIGALRM);
    sigdelset(&set,SIGCHLD);
    pid_t pid_ret=0;

    while(pid_ret!=pid && dodo) {
        sigsuspend(&set);
        pid_ret = wait(nullptr);

    }
    std::cout << "dodo = " << dodo << std::endl;
    if(!dodo)
        return 0;

    if(pid_ret==-1)
        return -1;

    return pid_ret;
}

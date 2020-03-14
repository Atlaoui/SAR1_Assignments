//
// Created by adrien on 27/12/2019.
//

#include <cstdlib>
#include <zconf.h>
#include <wait.h>
#include <iostream>
pid_t p;
void signaled (int sig) {
    printf("killed by timeout\n");
    kill (p, SIGINT);
}

int main (int argc , char ** args){

    int nb_sec = atoi(args[1]);

    if((p=fork())==0){
        std::cout << "Test";
        printf("running %s\n",args[2]);
        execv(args[2],args + 2);
    }
else{
        alarm (nb_sec);
        signal(SIGALRM, signaled);
        wait(nullptr);
        printf("Child dead\n");
}


    return 0;
}
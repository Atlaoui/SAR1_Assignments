//
// Created by adrien on 27/11/2019.
//
#include <fcntl.h>
#include <sys/stat.h>
#include <semaphore.h>
#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <iostream>
#define  NBROUNDS 10
int main () {
    sem_t * sm1 = sem_open("/sem1",O_CREAT | O_EXCL | O_RDWR ,0666,0);
    sem_t * sm2 = sem_open("/sem2",O_CREAT | O_EXCL | O_RDWR ,0666,0);

    if(sm1 == SEM_FAILED || sm2 == SEM_FAILED){
        perror("error sem");
        return 1;
    }

    pid_t f = fork();
    if(f==0){
        for(int i = 0 ;i<NBROUNDS;i++){
            sem_wait(sm1);
            std::cout << "Ping ";
            sem_post(sm1);
        }
        sem_close(sm1);
        sem_close(sm2);
    }else{
        for(int i = 0 ;i<NBROUNDS;i++){
            sem_post(sm1);
            sem_wait(sm2);
            std::cout << "Pong ";
        }
        sem_close(sm1);
        sem_close(sm2);
        sem_unlink("/sem1");
        sem_unlink("/sem2");
        wait(nullptr);
    }

    return 0;
}

int m2ain (){
    int N = 5;
    sem_t * mutex[N];

    for(int i = 0; i<N ;i++){
        int semval=0;
        if(i==0)
            semval=1;
        std::string semname = "/sem" + std::to_string(i);
        mutex[i] = sem_open(semname.c_str(),O_CREAT | O_EXCL | O_RDWR ,0666,0);
        if(mutex[i]==SEM_FAILED)
            exit(1);
    }
    for(int i = 0; i<N ;i++){
        pid_t f = fork();
        if(f == 0){
            for(int i = 0; i<N ;i++){
                sem_wait(mutex[i]);
                std::cout << " ping " << i << '\n';
                sem_post(mutex[(i+1) % N]);
            }
        }
    }

    for(int i = 0; i<N ;i++){
        wait (nullptr);
    }

    for(int i = 0; i<N ;i++){
    sem_unlink(("/sem"+std::to_string(i)).c_str());

    }

        return 0;
}

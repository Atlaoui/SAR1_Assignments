//
// Created by adrien on 27/11/2019.
//

#pragma once
#include <cstring> // size_t,memset
#include <fcntl.h>
#include <sys/stat.h>
#include <semaphore.h>
namespace pr {
#define STACKSIZE 100

    template<typename T>
    class Stack {

        sem_t * smPop ;
        sem_t * smPush;
        sem_t * smMutex;

        T tab [STACKSIZE];
        size_t sz;
    public :
        Stack () : sz(0) { memset(tab,0,sizeof tab);
             smPop = sem_open("/sem1",O_CREAT | O_EXCL | O_RDWR ,0666,1);
            smPush = sem_open("/sem2",O_CREAT | O_EXCL | O_RDWR ,0666,STACKSIZE);
             smMutex = sem_open("/sem3",O_CREAT | O_EXCL | O_RDWR ,0666,1);
             sem_init(&smMutex,1,1);
        }
        T pop () {
            sem_wait(&smPop);
            sem_wait(&smMutex);
            T toret = tab[--sz];
            sem_post(&smMutex);
            return toret;
        }
        void push(T elt) {
            sem_wait(&smPush);
            sem_wait(&smMutex);
            tab[sz++] = elt;
            sem_post(&smMutex);
    }
        ~Stack(){
            sem_destroy(&smMutex);
        }
    };
}
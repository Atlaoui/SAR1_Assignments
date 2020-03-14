//
// Created by adrien on 27/12/2019.
//

#include "rwlock.h"
#include <semaphore.h>
//Q3)a) le problemme survien si il y a deux lecteur
class RWLockSem : public RWLock {
    sem_t sem;
    sem_t sem_ecri;
    size_t MAX;
public :
    RWLockSem(int MAX):MAX(MAX){
        sem_init (&sem, 0, MAX);
        sem_init (&sem_ecri, 0, 1);

    }
    void rlock () {
        sem_wait(&sem);
    }
    void runlock () {
        sem_post(&sem);
    }
    void wlock () {
        sem_wait(&sem_ecri);
        for (int i=0; i <MAX ; i++)
            sem_wait(&sem);
    }
    void wunlock () {
        for (int i=0; i <MAX ; i++)
            sem_post(&sem);
        sem_post(&sem_ecri);
    }
};
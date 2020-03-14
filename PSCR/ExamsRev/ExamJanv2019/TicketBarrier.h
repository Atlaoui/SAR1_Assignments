//
// Created by adrien on 23/12/2019.
//

#ifndef EXAMSREV_TICKETBARRIER_H
#define EXAMSREV_TICKETBARRIER_H
#include <condition_variable>
#include <mutex>
#include <thread>
#include <semaphore.h>
#include <unistd.h>



class TicketBarrier{
    int nb_ticket;
    int cpt;
    std::mutex m;
    std::condition_variable cond_var;

    TicketBarrier(int nb) : nb_ticket(nb-1){cpt = 0;}
    void enter(){
        std::unique_lock<std::mutex> lock(m);
        cpt++;
        while(cpt==nb_ticket)
            cond_var.wait(lock);
    }
    void leave(){
        std::unique_lock<std::mutex> lock(m);
        cpt--;
        if(cpt==nb_ticket)
            cond_var.notify_one();
    }
};

class TicketBarrierPOSIX{
    sem_t mutex;
    TicketBarrierPOSIX(int nb) {sem_init( & mutex , 0,nb)}
    void enter(){
        sem_wait(&mutex);
    }
    void leave(){
        sem_post(&mutex);
    }
};
#endif //EXAMSREV_TICKETBARRIER_H

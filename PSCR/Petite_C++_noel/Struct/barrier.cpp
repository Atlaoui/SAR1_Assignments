//
// Created by adrien on 03/11/2019.
//

#include "barrier.h"

barrier::barrier(int max) :MAX(max),cpt(0){

}

void barrier::att() {
    std::unique_lock<std::mutex> lg(m);
    cpt++;
    while (cpt !=MAX)
        cd_att.wait(lg);
    cd_att.notify_all();
}

//
// Created by adrien on 03/11/2019.
//

#include <zconf.h>
#include <iostream>
#include "PereNoel.h"

pr::PereNoel::PereNoel(int Nbr):NB_TOTAL_RENNES(Nbr),nbRennesAtteles(0),busy(false),b(Nbr+1){}

void pr::PereNoel::sayHello() {
    std::unique_lock<std::mutex> lg(m);
    while(busy)
        cd_ren.wait(lg);
    busy = true;
    cd_per.notify_one();
}

void pr::PereNoel::attelerRenne() {
    std::unique_lock<std::mutex> lg(m);
    while(!busy)
        cd_per.wait(lg);
    sleep(3);// Ca prend du temps d’attacher le bestiau !
    nbRennesAtteles++;
    std::cout << "Encore un renne attele. " << std::endl;
    std::cout << "Il y en a maintenant " << nbRennesAtteles <<std::endl;
    busy = false;
    cd_ren.notify_one();
}

void pr::PereNoel::run() {
    while (nbRennesAtteles != NB_TOTAL_RENNES) {
        attelerRenne();
    }
    sleep(1);// Le Pere Noel a du mal a monter !
    b.att();
    std::cout << "Je monte dans le traineau !" << std::endl;
}

void pr::PereNoel::att_hisse() {
    b.att();
}


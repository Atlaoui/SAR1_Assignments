//
// Created by adrien on 03/11/2019.
//

#include <iostream>
#include "Renne.h"

int pr::Renne::cpt=0;


pr::Renne::Renne(pr::PereNoel & papa) : p(papa), id(pr::Renne::cpt) {
    pr::Renne::cpt++;
}

void pr::Renne::run() {
    std::cout << "Le reine "<< id <<" est revenue."<< std::endl;
    p.sayHello();
    p.att_hisse();
    std::cout << "Le reine "<< id <<" courre."<< std::endl;
}

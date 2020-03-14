//
// Created by adrien on 06/11/2019.
//

#ifndef RESTAURANT_RESTAURANT_H
#define RESTAURANT_RESTAURANT_H

#include <mutex>

class Restaurant {
    int nbtable;
    std::mutex mtx;

public:
    Restaurant(int nbtable);
    int reserver (int nb_personnes);
};


#endif //RESTAURANT_RESTAURANT_H

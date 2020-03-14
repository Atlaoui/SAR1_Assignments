//
// Created by adrien on 06/11/2019.
//

#include "Restaurant.h"

Restaurant::Restaurant(int nbtable) : nbtable(nbtable){

}

int Restaurant::reserver(int nb_personnes) {
    std::unique_lock<std::mutex> lck (mtx);
    if(nb_personnes>nbtable*2)
        return -1;
    else {
        int num=nbtable;
        nbtable-=(nb_personnes/2)+(nb_personnes%2);
        return num;
    }
}


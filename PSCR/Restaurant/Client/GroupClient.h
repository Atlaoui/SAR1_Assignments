//
// Created by adrien on 03/11/2019.
//

#ifndef RESTAURANT_GROUPCLIENT_H
#define RESTAURANT_GROUPCLIENT_H

#include <iostream>
#include <vector>
#include <thread>
#include "../Restaurant.h"
#include "Client.h"

class GroupClient {
    Restaurant & r ;
    int nbclien;
    int id;
    static int cpt;
    std::vector<std::thread> threads;
public:

    GroupClient(Restaurant & r, int nbclien);
    ~GroupClient(){}
};


#endif //RESTAURANT_GROUPCLIENT_H

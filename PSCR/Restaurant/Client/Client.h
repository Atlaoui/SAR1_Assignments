//
// Created by adrien on 03/11/2019.
//

#ifndef RESTAURANT_CLIENT_H
#define RESTAURANT_CLIENT_H


#include "GroupClient.h"

class Client {
    GroupClient *groupe;
    int id;
public:

    Client(GroupClient *groupe,int id);


    void run ();



    ~Client(){}
};


#endif //RESTAURANT_CLIENT_H

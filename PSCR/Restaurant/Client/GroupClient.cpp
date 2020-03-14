//
// Created by adrien on 03/11/2019.
//

#include "GroupClient.h"


int GroupClient::cpt=0;

GroupClient::GroupClient(Restaurant &r, int nbclien) : r(r) ,nbclien(nbclien),id(cpt) {
    threads.reserve(nbclien);
    for(int i=0;i<nbclien;i++) {
       //Client c (this,i);
        //threads.emplace_back();
    }
}

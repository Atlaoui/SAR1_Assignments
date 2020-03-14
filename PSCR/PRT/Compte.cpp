//
// Created by adrien on 16/10/2019.
//

#include "Compte.h"

void Compte::crediter (size_t val) {
    mtx.lock();
    solde+=val;
    mtx.unlock();}


bool Compte::debiter (unsigned int val) {
    mtx.lock();
    bool doit = (solde >= val);
    if (doit) {
        solde-=val ;
    }
    mtx.unlock();
    return doit;

}

int Compte::getSolde() const {
    mtx.lock();
    auto a = solde;
    mtx.unlock();
    return a;
}





//for the SYNC


std::recursive_mutex & Compte::getMutex() {
    return mtx;
}

bool Compte::try_lock() const {
    return mtx.try_lock();
}

void Compte::lock() const {
    mtx.lock();
}
void Compte::unlock() const {
    mtx.unlock();
}





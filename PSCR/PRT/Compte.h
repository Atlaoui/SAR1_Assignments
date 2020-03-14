//
// Created by adrien on 16/10/2019.
//

#ifndef PRT_COMPTE_H
#define PRT_COMPTE_H
#include <vector>
#include <thread>
#include <mutex>

using namespace std;

class Compte {
    mutable std::recursive_mutex mtx;

    int solde;
    //atomic <int>  aussi peux etre utiliser
public :
    Compte(int solde=0):solde(solde) {}

    // NB : vector exige Copyable, mais mutex ne l’est pas...
    Compte(const Compte & other) {
        other.mtx.lock();
        solde = other.solde;
        other.mtx.unlock();
    }

    void crediter (size_t val);

    int getSolde()const;

    bool debiter (unsigned int val);


    //for the SYNC
    std::recursive_mutex & getMutex();

    bool try_lock() const;
    void lock() const;
    void unlock() const;

};
#endif //PRT_COMPTE_H

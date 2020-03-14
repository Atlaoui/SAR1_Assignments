//
// Created by adrien on 16/10/2019.
//

#include "Compte.h"
#include <iostream>
class Banque {
    typedef vector<Compte> comptes_t;
    comptes_t comptes;
    std::recursive_mutex mtxCompte;
public :
    Banque (size_t ncomptes, size_t solde) : comptes (ncomptes, Compte(solde)){
    }
    void transfert(size_t deb, size_t cred, unsigned int val,int num) {
        Compte & debiteur = comptes[deb];
        Compte & crediteur = comptes[cred];
        std::cout << "Je transfert " << num << std::endl;
        //mtxCompte.lock();
        if (debiteur.debiter(val)) {
                crediteur.crediter(val);
            mtxCompte.unlock();
        }
   }



 void printAll() {
     for (Compte & c : comptes) {
         std::cout << c.getSolde() << std::endl;
     }
    }

    size_t size() const {
        return comptes.size();
    }

    bool comptabiliser (int attendu) const {
        int bilan = 0;
        int id = 0;


       // unique_lock<recursive_mutex> g(mtxCompte);
            for (const auto & compte : comptes) {
                //compte.getMutex().lock();
                compte.lock();
            if (compte.getSolde() < 0) {
                cout << "Compte " << id << " en négatif : " << compte.getSolde() <<
                     endl;
            }
            bilan += compte.getSolde();
            id++;
        }

        for ( const auto  & compte : comptes) {
            compte.unlock();
        }
        if (bilan != attendu) {
            cout << "Bilan comptable faux : attendu " << attendu << " obtenu : " <<
                 bilan << endl;
        }
        return bilan == attendu;
    }
};
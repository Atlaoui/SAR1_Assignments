#include <iostream>
#include <thread>
#include <time.h>
#include <stdlib.h>
#include "Compte.h"
#include <chrono>
#include <unistd.h>
#include "transferts.cpp"


void transaction(Banque & B , int num) {
    for (int inc = 0; inc < 1000; ++inc) {
        B.transfert(rand() % 10, rand() % 10, rand() % 10000 + 1,num);
        usleep(rand() % 20);
    }
}

void contabilisateur(Banque & B , int attendu){
    for(int cpt = 10 ;cpt >0 ;--cpt) {
        usleep(rand() % 200);

        std::cout << B.comptabiliser(attendu)  << std::endl;
    }
}


const int NB_THREAD = 10;
int main(int argc, const char ** argv) {
    int nbComptes = 10;
    int solde = 10000;
    Banque B(nbComptes,solde);
    vector<thread> threads;
    threads.reserve(NB_THREAD);
    for (int inc = 0; inc < NB_THREAD; ++inc) {
        threads.emplace_back(transaction,std::ref(B),inc);
    }

    thread tCompteur(contabilisateur,std::ref(B),nbComptes*solde);


    for (int inc = 0; inc < NB_THREAD; ++inc) {
        threads[inc].join();
    }

    tCompteur.join();


    return 0;
}












//-----------------------TD 4 -------------------------------


/*int main(int argc, const char ** argv) {
    //std::cout << "Hello, World!" << std::endl;
    //std::thread t(work, 1);
    //t.join();
    //createAndWait(100);
    vector<thread> threads;
    vector<thread> threads2;
// TODO : creer des threads qui font jackpot sur un compte
    threads.reserve(NB_THREAD);
    Compte c;
    for(int i = 0 ;i<NB_THREAD;++i){
        threads.emplace_back(jackpot,std::ref(c));
    }

    for (thread & t : threads) {
        t.join();
    }

    threads2.reserve(NB_THREAD);
    for(int i = 0 ;i<NB_THREAD;++i){
        threads2.emplace_back(losepot,std::ref(c));
    }



    for (thread & t : threads2) {
        t.join();
    }
    if(c.getSolde() == NB_THREAD * JP || c.getSolde() == 0)
        std::cout << c.getSolde() << "OK" << std::endl;
    else
        std::cout << c.getSolde() << "KO" << std::endl;
// TODO : tester solde = NB_THREAD * JP
    return 0;
}

 /*void work(int id){
    int temp;

    // initialize random seed:
    srand (time(NULL));

    // generate secret number between 1 and 10:
    temp = rand() % 1000 + 1;
    std::this_thread::sleep_for(std::chrono::milliseconds(temp));
    std::cout << id << std:: endl;
}

void work (int index) {
    std::cout << "started "<< index << std::endl;
    auto r = ::rand() % 1000 ; // 0 to 1 sec
    std::this_thread::sleep_for (std::chrono::milliseconds(r));
    std::cout << "finished "<< index << std::endl;
}
int createAndWait2(int N){
    vector<thread> Threads;
    Threads.reserve(N);
    for (int i = 0; i < N ; ++i) {
        Threads.emplace_back(work,i);
    }
    for (int i = 0; i < N ; ++i) {
        Threads[i].join();
    }
    return 0;
}

int createAndWait(int N){
    std::thread myThreads[N];
    for (int i = 0; i < N ; ++i) {
        myThreads[i] = std::thread(work, i);
    }

    for (int i = 0; i < N ; ++i) {
        myThreads[i].join();
    }
    return 0;
}


const int JP = 10000;
void jackpot(Compte & c) {
    for (int i=0; i < JP; i++)
        c.crediter(1);
}

void losepot(Compte & c) {
    for (int i=0; i < JP / 10; i++)
        c.debiter(10);
}









*/
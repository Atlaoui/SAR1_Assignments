//
// Created by adrien on 26/12/2019.
//



#include <string>
#include "SharedData.h"
#include <thread>
#include <iostream>
#include <zconf.h>
#include <mutex>

std::mutex mutex;
void treatOther(){

}

//Q2)a) le fait de passer le tab ont argument permet de le manipuler avec un grain plus fin
void analyze(const std::vector<double> & tab){

}

void normalize(std::vector<double> & tab){

}


void worker(int id,SharedData &  S){
for(int i=0;i<100;++i){
    treatOther();
    mutex.lock();
    if(id%2==0)
        analyze(S.tab);
    else
        normalize(S.tab);
    mutex.unlock();

}

}


int main(int argc , char ** args){
    std::cout << ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> DEBUT MAIN DE"<< getpid() << "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"<<'\n';
    int N = std::stoi(args[1]);
    std::cout << N << '\n';
    std::vector<std::thread> tab;
    tab.reserve(N);
    SharedData S;
    for (int i = 0; i < N; ++i) {
       tab.emplace_back(worker,i,std::ref(S));
    }


    for (int i = 0; i < N; ++i) {
        tab.at(i).join();
    }
    std::cout << ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> FIN MAIN DE" << getpid() << "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"<<'\n';
    return 1;
}

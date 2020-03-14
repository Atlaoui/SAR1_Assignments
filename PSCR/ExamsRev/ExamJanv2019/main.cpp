#include <iostream>
#include <vector>
#include <thread>
#include <mutex>

const int N = 5;
// temps de reflexion arbitraire
// rend true ou false de façon arbitraire
// la fonction ne sera pas détaillée.
bool think (){
    std::this_thread::sleep_for( std::chrono::milliseconds((rand() % 1000)) );
    return rand() % 2 == 0;;
}
// fonction executée par chacun des thread
// Signature à fournir en Q1.
void philosophe ( std::vector<int> & data ,std::mutex  locks [] ) {
    int temp;
    for (int iter = 0 ; iter < 100 ; iter++) {
       if (think()) {
        if(locks[iter%N].try_lock())
            if(locks[iter+1%N].try_lock()){
                temp = data.at(iter);
                data.at(iter%N) = data.at(iter+1%N);
                data.at(iter+1%N) =temp;
            }
        }
    }
}

// Question 1 : compléter le corps de main.
int main() {
// declarer tab
    std::vector<int> tab;
    tab.reserve(N);
     std::mutex locks[N];

// initialiser tab avec les entiers 0 à N-1
    for(int i = 0;i<N;i++)
        tab.emplace_back(i);
    std::vector<std::thread> threads;
    threads.reserve(N);
    for(int i = 0 ; i<N ;i++)
        threads.emplace_back(philosophe,std::ref(tab),std::ref(locks));



// engendrer N threads exécutant "philosophe" ; leur passer leur indice de création et  tab

// attendre la terminaison de tous les threads
// afficher tab
    return 0;
}
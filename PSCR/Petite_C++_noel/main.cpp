#include <iostream>
#include <vector>
#include <thread>
#include "Renne.h"


void work(pr::Renne & r ){
    r.run();
}
int main() {
    std::cout << "****** DEBUT DU MAIN *******" << std::endl;
    int NB_TOTAL_RENNES=9,i;
        std::vector<std::thread> threads;
    pr::PereNoel P(NB_TOTAL_RENNES);

    std::vector<pr::Renne> rennes;

    rennes.reserve(NB_TOTAL_RENNES);
    threads.reserve(NB_TOTAL_RENNES);

    std::thread P_t(&pr::PereNoel::run,&P);

    for(i=0;i<NB_TOTAL_RENNES;i++) {
        rennes.emplace_back(std::ref(P));
    }
    for(i=0;i<NB_TOTAL_RENNES;i++) {
        threads.emplace_back(&pr::Renne::run,rennes[i]);
    }
    P_t.join();
    for(i=0;i<NB_TOTAL_RENNES;i++)
        threads[i].join();

    std::cout << "****** FIN DU MAIN *******" << std::endl;
    return 0;
}


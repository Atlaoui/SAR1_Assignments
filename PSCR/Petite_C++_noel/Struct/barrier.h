//
// Created by adrien on 03/11/2019.
//

#ifndef PETITE_C___NOEL_BARRIER_H
#define PETITE_C___NOEL_BARRIER_H
#include <mutex>
#include <condition_variable>

class barrier {
    int MAX;
    std::condition_variable cd_att;
    std::mutex m;
    int cpt;
public:
    barrier(int max);
    void att();

};


#endif //PETITE_C___NOEL_BARRIER_H

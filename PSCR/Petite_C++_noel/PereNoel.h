//
// Created by adrien on 03/11/2019.
//

#ifndef PETITE_C___NOEL_PERENOEL_H
#define PETITE_C___NOEL_PERENOEL_H

#include <mutex>
#include <condition_variable>
#include "job.h"
#include "Struct/barrier.h"

namespace pr {

    class PereNoel : public pr::Job{
    private:
        int NB_TOTAL_RENNES;
        int nbRennesAtteles;
        bool busy;
        mutable std::mutex m;
        std::condition_variable cd_per;
        std::condition_variable cd_ren;
        barrier b;
        //Function
        void attelerRenne();
    public:
        PereNoel(int Nbr);
        void sayHello();
        void att_hisse();
        void run () override;

        ~PereNoel() override{}
    };
}

#endif //PETITE_C___NOEL_PERENOEL_H

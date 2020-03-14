//
// Created by adrien on 03/11/2019.
//

#ifndef PETITE_C___NOEL_RENNE_H
#define PETITE_C___NOEL_RENNE_H

#include "job.h"
#include "PereNoel.h"

namespace pr {
    class Renne : public pr::Job {
        PereNoel & p;
        int id;

    public :
         Renne (PereNoel & papa);
        void run () override;
        static int cpt;

        ~Renne() override{}
    };
}

#endif //PETITE_C___NOEL_RENNE_H

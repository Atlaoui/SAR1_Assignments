//
// Created by adrien on 23/12/2019.
//

#ifndef EXAMSREV_CORDE_H
#define EXAMSREV_CORDE_H
#define NORD 0
#define SUD 1
//https://pages.mtu.edu/~shene/FORUM/Taiwan-Forum/ComputerScience/003-OS/PROG/PG3/prog3.html
class Corde{
public:
   /**
    *permet d'acceder a la corde a la position.
    * @param position d'entrer du baboin
    */
    void acceder (int position);
    /**
     * permet de l'acher la corde a la position.
     * @param position
     */

    void lacher(int position);

};

#endif //EXAMSREV_CORDE_H

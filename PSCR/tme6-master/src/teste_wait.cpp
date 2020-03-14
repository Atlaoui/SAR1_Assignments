//
// Created by adrien on 23/11/2019.
//
#include <zconf.h>
#include <iostream>
#include "rsleep.h"

int main () {
    std::cout << ">>>>>>>>>>>>>>>>>>>DEBUT DE MAIN POUR " << getpid() << "<<<<<<<<<<<<<<<<<<<<<<<" << std::endl;
    pid_t pid = fork();

    if(pid!=0) {
        //   wait_till_pid(pid);
        int i =   wait_till_pid(wait_till_pid(pid, 3));
        std::cout << i << std::endl;
    }
    else
        sleep(50);

    std::cout << ">>>>>>>>>>>>>>>>>>>FIN DE MAIN POUR " << getpid() << "<<<<<<<<<<<<<<<<<<<<<<<" << std::endl;
}
/*
 * VadorvsLuke.cpp
 *
 *  Created on: 20 nov. 2019
 *      Author: 3524869
 */
#include <iostream>
#include <unistd.h>
#include <csignal>
#include "rsleep.h"

int PV =4;
std::string name;

void handler(int sig){
	PV--;
    std::cout << name <<" a eu un coup, il lui reste " << PV << std::endl;

}



void attaque (pid_t adversaire) {
	signal(SIGINT,handler);
    std::cout << name << " attaque " << std::endl;
	kill(adversaire,SIGINT);
    randsleep();
}

void defense(){
	signal(SIGINT, SIG_IGN);
    std::cout <<  name << " se protege " << std::endl;
	randsleep();
}


void combat(pid_t adversaire){
	std::cout << "Le combat commence pour " << name << '\n';
	while(true){
        if (PV) {
            defense();
            attaque(adversaire);
        } else {
            std::cout << name << " tombe à terre"<< std::endl ;
            kill(adversaire, SIGUSR1);
            exit(1);
        }
	}
}


int main2(){
	sigset_t setpos;
	sigfillset(&setpos);
	sigdelset(&setpos,SIGINT);

	pid_t pid = fork();

    /* Q5 : On affecte le pid des processus en tant que graine du random */
    srand (getpid());

    /* Un processus qui recoit le signal SIGUSR1 de l'autre processus gagne le duel */
    signal(SIGUSR1, [](int s) {std::cout << name << " gagne le duel ! "<< std::endl ; exit(0);});

	if(pid==0){
	    name = "Luke";
		combat(getppid());
	}else{
		name = "Vador";
		combat(pid);
	}

	return 0;
}

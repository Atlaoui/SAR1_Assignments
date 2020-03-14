/*
 * fork_exo.cpp
 *
 *  Created on: 20 nov. 2019
 *      Author: 3524869
 */




#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

int main1 () {
	const int N = 3;
	std::cout << "main pid=" << getpid() << std::endl;
	int pid;
	bool is_papa = true;
	int cpt_f=0;
	for (int  i=1, j=N; i<=N && j==N  && is_papa; i++ ) {
		pid=fork();
		if(pid==0){
			std::cout << " i:j " << i << ":" << j << std::endl;
			cpt_f=0;
			is_papa=true;
			for (int k=1; k<=i && j==N ; k++) {
				if ( (pid=fork()) == 0) {
					j=0;
					std::cout << " k:j " << k << ":" << j << std::endl;
				}
				else{
					cpt_f++;
				//	is_papa=false;
				}
			}
		}
		else{
			cpt_f++;
            is_papa=false;
		}

	}

	if(pid!=0)
		for(int i = 0 ;i<cpt_f;i++)
			wait(nullptr);


	std::cout << getpid() << " cpt  MAIN FIN " << std::endl;

	return 0;
}

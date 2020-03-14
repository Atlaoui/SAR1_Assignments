#include <iostream>
#include <unistd.h>
#include <sys/wait.h>

int main2 () {
	const int N = 3;
    int pid;
	std::cout << "main pid=" << getpid() << std::endl;

	for (int i=1, j=N; i<=N && j==N && (pid=fork())==0 ; i++ ) {
		std::cout << " i:j:pid " << i << ":" << j << ":" << pid << std::endl;
		for (int k=1; k<=i && j==N ; k++) {
			if ( (pid=fork()) == 0) {
				j=0;
				std::cout << " k:j:pid " << k << ":" << j << ":" << pid <<  std::endl;
			}
		}
	}

	if(pid!=0) {
        wait(nullptr);
        std::cout << ">>>>>>>>>>>>>>>>>>>>> END OF MAIN PAPA <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" << std::endl;
    }
	return 0;
}

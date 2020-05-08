#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>



//tag etat
#define NO_INIT 0
#define INIT 1
#define LOST 2
#define ELU 3
#define CANDIDAT 4
#define NO_CANDIDAT 5
//tag msg
#define TAG_ELEC 6
#define TAG_LEADER 7

int nb_proc,rang,etat;

//identité du leader, initialisé à NULL
int leader ;

//condition d'arret de la boucle
int end_loop=1;

//stock le fait d'etre init ou pas
int init;

int right_neighbor;

void send_msg(int dest, int tag) {
    MPI_Send(&leader, 1 , MPI_INT,dest,tag,MPI_COMM_WORLD);
}

int isInit(){
	int ret = rand() % 2;
	if (ret){
		printf("%d: est candidat a l'élection \n", rang);
        etat=CANDIDAT;
		//ont envois au voisin notre intention
		MPI_Send(&rang, 1, MPI_INT, right_neighbor, TAG_ELEC, MPI_COMM_WORLD);
		return INIT;
	}
    etat=NO_CANDIDAT;
	printf("%d: n'est pas candidat a l'élection \n", rang);
	return NO_INIT;
}


int main(int argc, char *argv[]){
	MPI_Status status;
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);
	MPI_Comm_rank(MPI_COMM_WORLD, &rang);
	//initialisation de la graine
	srand(getpid());
	//qui est le voisin
	right_neighbor = ((rang + 1) % nb_proc);
	init = isInit();
    leader=rang;

	int leader_reciv;
	while (end_loop){
		MPI_Recv(&leader_reciv, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);

		//si ont demande une élection sinon ont recois l'id de L'elu
		if (status.MPI_TAG == TAG_ELEC){
			//cas ou on a un id sup
            if(init==INIT && leader > leader_reciv){
			    printf("%d: detruit le jeton du %d\n",rang,leader_reciv);
		    }
            if(init==NO_INIT || (init==INIT && leader < leader_reciv)){
                etat=LOST;
                leader = leader_reciv;
                send_msg(right_neighbor,TAG_ELEC);
            }
            else if(leader==leader_reciv){
                printf("%d Victory !!  i am the leader \n",rang);
                etat = ELU;
                send_msg(right_neighbor,TAG_LEADER);
            }
		}
		else{
			printf("%d: a apris quue le leader est : %d\n", rang, leader_reciv);
            send_msg(right_neighbor,TAG_LEADER);
            etat = NO_CANDIDAT;
            end_loop=0;
		}
	}
	MPI_Finalize();
}
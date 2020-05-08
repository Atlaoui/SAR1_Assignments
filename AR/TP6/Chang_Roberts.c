#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
//Initiateur ou pas
#define NO_INIT 0
#define INIT 1
#define CHOSEN 2
#define LOST 3

#define OUT 0
#define IN 1

#define TAG_ELEC 4
#define TAGELU 5

typedef struct
{
	int i;
	int initiateur;
	int distance;
} Token;


int nb_proc, rang,k=0;
// le process est init ou pas
int inti, etat,nb_in=0;
//recipion de la réponse
int leader_left, leader_right;
int left_neighbor, right_neighbor;
int end_loop = 1;
int distance =1;

int isInit(){
	int ret = rand() % 2;
	if (ret){
		printf("%d: est candidat a l'élection \n", rang);
		//ont envois au deux voisin notre intention
		MPI_Send(&rang, 1, MPI_INT, right_neighbor, TAG_ELEC, MPI_COMM_WORLD);
		MPI_Send(&rang, 1, MPI_INT, left_neighbor, TAG_ELEC, MPI_COMM_WORLD);
		return INIT;
	}
	printf("%d: n'est pas candidat a l'élection \n", rang);
	return NO_INIT;
}

void send_V(int dest, Token t, int tag){
}

void recv_out(int emetteur, int initiateur, int dist){
	if (inti == NO_INIT || initiateur > rang){
		etat = LOST;
		if (dist > 1){
			if (emetteur == right_neighbor)
				send_V(right_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = dist - 1}, OUT);
			else
				send_V(left_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = dist - 1}, OUT);
		}
		else if (emetteur == right_neighbor)
			send_V(left_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = -1}, IN);
		else
			send_V(left_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = -1}, IN);
	}
	else if (initiateur == rang)
		etat = CHOSEN;
}

void recv_in(int emetteur, int initiateur, int dist){
		if(initiateur != rang){
			if(emetteur == right_neighbor)
				send_V(right_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = dist - 1}, IN);
			else
				send_V(left_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = dist - 1}, IN);
		}
		else{
			nb_in++;
			//si on a recus les deux rep ont initi l'etap d'apres
			if(nb_in==2){
				nb_in=0;
				distance++;
				send_V(right_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = distance}, OUT);
				send_V(left_neighbor, (Token){.i = rang, .initiateur = initiateur, .distance = distance}, OUT);
			}
		}
}

int main(int argc, char *argv[]){
	MPI_Status status;
	MPI_Init(&argc, &argv);
	MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);
	MPI_Comm_rank(MPI_COMM_WORLD, &rang);
	//initialisation de la graine
	srand(getpid());
	//qui sont les voisin
	left_neighbor = rang == 0 ? nb_proc - 1 : (rang - 1 % nb_proc);
	right_neighbor = (rang + 1 % nb_proc);
	inti = isInit();

	int leader_reciv;
	while (end_loop){
		MPI_Recv(&leader_reciv, 1, MPI_INT, MPI_ANY_SOURCE, MPI_ANY_TAG, MPI_COMM_WORLD, &status);

		//si ont demande une élection sinon ont recois l'id de L'elu
		if (status.MPI_TAG == TAG_ELEC){
			
		}
		else{
			printf("%d: a apris quue le leader est : %d\n", rang, leader_reciv);
		}
	}
	MPI_Finalize();
}
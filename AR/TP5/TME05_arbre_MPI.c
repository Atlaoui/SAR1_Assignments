#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

#define TAGINIT 0
#define NB_SITE 6

void simulateur(void) {
    int i;

    /* nb_voisins[i] est le nombre de voisins du site i */
    int nb_voisins[NB_SITE+1] = {-1, 2, 3, 2, 1, 1, 1};
    int min_local[NB_SITE+1] = {-1, 3, 11, 8, 14, 5, 17};

    /* liste des voisins */
    int voisins[NB_SITE+1][3] = {{-1, -1, -1},
    {2, 3, -1}, {1, 4, 5},
    {1, 6, -1}, {2, -1, -1},
    {2, -1, -1}, {3, -1, -1}};

    for(i=1; i<=NB_SITE; i++){
        MPI_Send(&nb_voisins[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(voisins[i],nb_voisins[i], MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(&min_local[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
    }
}

/******************************************************************************/
/* Ajout de TP   */
int min(int a, int b) {return (a<b?a:b);}

int getMin(int voisins[] ,nb_voisins,my_min){
    
}

void calcul_min(int rang){
    MPI_Status status;
    //Ont recois touts les info nécessaire
    int nb_voisins,voisin[3],min_local;
    MPI_Recv(&nb_voisins, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&voisin, 3, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&min_local, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);

    //Ont a recus toutes les information



}

/******************************************************************************/

int main (int argc, char* argv[]) {
    int nb_proc,rang;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

    if (nb_proc != NB_SITE+1) {
        printf("Nombre de processus incorrect !\n");
        MPI_Finalize();
        exit(2);
    }

    MPI_Comm_rank(MPI_COMM_WORLD, &rang);

    if (rang == 0) {
        simulateur();
    } else {
        calcul_min(rang);
    }

    MPI_Finalize();
    return 0;
}

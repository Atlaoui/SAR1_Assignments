#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

#define TAGINIT 0
#define TAGMSG 1
#define NB_SITE 6

int myRank;
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
       // printf("nb = %d\n", nb_voisins[i]);
        MPI_Send(&nb_voisins[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(voisins[i],nb_voisins[i], MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
        MPI_Send(&min_local[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);
    }
}

/******************************************************************************/
/* Ajout de TP   */
int min(int a, int b) {return (a<b?a:b);}

int getMin(int voisins[] ,int nb_voisins,int my_min){

}

int isLeaf(int nb_voisins){
//    printf("nb_voisin = \n", nb_voisins);
    return nb_voisins == 1;
}

void calcul_min(int rang){
    MPI_Status status;
    
    //initialisation
    int i,nb_voisins,voisins[3],min_local,nb_max=3;
    MPI_Recv(&nb_voisins, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&voisins, nb_max, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&min_local, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
   // printf("%d qui a pour min %d a recus toutes les information nécessaire et va commencer le travaille\n", myRank,min_local);
    //Ont a recus toutes les information
    //si je suis une feuille
//    printf("nb voisins a = %d \n",nb_voisins);
    if(nb_voisins ==1){
    //    printf("%d est une feuille et il va envoyer sont min (%d) \n",myRank,min_local);
        MPI_Send(&min_local,1, MPI_INT, voisins[0], TAGMSG, MPI_COMM_WORLD);
    }else{
        int min_recus,nb_recus=0;
        //printf("%d s'appret a recevoir des information de c'est voisin \n",myRank);
        //ont recois que des feuille a cause du >0
        for(i=nb_voisins;i>1;i--){
            MPI_Recv(&min_recus, 1, MPI_INT, MPI_ANY_SOURCE,TAGMSG, MPI_COMM_WORLD, &status);
            min_local = min(min_local,min_recus);
            nb_recus++;
        }
        printf("%d a calculer que sont min est : %d \n",myRank,min_local);
        //on a le min de c'et feuille
        MPI_Send(&min_local,1, MPI_INT, voisins[0], TAGMSG, MPI_COMM_WORLD);

    }
    printf("%d a fini sont algorithme \n",myRank);
}

/******************************************************************************/

int main (int argc, char* argv[]) {
    int nb_proc;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

    if (nb_proc != NB_SITE+1) {
        printf("Nombre de processus incorrect !\n");
        MPI_Finalize();
        exit(2);
    }

    MPI_Comm_rank(MPI_COMM_WORLD, &myRank);

    if (myRank == 0) {
        simulateur();
    } else {
        calcul_min(myRank);
    }

    MPI_Finalize();
    return 0;
}

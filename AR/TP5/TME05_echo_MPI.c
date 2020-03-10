#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

#define TAGINIT 0
/******************************************************************************/
#define TAGDOWN 1
#define TAGUP 2
#define TAGECHO 3
/******************************************************************************/
#define NB_SITE 6

int initiateur  =1;

void simulateur(void) {
   int i;

   /* nb_voisins[i] est le nombre de voisins du site i */
   int nb_voisins[NB_SITE+1] = {-1, 3, 3, 2, 3, 5, 2};
   int min_local[NB_SITE+1] = {-1, 12, 11, 8, 14, 5, 17};

   /* liste des voisins */
   int voisins[NB_SITE+1][5] = {{-1, -1, -1, -1, -1},
            {2, 5, 3, -1, -1}, {4, 1, 5, -1, -1}, 
            {1, 5, -1, -1, -1}, {6, 2, 5, -1, -1},
            {1, 2, 6, 4, 3}, {4, 5, -1, -1, -1}};
                               
   for(i=1; i<=NB_SITE; i++){
      MPI_Send(&nb_voisins[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD);    
      MPI_Send(voisins[i], nb_voisins[i], MPI_INT, i, TAGINIT, MPI_COMM_WORLD);    
      MPI_Send(&min_local[i], 1, MPI_INT, i, TAGINIT, MPI_COMM_WORLD); 
   }
}
/******************************Ajout Perso*************************************/
int min(int a, int b) {return (a<b?a:b);}

void calcul_min(int rang){
    //initialisation
    MPI_Status status;
    int i,nb_voisins,min_local;
    MPI_Recv(&nb_voisins, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    int voisins[nb_voisins];
    MPI_Recv(&voisins, nb_voisins, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
    MPI_Recv(&min_local, 1, MPI_INT, 0, TAGINIT, MPI_COMM_WORLD, &status);
   
   //Si initiateur (le 1er papa aussi)
   int min_node;
   if(rang==initiateur){
      printf("%d: est le noeud init avec min = %d \n",rang,min_local);
      for(i=0;(i<nb_voisins && voisins[i]!=-1);i++)
         MPI_Send(&min_node,1,MPI_INT,voisins[i],TAGDOWN,MPI_COMM_WORLD);
      
       printf("%d: va envoyer sont min au petit \n",rang);
      for(i=0;i<nb_voisins;i++){
         MPI_Recv(&min_node, 1, MPI_INT, MPI_ANY_SOURCE,TAGUP, MPI_COMM_WORLD, &status);
         min_local=min(min_local,min_node);
      }
   }else{
      int father = -1;
      MPI_Recv(&min_node,1,MPI_INT,MPI_ANY_SOURCE,TAGDOWN,MPI_COMM_WORLD,&status);
      //recuperation du Father id
      father=status.MPI_SOURCE;
      printf("%d: a pour father %d  et a un min = %d \n",rang,father,min_local);
      for(i=0;(i<nb_voisins && voisins[i]!=-1);i++)
         if(voisins[i]!=father)
            MPI_Send(&min_node,1,MPI_INT,voisins[i],TAGDOWN,MPI_COMM_WORLD);
      
      //ont calcule le min
      printf("%d:va calculer sont min\n",rang);
      for(i=0;i<nb_voisins-1;i++){
         MPI_Recv(&min_node, 1, MPI_INT, MPI_ANY_SOURCE,TAGUP, MPI_COMM_WORLD, &status);
         min_local=min(min_local,min_node);
          printf("%d:a recuperer le min\n",min_node);
      }
      //ont renvois la rep au papa
      MPI_Send(&min_local,1,MPI_INT,father,TAGUP,MPI_COMM_WORLD);    
   }
   printf("%d: est a la fin de sont exec  avec min = %d \n",rang,min_local);
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

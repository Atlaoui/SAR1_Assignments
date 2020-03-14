//exclusion mutel avec l'algo de l'anneaux

#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

#define TAGINIT 0
#define NB_DEMANDE_SC 3
int main (int argc, char* argv[]) {
   int nb_proc,rang;
   MPI_Init(&argc, &argv);
   MPI_Comm_size(MPI_COMM_WORLD, &nb_proc);

   if (nb_proc == 1) {
      printf("Nombre de processus incorrect !\n");
      MPI_Finalize();
      exit(2);
   }  
   MPI_Comm_rank(MPI_COMM_WORLD, &rang);

   MPI_Finalize();
   return 0;
}

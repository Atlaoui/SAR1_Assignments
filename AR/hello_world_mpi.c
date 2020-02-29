#include <mpi.h>
#include <stdio.h>
//https://intellij-support.jetbrains.com/hc/en-us/community/posts/205822679-Execute-program-with-mpirun

int main(int argc, char **argv)
{
    int ierr, num_procs, my_id;

       ierr = MPI_Init(&argc, &argv);

       /* find out MY process ID, and how many processes were started. */

       ierr = MPI_Comm_rank(MPI_COMM_WORLD, &my_id);
       ierr = MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

       printf("Hello world! I'm process %i out of %i processes\n",
          my_id, num_procs);

       ierr = MPI_Finalize();;
   return 0;
}

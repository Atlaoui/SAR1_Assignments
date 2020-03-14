
#include <unistd.h>
#include <iostream>

int main(int argc, char *argv[])
{
    int fd[2];
    int val = 0;
              // create pipe descriptors
    pipe(fd);

    // fork() returns 0 for child process, child-pid for parent process.
    if (fork() != 0)
    {


        // send the value on the write-descriptor.
        val = getpid();
        write(fd[1], &val, sizeof(val));
       std::cout << " Parent "<< getpid()  << " send value "  << val << '\n';


    }
    else
    {   // child: reading only, so close the write-descriptor
      //  close(fd[1]);

        // now read the data (will block)
        read(fd[0], &val, sizeof(val));
        std::cout << "Chiled "<< getpid()  << "  value "  << val << '\n';

        // close the read-descriptor
   //     close(fd[0]);
    }
    return 0;
}
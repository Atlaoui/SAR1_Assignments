//
// Created by adrien on 27/12/2019.
//

#include <unistd.h>
#include <iostream>
#include <sys/mman.h>
#include <sys/wait.h>




using namespace std;
class list {
    int data;
    list * next;
public :
    list (int data, list * next=nullptr) : data(data),next(next){}
    void add (int val) {
        if (next==nullptr)
            next = new list(val);
        else
            next->add(val);
    }
    void print (ostream & os) {
        os << data << "->" ;
        if (next != nullptr)
            next->print(os);
    }
};
int main () {
    list * head = (list *) mmap(0, sizeof(list) ,PROT_READ|PROT_WRITE,MAP_ANONYMOUS|
                                                                      MAP_SHARED,-1,0);
    if (fork()) {
        // proc B : affiche
        wait(nullptr);
        head->print(cout);
    } else {
        // proc A : construit
        list * build = new list(0);
        for (int i=1; i < 10 ; i++) {
            build->add(i);
        }
        *head = *build;
    }
    return 0;
}
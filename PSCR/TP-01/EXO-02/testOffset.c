#include "../EXO-03/commit.h"
#include<stdio.h>
#include <stddef.h>


//
// Created by adrien on 04/02/2020.
//
int main (){
    struct version v = {.major = 3,
            .minor = 5,
            .flags = 0};


    struct commit c = {.id = 1,
            .version = v,
            .comment = "hahahaha"};


    printf(" %s ",c.comment);


    void * p = &c.version;
    p-=8;
    struct commit * c2 = (struct commit *) p;
    printf("adresse : %d %d %d", &c , &c.version , c.id);

    return 0;
}

#ifndef VERSION_H
#define VERSION_H
//Quel est l’empreinte mémoire d’une structure struct version ? Cet encombrement est-il optimum ?
//Non car un int est suffisant a mon sense
struct version {

	unsigned short major;
    char flags;
	unsigned long minor;

};

int is_unstable(struct version *v);

int is_unstable_bis(struct version *v );

void display_version(struct version *v);


int cmp_version(struct version *v, unsigned short major, unsigned long minor);

#endif

#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object man_3agle;

/* Global prototypes */ 
ILP_Object ilp__man_3agle(ILP_Closure ilp_useless
,
    ILP_Object n1);

/* Global functions */ 

ILP_Object ilp__man_3agle(ILP_Closure ilp_useless
,
    ILP_Object n1) {
{ 
  ILP_Object ilptmp2275; 
  ILP_Object ilptmp2276; 
ilptmp2275 = n1; 
ilptmp2276 = ILP_Integer2ILP(2); 
return ILP_Divide(ilptmp2275, ilptmp2276);
} 
}
struct ILP_Closure man_3agle_closure_object = { 
   &ILP_object_Closure_class, 
   { { ilp__man_3agle, 
       1, 
       { NULL } } } 
}; 


/* Classes */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp2277; 
{ 
  ILP_Object ilptmp2278; 
  ILP_Object ilptmp2279; 
ilptmp2278 = ILP_Integer2ILP(2); 
ilptmp2279 = ILP_Integer2ILP(5490); 
ilptmp2277 = ILP_Times(ilptmp2278, ilptmp2279);
} 
return ilp__man_3agle(NULL , ilptmp2277);
}

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 

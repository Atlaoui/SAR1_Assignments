#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object bar;
ILP_Object foo;

/* Global prototypes */ 
ILP_Object ilp__foo(ILP_Closure ilp_useless
,
    ILP_Object x1);
ILP_Object ilp__bar(ILP_Closure ilp_useless
,
    ILP_Object y2);

/* Global functions */ 

ILP_Object ilp__foo(ILP_Closure ilp_useless
,
    ILP_Object x1) {
{ 
  ILP_Object ilptmp1358; 
  ILP_Object ilptmp1359; 
ilptmp1358 = ILP_Integer2ILP(2); 
ilptmp1359 = x1; 
return ILP_Times(ilptmp1358, ilptmp1359);
} 
}
struct ILP_Closure foo_closure_object = { 
   &ILP_object_Closure_class, 
   { { ilp__foo, 
       1, 
       { NULL } } } 
}; 

ILP_Object ilp__bar(ILP_Closure ilp_useless
,
    ILP_Object y2) {
{ 
  ILP_Object ilptmp1360; 
  ILP_Object ilptmp1361; 
ilptmp1360 = ILP_Integer2ILP(3); 
{ 
  ILP_Object ilptmp1362; 
ilptmp1362 = y2; 
ilptmp1361 = ilp__foo(NULL , ilptmp1362);
}
return ILP_Plus(ilptmp1360, ilptmp1361);
} 
}
struct ILP_Closure bar_closure_object = { 
   &ILP_object_Closure_class, 
   { { ilp__bar, 
       1, 
       { NULL } } } 
}; 


/* Classes */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp1363; 
ilptmp1363 = ILP_Integer2ILP(556); 
return ilp__bar(NULL , ilptmp1363);
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

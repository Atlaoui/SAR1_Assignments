#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;
ILP_Object newline;
ILP_Object makeVector;
ILP_Object vectorLength;
ILP_Object vectorGet;

/* Global prototypes */ 

/* Global functions */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp1; 
{ 
  ILP_Object ilptmp2; 
{ 
  ILP_Object ilptmp3; 
  ILP_Object ilptmp4; 
ilptmp3 = ILP_Integer2ILP(5); 
ilptmp4 =  ILP_String2ILP("bonjour"); 
ilptmp2 = ILP_make_vector(ilptmp3, ilptmp4);
}

  {
    ILP_Object v1 = ilptmp2;
{ 
  ILP_Object ilptmp5; 
{ 
  ILP_Object ilptmp6; 
  ILP_Object ilptmp7; 
ilptmp6 = v1; 
ilptmp7 = ILP_Integer2ILP(1); 
ilptmp5 = ILP_vector_get(ilptmp6, ilptmp7);
}
ilptmp1 = ILP_print(ilptmp5);
}

  }
}
{ 
ilptmp1 = ILP_newline();
}
{ 
  ILP_Object ilptmp8; 
ilptmp8 = ILP_Integer2ILP(2); 

  {
    ILP_Object x2 = ilptmp8;
{ 
  ILP_Object ilptmp9; 
{ 
  ILP_Object ilptmp10; 
  ILP_Object ilptmp11; 
ilptmp10 = ILP_Integer2ILP(10); 
ilptmp11 = x2; 
ilptmp9 = ILP_make_vector(ilptmp10, ilptmp11);
}

  {
    ILP_Object v13 = ilptmp9;
{ 
  ILP_Object ilptmp12; 
{ 
  ILP_Object ilptmp13; 
ilptmp13 = v13; 
ilptmp12 = ILP_vector_length(ilptmp13);
}
ilptmp1 = ILP_print(ilptmp12);
}

  }
}

  }
}
return ilptmp1; 
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

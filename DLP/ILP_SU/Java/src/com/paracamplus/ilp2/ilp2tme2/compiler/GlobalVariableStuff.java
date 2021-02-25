package com.paracamplus.ilp2.ilp2tme2.compiler;

import com.paracamplus.ilp1.compiler.Primitive;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;

public class GlobalVariableStuff {
	 public static void fillGlobalVariables (IGlobalVariableEnvironment env) {
		 com.paracamplus.ilp1.compiler.GlobalVariableStuff.fillGlobalVariables(env);
		 env.addGlobalFunctionValue(new Primitive("sinus", "ILP_sinus",1));
	        env.addGlobalFunctionValue(new Primitive("makeVector", "ILP_make_vector",2));
	        env.addGlobalFunctionValue(new Primitive("vectorGet", "ILP_vector_get",2));
	        env.addGlobalFunctionValue(new Primitive("vectorLength", "ILP_vector_length",1));
		 
	 }
}

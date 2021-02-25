package com.paracamplus.ilp3.ilp3Tme7.interpreter;

import java.io.Writer;

import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp3.ilp3Tme7.interpreter.primitive.Resume;
import com.paracamplus.ilp3.ilp3Tme7.interpreter.primitive.Yield;


public class GlobalVariableStuff extends com.paracamplus.ilp3.interpreter.GlobalVariableStuff{
	 public static void fillGlobalVariables (IGlobalVariableEnvironment env,Writer out ) {
		 com.paracamplus.ilp3.interpreter.GlobalVariableStuff.fillGlobalVariables(env, out);
		 env.addGlobalVariableValue(new Yield());
		 env.addGlobalVariableValue(new Resume());
	 }
}

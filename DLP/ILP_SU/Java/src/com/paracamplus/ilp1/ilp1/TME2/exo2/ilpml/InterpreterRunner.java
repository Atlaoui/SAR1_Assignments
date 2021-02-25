package com.paracamplus.ilp1.ilp1.TME2.exo2.ilpml;

import com.paracamplus.ilp1.ilp1.TME2.exo2.ast.CountConstant;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;


public class InterpreterRunner extends com.paracamplus.ilp1.interpreter.test.InterpreterRunner{

	protected CountConstant CountConstant;
    public void setInterpreter(CountConstant interpreter)  {
    	this.CountConstant = interpreter;
   }
    @Override
    public void interpretProgram(IASTprogram program) throws EvaluationException {
    	if (CountConstant == null) {
    		throw new EvaluationException("interpreter not set");
    	}
        ILexicalEnvironment lexenv = new EmptyLexicalEnvironment();
        result = CountConstant.visit(program, lexenv);
        printing = stdout.toString();
        System.out.println("  Value: " + result);
        if ( ! "".equals(printing) ) {
            System.out.println("  Printing: " + printing);
        }    	
    }
}

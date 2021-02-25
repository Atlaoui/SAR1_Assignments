package com.paracamplus.ilp2.partiel2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.Function;
import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp2.partiel2018.interfaces.ICountingFunction;

public class CountingFunction extends Function implements ICountingFunction {

	private int counter;

	public CountingFunction(IASTvariable[] variables, IASTexpression body, ILexicalEnvironment lexenv) {
		super(variables, body, lexenv);
		// TODO Auto-generated constructor stub
	}

	@Override public int getCounter() { return counter; }
	
	@Override
	public Object apply(Interpreter interpreter, Object[] argument) throws EvaluationException {
		counter++;
		return super.apply(interpreter, argument);
	}

}

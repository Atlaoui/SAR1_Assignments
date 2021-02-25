package com.paracamplus.ilp2.partiel2018.parser;

import com.paracamplus.ilp1.interpreter.EmptyLexicalEnvironment;
import com.paracamplus.ilp1.interpreter.Function;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;
import com.paracamplus.ilp2.interfaces.IASTfunctionDefinition;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.partiel2018.ast.CountingFunction;
import com.paracamplus.ilp2.partiel2018.interfaces.IASTcountingFunctionDefinition;
import com.paracamplus.ilp2.partiel2018.interfaces.ICountingFunction;

public class Interpreter extends com.paracamplus.ilp2.interpreter.Interpreter {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment);
	}

	@Override
	public Object visit(IASTprogram iast, ILexicalEnvironment lexenv) 
			throws EvaluationException {
		for ( IASTfunctionDefinition fd : iast.getFunctionDefinitions() ) {
			Object f = this.visit(fd, lexenv);
			String v = fd.getName();
			getGlobalVariableEnvironment().addGlobalVariableValue(v, f);
		}
		try {
			return iast.getBody().accept(this, lexenv);
		} catch (Exception exc) {
			return exc;
		}finally {
			printCounters(iast);
		}
	}

	public Invocable visit(IASTcountingFunctionDefinition iast, ILexicalEnvironment lexenv)
			throws EvaluationException
	{
		Invocable fun;
		if ( iast.isCounting() )
			fun = new CountingFunction(iast.getVariables(),
					iast.getBody(),
					new EmptyLexicalEnvironment());
		else
			fun = new Function(iast.getVariables(),
					iast.getBody(),
					new EmptyLexicalEnvironment());
		return fun;
	}


	private void printCounters(IASTprogram iast) throws EvaluationException{

		UnaryPrimitive print =
				(UnaryPrimitive) getGlobalVariableEnvironment().getGlobalVariableValue("print");
		for ( IASTfunctionDefinition fd : iast.getFunctionDefinitions() )
		{
			Object o = getGlobalVariableEnvironment().getGlobalVariableValue(fd.getName());
			if (o instanceof ICountingFunction)
			{
				ICountingFunction f = (ICountingFunction) o;
				print.apply("La fonction " + fd.getName() +" a été appelée " + f.getCounter() + " fois.");
			}
		}

	}

}

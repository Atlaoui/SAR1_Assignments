package com.paracamplus.ilp4.Examen2019.ILPML;

import java.util.Vector;

import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTvisitor;
import com.paracamplus.ilp4.interfaces.IASTclassDefinition;
import com.paracamplus.ilp4.interfaces.IASTfieldRead;
import com.paracamplus.ilp4.interfaces.IASTfieldWrite;
import com.paracamplus.ilp4.interfaces.IASTinstantiation;
import com.paracamplus.ilp4.interfaces.IASTmethodDefinition;
import com.paracamplus.ilp4.interfaces.IASTself;
import com.paracamplus.ilp4.interfaces.IASTsend;
import com.paracamplus.ilp4.interfaces.IASTsuper;
import com.paracamplus.ilp4.interpreter.ILP9Instance;
import com.paracamplus.ilp4.interpreter.interfaces.IClass;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;
import com.paracamplus.ilp4.interpreter.interfaces.IMethod;


public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter implements  IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment,
			IClassEnvironment classEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
	
	}

	@Override
	public Object visit(IASTautoclose iast, ILexicalEnvironment data) throws EvaluationException {
		Object eval =  iast.getExpr1().accept(this, data);
		if(eval instanceof Exception)
			return null;
		
		if(!(eval instanceof ILP9Instance))
			return null;
		//la on est sur que exp1 est une instance de classe
		ILP9Instance inst  = (ILP9Instance) eval;
		
		System.out.println(1);
		
		inst.send(this, "close", new Vector().toArray());
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+1);
		Object eval2 = iast.getExpr2().accept(this, data);
		
		
		return null;
	}

	@Override
	public Object visit(IASTprogram iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("1 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(com.paracamplus.ilp4.interfaces.IASTprogram iast, ILexicalEnvironment lexenv)
			throws EvaluationException {
		System.out.println("2 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public IClass visit(IASTclassDefinition iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("3 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public IMethod visit(IASTmethodDefinition iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("4 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTinstantiation iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("5 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTfieldRead iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("6 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTfieldWrite iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("7 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTsend iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("8 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTself iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("9 "+iast.toString());
		return super.visit(iast, lexenv);
	}

	@Override
	public Object visit(IASTsuper iast, ILexicalEnvironment lexenv) throws EvaluationException {
		System.out.println("10 "+iast.toString());
		return super.visit(iast, lexenv);
	}

}

package com.paracamplus.ilp4.Examen2018.parser;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTsuperArgs;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTvisitor;

import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;
import com.paracamplus.ilp4.interpreter.interfaces.IMethod;
import com.paracamplus.ilp4.interpreter.interfaces.ISuperCallInformation;


public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter 
implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException> {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment,
			IClassEnvironment classEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
		// TODO Auto-generated constructor stub
	}

	/*	@Override
	public Object visit(IASTsuperArgs iast, ILexicalEnvironment lexenv) throws EvaluationException {
		// System.out.println(iast.toString());
		 ISuperCallInformation isci = 
        		 ((com.paracamplus.ilp4.interpreter.interfaces.ISuperCallLexicalEnvironment) lexenv).getSuperCallInformation();
         IMethod supermethod = isci.getSuperMethod();
         Object [] args = new Object[2];
         System.out.println(supermethod.getArity());
         args[0] =  iast.getArgs().accept(this, lexenv);
         return supermethod.apply(this, args);
	}*/
    @Override
    public Object visit(IASTsuperArgs iast, ILexicalEnvironment data) throws EvaluationException {
        ISuperCallInformation isci = 
                ((com.paracamplus.ilp4.interpreter.interfaces.ISuperCallLexicalEnvironment) data).getSuperCallInformation();
        IMethod supermethod = isci.getSuperMethod();
        java.util.ArrayList<Object> expressions = new java.util.ArrayList<>();
        expressions.add(isci.getArguments()[0]);
     //   for(int i = 0;i<iast.getArgs().length;i++)
       // {
        	
      //      expressions.add(iast.getExpressions()[i].accept(this, data));
      //  }
        return supermethod.apply(this,expressions.toArray());
    }
}

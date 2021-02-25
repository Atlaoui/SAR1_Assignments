package com.paracamplus.ilp2.lip2tme6.interpreteur;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.interfaces.IAST;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp2.interfaces.IASTassignment;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTloop;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.interfaces.IASTvisitor;

public class CopyTransform<Data> implements IASTvisitor<IASTexpression,Data,CompilationException>{
	IASTfactory fact ;
	public CopyTransform(IASTfactory fact) {
		this.fact=fact;
	}
	@Override
	public IASTexpression visit(IASTalternative iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newAlternative(iast.getCondition(), iast.getConsequence(), iast.getAlternant());
	}
	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newBinaryOperation(iast.getOperator(),iast.getLeftOperand(), iast.getLeftOperand());
	}
	@Override
	public IASTexpression visit(IASTblock iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newBlock(iast.getBindings(), iast.getBody());
	}
	@Override
	public IASTexpression visit(IASTboolean iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}
	@Override
	public IASTexpression visit(IASTfloat iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}
	@Override
	public IASTexpression visit(IASTinteger iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}
	@Override
	public IASTexpression visit(IASTinvocation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newInvocation(iast.getFunction(),iast.getArguments());
	}
	@Override
	public IASTexpression visit(IASTsequence iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newSequence(iast.getExpressions());
	}
	@Override
	public IASTexpression visit(IASTstring iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}
	@Override
	public IASTexpression visit(IASTunaryOperation iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newUnaryOperation(iast.getOperator(),iast.getOperand());
	}
	@Override
	public IASTexpression visit(IASTvariable iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return iast;
	}
	@Override
	public IASTexpression visit(IASTassignment iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newAssignment(iast.getVariable(), iast.getExpression());
	}
	@Override
	public IASTexpression visit(IASTloop iast, Data data) throws CompilationException {
		// TODO Auto-generated method stub
		return fact.newLoop(iast.getCondition(), iast.getBody());
	}

	
	
	public IASTprogram visit(IASTprogram iast, Data data) throws EvaluationException, CompilationException {
		//System.out.println(factory.newProgram(iast.getBody().getClass()));
        return (IASTprogram) fact.newProgram(iast.getBody().accept(this, data));
    }
	

}

package com.paracamplus.ilp2.partiel2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.ast.ASTfunctionDefinition;

import com.paracamplus.ilp2.partiel2018.interfaces.IASTcountingFunctionDefinition;

public class ASTcountingFunctionDefinition extends ASTfunctionDefinition implements IASTcountingFunctionDefinition{
	private boolean counting;
	public ASTcountingFunctionDefinition(IASTvariable functionVariable, IASTvariable[] variables, IASTexpression body , boolean counting) {
		super(functionVariable, variables, body);
		this.counting=counting;
	}

	@Override
	public boolean isCounting() {
		// TODO Auto-generated method stub
		return counting;
	}



}

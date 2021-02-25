package com.paracamplus.ilp1.ilp1.TME1.ast;

import com.paracamplus.ilp1.ilp1.TME1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class ASTsequence extends com.paracamplus.ilp1.ast.ASTsequence implements IASTsequence {

	public ASTsequence(IASTexpression[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IASTexpression[] getAllButLastInstructions() throws EvaluationException {
		IASTexpression[] ret = new IASTexpression[super.expressions.length-1];
		for(int i = 0 , len = ret.length ;i<len;i++)
			ret[i] = super.expressions[i];		
		return ret;
	}



}

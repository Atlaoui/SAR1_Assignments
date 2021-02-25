package com.paracamplus.ilp2.partiel2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2018.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory implements IASTfactory {

	@Override
	public ASTcountingFunctionDefinition newCountingFunctionDefinition(IASTvariable functionVariable,
			IASTvariable[] variables, IASTexpression body, boolean counting) {	
		return new ASTcountingFunctionDefinition(functionVariable,variables,body,counting);
	}

}

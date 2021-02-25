package com.paracamplus.ilp2.partiel2018.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp2.partiel2018.ast.ASTcountingFunctionDefinition;

public interface IASTfactory extends com.paracamplus.ilp2.interfaces.IASTfactory{
	ASTcountingFunctionDefinition newCountingFunctionDefinition(IASTvariable functionVariable, IASTvariable[] variables,IASTexpression body, boolean counting);
}

package com.paracamplus.ilp3.ilp3Tme7.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp3.ilp3Tme7.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp3.ast.ASTfactory implements IASTfactory{
	@Override
	public IASTexpression newCostart(IASTexpression cour, IASTexpression[] arguments) {
		// TODO Auto-generated method stub
		return new ASTcostart(cour,arguments);
	}
}

package com.paracamplus.ilp2.lip2tme4.exo2.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTfactory;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTunless;

public class ASTfactory extends com.paracamplus.ilp2.ast.ASTfactory implements IASTfactory{

	@Override
	public IASTunless newUnless(IASTexpression condition, IASTexpression body) {
		// TODO Auto-generated method stub
		return new ASTunless(condition,body);
	}

}

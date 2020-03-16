package com.paracamplus.ilp4.Examen2019.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTautoclose;
import com.paracamplus.ilp4.Examen2019.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory implements IASTfactory{

	@Override
	public IASTautoclose newAutoclose(IASTexpression expr1, IASTexpression expr2) {
		// TODO Auto-generated method stub
		return new ASTautoclose(expr1,expr2);
	}

}

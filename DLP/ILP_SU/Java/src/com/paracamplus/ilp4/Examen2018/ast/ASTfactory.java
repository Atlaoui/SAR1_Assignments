package com.paracamplus.ilp4.Examen2018.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTfactory;
import com.paracamplus.ilp4.Examen2018.interfaces.IASTsuperArgs;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory implements IASTfactory{

	@Override
	public IASTsuperArgs newASTsuperArgs(IASTexpression args) {
		return new ASTsuperArgs(args);
	}
}

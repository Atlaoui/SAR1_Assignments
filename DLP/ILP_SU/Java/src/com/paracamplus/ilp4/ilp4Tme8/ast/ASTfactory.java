package com.paracamplus.ilp4.ilp4Tme8.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTfactory;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTwriteProperty;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory implements IASTfactory {
	public IASTreadProperty newASTreadProperty(IASTexpression proprety  , IASTexpression target) {
		return new ASTreadProperty(proprety, target);
	}

	@Override
	public IASTwriteProperty newASTwriteProperty(IASTexpression proprety, IASTexpression target, IASTexpression value) {
		// TODO Auto-generated method stub
		return new ASTwriteProperty(proprety,target,value);
	}

	@Override
	public IASThasProperty newASThasProperty(IASTexpression proprety, IASTexpression target) {
		// TODO Auto-generated method stub
		return new ASThasProperty(proprety,target);
	}
}

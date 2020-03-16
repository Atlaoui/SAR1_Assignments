package com.paracamplus.ilp4.ilp4Tme8.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp4.interfaces.IASTfactory{
	public IASTreadProperty newASTreadProperty(IASTexpression proprety  , IASTexpression target);
	public IASTwriteProperty newASTwriteProperty(IASTexpression proprety  , IASTexpression target ,IASTexpression value);
	public IASThasProperty newASThasProperty(IASTexpression proprety  , IASTexpression target);
}

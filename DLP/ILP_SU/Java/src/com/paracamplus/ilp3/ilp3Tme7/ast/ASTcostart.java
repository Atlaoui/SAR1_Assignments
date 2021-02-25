package com.paracamplus.ilp3.ilp3Tme7.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp3.ilp3Tme7.interfaces.IASTcostart;
import com.paracamplus.ilp3.ilp3Tme7.interfaces.IASTvisitor;

public class ASTcostart extends ASTexpression implements IASTcostart{

	private final IASTexpression couroutine;
	private final IASTexpression[] arguments;


	public ASTcostart(IASTexpression expr ,IASTexpression[] args) {
		couroutine=expr;
		arguments=args;
	}


	@SuppressWarnings("unchecked")
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return ((IASTvisitor<Result, Data, Anomaly>)visitor).visit(this, data);
	}

	@Override
	public IASTexpression getCouroutine() {
		// TODO Auto-generated method stub
		return couroutine;
	}

	@Override
	public IASTexpression[] getArguments() {
		// TODO Auto-generated method stub
		return arguments;
	}

}

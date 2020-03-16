package com.paracamplus.ilp4.lip4Tme10.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp4.lip4Tme10.interfaces.IASTvisitor;
import com.paracamplus.ilp4.lip4Tme10.interfaces.IASTexists;

public class ASTexists extends ASTexpression implements IASTexists{
	
	private final IASTvariable var;

	public ASTexists(IASTvariable var) {
		this.var = var;
	}

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept( com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IASTvariable getVariable() {
		// TODO Auto-generated method stub
		return var;
	}

}

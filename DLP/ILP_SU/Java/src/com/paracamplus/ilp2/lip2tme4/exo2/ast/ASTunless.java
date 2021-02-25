package com.paracamplus.ilp2.lip2tme4.exo2.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTvisitor;
import com.paracamplus.ilp2.lip2tme4.exo2.interfaces.IASTunless;

public class ASTunless extends ASTexpression implements IASTunless {
	
	public ASTunless(IASTexpression condition,IASTexpression body) {
		this.condition = condition;
		this.body = body;
	}
	private final IASTexpression condition;
	private final IASTexpression body;

	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		// TODO Auto-generated method stub
		return ((IASTvisitor<Result, Data, Anomaly>)visitor).visit(this, data);
	}

	@Override
	public IASTexpression getCondition() {
		// TODO Auto-generated method stub
		return condition;
	}

	@Override
	public IASTexpression getBody() {
		// TODO Auto-generated method stub
		return body;
	}

}

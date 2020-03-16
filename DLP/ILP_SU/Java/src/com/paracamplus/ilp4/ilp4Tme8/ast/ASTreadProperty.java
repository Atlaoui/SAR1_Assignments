package com.paracamplus.ilp4.ilp4Tme8.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;

import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4Tme8.interfaces.IASTvisitor;

public class ASTreadProperty extends ASTexpression implements IASTreadProperty {
	
	private final IASTexpression property;
	private final IASTexpression target;
	
	public ASTreadProperty (IASTexpression property, IASTexpression target) {
        this.property = property;
        this.target = target;
    }
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}

	@Override
	public IASTexpression getTarget() {
		// TODO Auto-generated method stub
		return target;
	}

	@Override
	public IASTexpression getProperty() {
		// TODO Auto-generated method stub
		return property;
	}

}

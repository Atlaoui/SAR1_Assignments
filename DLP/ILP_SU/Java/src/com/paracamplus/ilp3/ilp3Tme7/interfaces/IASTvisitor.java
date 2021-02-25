package com.paracamplus.ilp3.ilp3Tme7.interfaces;



public interface IASTvisitor<Result, Data, Anomaly extends Throwable> extends com.paracamplus.ilp3.interfaces.IASTvisitor<Result, Data, Anomaly > {
	Result visit(IASTcostart iast, Data data) throws Anomaly;
}

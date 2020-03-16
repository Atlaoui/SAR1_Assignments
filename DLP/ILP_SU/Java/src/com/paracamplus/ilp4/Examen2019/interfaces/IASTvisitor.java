package com.paracamplus.ilp4.Examen2019.interfaces;


public interface IASTvisitor<Result, Data, Anomaly extends Throwable>
extends com.paracamplus.ilp4.interfaces.IASTvisitor<Result, Data, Anomaly>{	
	Result visit(IASTautoclose iast, Data data) throws Anomaly;
}

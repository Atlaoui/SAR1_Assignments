package com.paracamplus.ilp3.ilp3Tme7.interpreter.primitive;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.Primitive;
import com.paracamplus.ilp3.ilp3Tme7.interpreter.CoroutineInstance;

public class Yield extends Primitive{

	public Yield() {
		super("yield");
	}

	@Override
	public Object apply() throws EvaluationException {
		System.out.println("Yiled");
		CoroutineInstance c  = (CoroutineInstance) Thread.currentThread();
		c.yieldCoroutine();
		return null;
	}

	@Override
	public int getArity() {
		// TODO Auto-generated method stub
		return 0;
	}
}

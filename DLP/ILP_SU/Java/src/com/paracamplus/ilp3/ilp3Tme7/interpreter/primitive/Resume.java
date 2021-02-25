package com.paracamplus.ilp3.ilp3Tme7.interpreter.primitive;



import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;
import com.paracamplus.ilp3.ilp3Tme7.interpreter.CoroutineInstance;

public class Resume extends UnaryPrimitive{


	
	public Resume() {
		super("resume");
	}

	@Override
	public Object apply(Object arg1) throws EvaluationException {
		System.out.println("Resume");
		if(arg1 instanceof CoroutineInstance) {
			CoroutineInstance c = (CoroutineInstance) arg1;
			System.out.println(c.resumeCoroutine());
		}
			
		return null;
	}

}

package com.paracamplus.ilp2.ilp2tme2.interpreter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends  UnaryPrimitive{

	public Sinus() {
		super("sinus");

	}

	@Override
	public Object apply(Object arg1) throws EvaluationException {
		if (arg1 instanceof BigDecimal) {
			BigDecimal v = (BigDecimal)arg1;
			return new BigDecimal(Math.sin(v.doubleValue()), MathContext.DECIMAL64);
		}
		if (arg1 instanceof BigInteger) {
			BigInteger v = (BigInteger)arg1;
			return new BigDecimal(Math.sin(v.doubleValue()), MathContext.DECIMAL64);
		}
		throw new EvaluationException("Le paramètre passé à sinus n'est pas valide.");
	}
}

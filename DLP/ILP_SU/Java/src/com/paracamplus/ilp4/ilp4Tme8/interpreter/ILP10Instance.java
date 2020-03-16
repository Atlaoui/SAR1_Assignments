package com.paracamplus.ilp4.ilp4Tme8.interpreter;

import java.util.HashMap;
import java.util.Map;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp4.interpreter.ILP9Instance;
import com.paracamplus.ilp4.interpreter.interfaces.IClass;

public class ILP10Instance extends ILP9Instance {
	private Map<String, Object> props = new HashMap<String,Object>();
	public ILP10Instance(IClass clazz, Object[] fields) throws EvaluationException {
		super(clazz, fields);
	}
	
	@Override
	public Object write(String fieldName, Object value){
		try {
			return super.write(fieldName, value);
		} catch (EvaluationException e) {
			return props.put(fieldName, value);
		}
    }
	
	@Override
	public Object read(String fieldName){
		
		try {
			return super.read(fieldName);
		} catch (EvaluationException e) {
			return props.get(fieldName);
		}
		
    }
	
	public boolean hasPropreties(String fieldName) {
		return props.containsKey(fieldName);
	}


}

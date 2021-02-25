package com.paracamplus.ilp2.lip2tme6.interpreteur;


import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp2.interfaces.IASTfactory;
import com.paracamplus.ilp2.interfaces.IASTprogram;
import com.paracamplus.ilp2.parser.ilpml.ILPMLParser;


public class ILPMLOptimizingParser extends ILPMLParser{

	public ILPMLOptimizingParser(IASTfactory factory) {
		super(factory);
	}
	@Override
    public IASTprogram getProgram() throws ParseException {
		try {
			IASTprogram program = super.getProgram();
			
			CopyTransform<Void> c = new CopyTransform<Void>((IASTfactory) super.factory);
			
			return c.visit(program, null);
		} catch (Exception e) {
			throw new ParseException(e);
		}
    }
}

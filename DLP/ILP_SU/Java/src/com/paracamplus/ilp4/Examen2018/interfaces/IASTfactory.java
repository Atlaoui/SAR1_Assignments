package com.paracamplus.ilp4.Examen2018.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends  com.paracamplus.ilp4.interfaces.IASTfactory{
	IASTsuperArgs newASTsuperArgs(IASTexpression args);
}

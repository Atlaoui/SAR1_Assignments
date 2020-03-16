package com.paracamplus.ilp4.Examen2019.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends  com.paracamplus.ilp4.interfaces.IASTfactory{
	IASTautoclose newAutoclose(IASTexpression expr1 , IASTexpression expr2);
}

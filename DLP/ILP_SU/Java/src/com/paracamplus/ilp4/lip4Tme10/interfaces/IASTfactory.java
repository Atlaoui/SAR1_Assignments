package com.paracamplus.ilp4.lip4Tme10.interfaces;

import com.paracamplus.ilp1.interfaces.IASTvariable;

public interface IASTfactory extends com.paracamplus.ilp4.interfaces.IASTfactory{
	IASTdefined newDefined(IASTvariable var);
	IASTexists newExists(IASTvariable var);
}

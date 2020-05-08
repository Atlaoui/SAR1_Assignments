package srcs.service.calculatrice;

import srcs.service.AppelDistant;

public class CalculatriceAppelDistant implements AppelDistant , Calculatrice {


	@Override
	public Integer add(Integer a, Integer b) {
		return a+b;
	}

	@Override
	public Integer sous(Integer a, Integer b) {
		return a-b;
	}

	@Override
	public Integer mult(Integer a, Integer b) {
		return a*b;
	}

	@Override
	public ResDiv div(Integer a, Integer b) {
		int r = a/b;
		int q = a%b;
		return new ResDiv(q,r);
	}

}

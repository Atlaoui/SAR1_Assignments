package TME4;

import TME4.Interfaces.Calculatrice;
import TME4.Interfaces.ClientProxy;

public class CalculatriceProxy extends ClientProxy implements Calculatrice{

	
	public CalculatriceProxy(String nom, int portCalculatrice) {
		super(nom,portCalculatrice);
	}



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
		return new ResDiv(a/b,a%b);
	}

}

package TME4;




import TME4.Interfaces.AppelDistant;
import TME4.Interfaces.Calculatrice;
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

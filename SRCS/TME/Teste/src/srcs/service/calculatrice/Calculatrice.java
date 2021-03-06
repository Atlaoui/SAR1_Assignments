package srcs.service.calculatrice;

import java.io.Serializable;

public interface Calculatrice  {
	
	public Integer add(Integer a,Integer b);

	public Integer sous(Integer a,Integer b);
	
	public Integer mult(Integer a,Integer b);
	
	public ResDiv div(Integer a , Integer b);
	
	class ResDiv implements Serializable{
		private static final long serialVersionUID = 1L;
		private final Integer q,r;
		
		public ResDiv(Integer q,Integer r) {
			this.q=q;
			this.r=r;
		}
		public int getQuotient() {return q;}
		public int getReste() {return r;}
	}
}

package TME1.banque.persistance.cesar;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CesarInputStream extends FilterInputStream {
	private final int decal;
	protected CesarInputStream(InputStream in , int d) {
		super(in);
		decal = d;
	}
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		int tmp = super.read();
		if(tmp==-1)
			return tmp;
		return tmp-(decal%255);
	}
	
	
	


}

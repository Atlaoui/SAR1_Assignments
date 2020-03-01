package TME1.banque.persistance.cesar;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CesarOutputStream extends FilterOutputStream{
	private final int decalage;
	public CesarOutputStream(OutputStream out,int d) {
		super(out);
		this.decalage=d;
	}

	

	@Override
	public void write(int b) throws IOException {	
		super.write(b +decalage);
	}
}

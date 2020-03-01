package TME1.banque.persistance;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends FilterOutputStream{
	private OutputStream in;
	public TeeOutputStream(OutputStream out,OutputStream in) {
		super(out);
		this.in=in;
	}
	@Override
	public void close() throws IOException {
		in.close();
		super.close();
	}
	@Override
	public void flush() throws IOException {
		in.flush();
		super.flush();
	}
	@Override
	public void write(byte[] arg0, int arg1, int arg2) throws IOException {
		in.write(arg0, arg1, arg2);
		super.write(arg0, arg1, arg2);
	}
	@Override
	public void write(byte[] b) throws IOException {
		in.write(b);
		super.write(b);
	}
	@Override
	public void write(int b) throws IOException {
		in.write(b);
		super.write(b);
	}

}

package Exam_Mars_2019.exo3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientD {
	private Socket s;
	private int pos;
	public ClientD(Socket socket , int i) {
		s=socket;
		pos=i;
	}
	
	public void onUpdate(byte[] arr) {
		try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
			oos.write(arr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPos() {
		return pos;
	}
	public boolean closed() {
		return s.isClosed();
	}
}

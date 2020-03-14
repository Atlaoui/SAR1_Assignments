package Exam_Mars_2019.exo2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//Q4)
public class ServeurT {
	private final int port;
	private ServerSocket SockServ;
	private Transformer t = new Transformer();
	public ServeurT(int port) {
		this.port = port;
	}
	public void listen() throws IOException, ClassNotFoundException {
		SockServ= new ServerSocket(port);
		Socket s = null;
		while(true) {
			s=SockServ.accept();
			try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
				int nb_object=-1;
				try {
					nb_object = ois.readInt();
				} catch (IOException e) {
					oos.writeObject(new ProtocolViolation("Pas bon"));
					oos.flush();
					continue;
				}
				Object o;
				while(nb_object>=0) {
					nb_object--;
					o=ois.readObject();
					oos.writeObject(t.transform((String)o));
				}
				oos.flush();
			}
		}
	}
}

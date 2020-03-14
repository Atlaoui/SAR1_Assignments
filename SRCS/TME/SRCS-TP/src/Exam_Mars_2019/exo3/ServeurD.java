package Exam_Mars_2019.exo3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServeurD {
	private DataBlocStore data;
	private int port;
	private ServerSocket ss;
	private List<ClientD> abon = new ArrayList<>();
	public ServeurD(int port ,int size) {
		data = new DataBlocStore(size);
		this.port=port;
	}

	public void listen() {
		try {
			ss = new ServerSocket(port);
			Socket s;
			String name;
			int i ;
			while(true) {
				s = ss.accept();
				try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
						ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
					name = ois.readUTF();
					boolean wantAbon = ois.readBoolean();
					switch (name) {
					case "readData":
						i = ois.readInt();
						oos.write(readData(i));
						if(wantAbon)
							abonner(s,i);
						oos.flush();
						break;
					case "writeData":
						i = ois.readInt();
						byte[] arr = ois.readAllBytes();
						writeData(i,arr);
						if(wantAbon)
							abonner(s,i);
						oos.flush();
						break;	
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeData(int i, byte [] arr) {
		data.write(i, arr);
		update(i,arr);
	}

	public byte[] readData(int i) {
		return data.read(i);
	}

	public void abonner(Socket s ,int i) {
		abon.add(new ClientD(s , i));
	}

	private void update(int i,byte [] b) {
		abon.removeIf(n -> n.closed());
		Iterator<ClientD> iter = abon.iterator();
		while(iter.hasNext()) {
			ClientD e = iter.next();
			if(e.getPos()==i) {
				e.onUpdate(b);
			}
		}
	}

}

package TME5;

import java.util.ArrayList;
import java.util.List;

import TME5.interfaces.Chat;
import TME5.interfaces.MessageReceiver;

public class ChatProxy implements Chat{
	private List<String> chatters;
	private final int port;
	private MessageReceiver msgRec;
	private String nom;

	public ChatProxy( String nom,int port ,MessageReceiver msg) {
		chatters = new  ArrayList<>();
		this.port=port;
		msgRec=msg;
		this.nom=nom;
	}

	@Override
	public boolean subscribe(String pseudo, String host, int port) {
		if(!chatters.contains(pseudo))
			return false;
		
		return false;
	}

	@Override
	public int send(String pseudo, String message) {
		return 0;
	}

	@Override
	public List<String> listChatter() {
		return chatters;
	}

	@Override
	public void unsubscribe(String pseudo) {
		chatters.remove(pseudo);
	}

}

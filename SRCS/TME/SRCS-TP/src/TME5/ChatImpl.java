package TME5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import TME5.grpc.ChatGrpc.ChatImplBase;
import TME5.grpc.Messages.address;
import TME5.grpc.Messages.mess;
import io.grpc.stub.StreamObserver;

public class ChatImpl extends ChatImplBase{
	
	
	 private Map< String,Address> hm =   new ConcurrentHashMap< String,Address>(); 
	
	@Override
	public void subscribe(address request, StreamObserver<BoolValue> responseObserver) {
		if(!hm.containsKey(request.getPseudo())) {
			hm.put(request.getPseudo(), new Address(request.getHost(),request.getPort()));
			responseObserver.onNext(BoolValue.of(true));
		}else {
			responseObserver.onNext(BoolValue.of(false));
		}
	}

	@Override
	public void send(mess request, StreamObserver<BoolValue> responseObserver) {
		
	}

	@Override
	public void listChatter(Empty request, StreamObserver<StringValue> responseObserver) {
		responseObserver.onNext(StringValue.(hm.keySet()));
	}

	@Override
	public void unsubscribe(StringValue request, StreamObserver<Empty> responseObserver) {
		
	}
	
	
	
	 class Address {
		private String nomServeur;
		private int port;
		Address (String nom, int port) {
			
		}
		
	}

}

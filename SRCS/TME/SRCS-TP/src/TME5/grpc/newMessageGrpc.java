package TME5.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0-SNAPSHOT)",
    comments = "Source: messages.proto")
public final class newMessageGrpc {

  private newMessageGrpc() {}

  public static final String SERVICE_NAME = "TME5.newMessage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<TME5.grpc.Messages.address,
      com.google.protobuf.BoolValue> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = TME5.grpc.Messages.address.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TME5.grpc.Messages.address,
      com.google.protobuf.BoolValue> getSubscribeMethod() {
    io.grpc.MethodDescriptor<TME5.grpc.Messages.address, com.google.protobuf.BoolValue> getSubscribeMethod;
    if ((getSubscribeMethod = newMessageGrpc.getSubscribeMethod) == null) {
      synchronized (newMessageGrpc.class) {
        if ((getSubscribeMethod = newMessageGrpc.getSubscribeMethod) == null) {
          newMessageGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<TME5.grpc.Messages.address, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TME5.grpc.Messages.address.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new newMessageMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TME5.grpc.Messages.mess,
      com.google.protobuf.BoolValue> getSendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send",
      requestType = TME5.grpc.Messages.mess.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TME5.grpc.Messages.mess,
      com.google.protobuf.BoolValue> getSendMethod() {
    io.grpc.MethodDescriptor<TME5.grpc.Messages.mess, com.google.protobuf.BoolValue> getSendMethod;
    if ((getSendMethod = newMessageGrpc.getSendMethod) == null) {
      synchronized (newMessageGrpc.class) {
        if ((getSendMethod = newMessageGrpc.getSendMethod) == null) {
          newMessageGrpc.getSendMethod = getSendMethod =
              io.grpc.MethodDescriptor.<TME5.grpc.Messages.mess, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "send"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TME5.grpc.Messages.mess.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new newMessageMethodDescriptorSupplier("send"))
              .build();
        }
      }
    }
    return getSendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.StringValue> getListChatterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listChatter",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.StringValue> getListChatterMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.StringValue> getListChatterMethod;
    if ((getListChatterMethod = newMessageGrpc.getListChatterMethod) == null) {
      synchronized (newMessageGrpc.class) {
        if ((getListChatterMethod = newMessageGrpc.getListChatterMethod) == null) {
          newMessageGrpc.getListChatterMethod = getListChatterMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listChatter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new newMessageMethodDescriptorSupplier("listChatter"))
              .build();
        }
      }
    }
    return getListChatterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Empty> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unsubscribe",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.Empty> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Empty> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = newMessageGrpc.getUnsubscribeMethod) == null) {
      synchronized (newMessageGrpc.class) {
        if ((getUnsubscribeMethod = newMessageGrpc.getUnsubscribeMethod) == null) {
          newMessageGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new newMessageMethodDescriptorSupplier("unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static newMessageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<newMessageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<newMessageStub>() {
        @java.lang.Override
        public newMessageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new newMessageStub(channel, callOptions);
        }
      };
    return newMessageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static newMessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<newMessageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<newMessageBlockingStub>() {
        @java.lang.Override
        public newMessageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new newMessageBlockingStub(channel, callOptions);
        }
      };
    return newMessageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static newMessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<newMessageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<newMessageFutureStub>() {
        @java.lang.Override
        public newMessageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new newMessageFutureStub(channel, callOptions);
        }
      };
    return newMessageFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class newMessageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *public boolean subscribe(String pseudo, String host, int port);
     * </pre>
     */
    public void subscribe(TME5.grpc.Messages.address request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     * <pre>
     *public int send(String pseudo, String message);
     * </pre>
     */
    public void send(TME5.grpc.Messages.mess request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMethod(), responseObserver);
    }

    /**
     * <pre>
     *public List&lt;String&gt; listChatter();
     * </pre>
     */
    public void listChatter(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncUnimplementedUnaryCall(getListChatterMethod(), responseObserver);
    }

    /**
     * <pre>
     *public void unsubscribe(String pseudo);
     * </pre>
     */
    public void unsubscribe(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TME5.grpc.Messages.address,
                com.google.protobuf.BoolValue>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getSendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TME5.grpc.Messages.mess,
                com.google.protobuf.BoolValue>(
                  this, METHODID_SEND)))
          .addMethod(
            getListChatterMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.google.protobuf.StringValue>(
                  this, METHODID_LIST_CHATTER)))
          .addMethod(
            getUnsubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                com.google.protobuf.Empty>(
                  this, METHODID_UNSUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class newMessageStub extends io.grpc.stub.AbstractAsyncStub<newMessageStub> {
    private newMessageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newMessageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new newMessageStub(channel, callOptions);
    }

    /**
     * <pre>
     *public boolean subscribe(String pseudo, String host, int port);
     * </pre>
     */
    public void subscribe(TME5.grpc.Messages.address request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *public int send(String pseudo, String message);
     * </pre>
     */
    public void send(TME5.grpc.Messages.mess request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *public List&lt;String&gt; listChatter();
     * </pre>
     */
    public void listChatter(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListChatterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *public void unsubscribe(String pseudo);
     * </pre>
     */
    public void unsubscribe(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class newMessageBlockingStub extends io.grpc.stub.AbstractBlockingStub<newMessageBlockingStub> {
    private newMessageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newMessageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new newMessageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *public boolean subscribe(String pseudo, String host, int port);
     * </pre>
     */
    public com.google.protobuf.BoolValue subscribe(TME5.grpc.Messages.address request) {
      return blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *public int send(String pseudo, String message);
     * </pre>
     */
    public com.google.protobuf.BoolValue send(TME5.grpc.Messages.mess request) {
      return blockingUnaryCall(
          getChannel(), getSendMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *public List&lt;String&gt; listChatter();
     * </pre>
     */
    public java.util.Iterator<com.google.protobuf.StringValue> listChatter(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getListChatterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *public void unsubscribe(String pseudo);
     * </pre>
     */
    public com.google.protobuf.Empty unsubscribe(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class newMessageFutureStub extends io.grpc.stub.AbstractFutureStub<newMessageFutureStub> {
    private newMessageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newMessageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new newMessageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *public boolean subscribe(String pseudo, String host, int port);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> subscribe(
        TME5.grpc.Messages.address request) {
      return futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *public int send(String pseudo, String message);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> send(
        TME5.grpc.Messages.mess request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *public void unsubscribe(String pseudo);
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unsubscribe(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_SEND = 1;
  private static final int METHODID_LIST_CHATTER = 2;
  private static final int METHODID_UNSUBSCRIBE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final newMessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(newMessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((TME5.grpc.Messages.address) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_SEND:
          serviceImpl.send((TME5.grpc.Messages.mess) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_LIST_CHATTER:
          serviceImpl.listChatter((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class newMessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    newMessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return TME5.grpc.Messages.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("newMessage");
    }
  }

  private static final class newMessageFileDescriptorSupplier
      extends newMessageBaseDescriptorSupplier {
    newMessageFileDescriptorSupplier() {}
  }

  private static final class newMessageMethodDescriptorSupplier
      extends newMessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    newMessageMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (newMessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new newMessageFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getSendMethod())
              .addMethod(getListChatterMethod())
              .addMethod(getUnsubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}

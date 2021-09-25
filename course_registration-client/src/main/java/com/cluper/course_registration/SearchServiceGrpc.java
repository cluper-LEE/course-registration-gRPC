package com.cluper.course_registration;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: university.proto")
public final class SearchServiceGrpc {

  private SearchServiceGrpc() {}

  public static final String SERVICE_NAME = "university.SearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.Empty,
      com.cluper.course_registration.StudentResponse> getGetAllStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllStudents",
      requestType = com.cluper.course_registration.Empty.class,
      responseType = com.cluper.course_registration.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.Empty,
      com.cluper.course_registration.StudentResponse> getGetAllStudentsMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.Empty, com.cluper.course_registration.StudentResponse> getGetAllStudentsMethod;
    if ((getGetAllStudentsMethod = SearchServiceGrpc.getGetAllStudentsMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getGetAllStudentsMethod = SearchServiceGrpc.getGetAllStudentsMethod) == null) {
          SearchServiceGrpc.getGetAllStudentsMethod = getGetAllStudentsMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.Empty, com.cluper.course_registration.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.SearchService", "GetAllStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("GetAllStudents"))
                  .build();
          }
        }
     }
     return getGetAllStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.Empty,
      com.cluper.course_registration.CourseResponse> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCourses",
      requestType = com.cluper.course_registration.Empty.class,
      responseType = com.cluper.course_registration.CourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.Empty,
      com.cluper.course_registration.CourseResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.Empty, com.cluper.course_registration.CourseResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = SearchServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getGetAllCoursesMethod = SearchServiceGrpc.getGetAllCoursesMethod) == null) {
          SearchServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.Empty, com.cluper.course_registration.CourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.SearchService", "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.CourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("GetAllCourses"))
                  .build();
          }
        }
     }
     return getGetAllCoursesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchServiceStub newStub(io.grpc.Channel channel) {
    return new SearchServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SearchServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SearchServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SearchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllStudents(com.cluper.course_registration.Empty request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllStudentsMethod(), responseObserver);
    }

    /**
     */
    public void getAllCourses(com.cluper.course_registration.Empty request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.CourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllStudentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.Empty,
                com.cluper.course_registration.StudentResponse>(
                  this, METHODID_GET_ALL_STUDENTS)))
          .addMethod(
            getGetAllCoursesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.Empty,
                com.cluper.course_registration.CourseResponse>(
                  this, METHODID_GET_ALL_COURSES)))
          .build();
    }
  }

  /**
   */
  public static final class SearchServiceStub extends io.grpc.stub.AbstractStub<SearchServiceStub> {
    private SearchServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllStudents(com.cluper.course_registration.Empty request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.StudentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourses(com.cluper.course_registration.Empty request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.CourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SearchServiceBlockingStub extends io.grpc.stub.AbstractStub<SearchServiceBlockingStub> {
    private SearchServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cluper.course_registration.StudentResponse getAllStudents(com.cluper.course_registration.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.CourseResponse getAllCourses(com.cluper.course_registration.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SearchServiceFutureStub extends io.grpc.stub.AbstractStub<SearchServiceFutureStub> {
    private SearchServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.StudentResponse> getAllStudents(
        com.cluper.course_registration.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllStudentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.CourseResponse> getAllCourses(
        com.cluper.course_registration.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_STUDENTS = 0;
  private static final int METHODID_GET_ALL_COURSES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_STUDENTS:
          serviceImpl.getAllStudents((com.cluper.course_registration.Empty) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.StudentResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((com.cluper.course_registration.Empty) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.CourseResponse>) responseObserver);
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

  private static abstract class SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cluper.course_registration.University.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchService");
    }
  }

  private static final class SearchServiceFileDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier {
    SearchServiceFileDescriptorSupplier() {}
  }

  private static final class SearchServiceMethodDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SearchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchServiceFileDescriptorSupplier())
              .addMethod(getGetAllStudentsMethod())
              .addMethod(getGetAllCoursesMethod())
              .build();
        }
      }
    }
    return result;
  }
}

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
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "university.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllStudentsRequest,
      com.cluper.course_registration.GetAllStudentsResponse> getGetAllStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllStudents",
      requestType = com.cluper.course_registration.GetAllStudentsRequest.class,
      responseType = com.cluper.course_registration.GetAllStudentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllStudentsRequest,
      com.cluper.course_registration.GetAllStudentsResponse> getGetAllStudentsMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllStudentsRequest, com.cluper.course_registration.GetAllStudentsResponse> getGetAllStudentsMethod;
    if ((getGetAllStudentsMethod = ReservationServiceGrpc.getGetAllStudentsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetAllStudentsMethod = ReservationServiceGrpc.getGetAllStudentsMethod) == null) {
          ReservationServiceGrpc.getGetAllStudentsMethod = getGetAllStudentsMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.GetAllStudentsRequest, com.cluper.course_registration.GetAllStudentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "GetAllStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetAllStudentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetAllStudentsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetAllStudents"))
                  .build();
          }
        }
     }
     return getGetAllStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.AddStudentRequest,
      com.cluper.course_registration.AddStudentResponse> getAddStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddStudent",
      requestType = com.cluper.course_registration.AddStudentRequest.class,
      responseType = com.cluper.course_registration.AddStudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.AddStudentRequest,
      com.cluper.course_registration.AddStudentResponse> getAddStudentMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.AddStudentRequest, com.cluper.course_registration.AddStudentResponse> getAddStudentMethod;
    if ((getAddStudentMethod = ReservationServiceGrpc.getAddStudentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getAddStudentMethod = ReservationServiceGrpc.getAddStudentMethod) == null) {
          ReservationServiceGrpc.getAddStudentMethod = getAddStudentMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.AddStudentRequest, com.cluper.course_registration.AddStudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "AddStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.AddStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.AddStudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("AddStudent"))
                  .build();
          }
        }
     }
     return getAddStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteStudentRequest,
      com.cluper.course_registration.DeleteStudentResponse> getDeleteStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStudent",
      requestType = com.cluper.course_registration.DeleteStudentRequest.class,
      responseType = com.cluper.course_registration.DeleteStudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteStudentRequest,
      com.cluper.course_registration.DeleteStudentResponse> getDeleteStudentMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteStudentRequest, com.cluper.course_registration.DeleteStudentResponse> getDeleteStudentMethod;
    if ((getDeleteStudentMethod = ReservationServiceGrpc.getDeleteStudentMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteStudentMethod = ReservationServiceGrpc.getDeleteStudentMethod) == null) {
          ReservationServiceGrpc.getDeleteStudentMethod = getDeleteStudentMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.DeleteStudentRequest, com.cluper.course_registration.DeleteStudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "DeleteStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.DeleteStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.DeleteStudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteStudent"))
                  .build();
          }
        }
     }
     return getDeleteStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllCoursesRequest,
      com.cluper.course_registration.GetAllCoursesResponse> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllCourses",
      requestType = com.cluper.course_registration.GetAllCoursesRequest.class,
      responseType = com.cluper.course_registration.GetAllCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllCoursesRequest,
      com.cluper.course_registration.GetAllCoursesResponse> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.GetAllCoursesRequest, com.cluper.course_registration.GetAllCoursesResponse> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = ReservationServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetAllCoursesMethod = ReservationServiceGrpc.getGetAllCoursesMethod) == null) {
          ReservationServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.GetAllCoursesRequest, com.cluper.course_registration.GetAllCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "GetAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetAllCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetAllCoursesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetAllCourses"))
                  .build();
          }
        }
     }
     return getGetAllCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.GetReservedCoursesRequest,
      com.cluper.course_registration.GetReservedCoursesResponse> getGetReservedCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservedCourses",
      requestType = com.cluper.course_registration.GetReservedCoursesRequest.class,
      responseType = com.cluper.course_registration.GetReservedCoursesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.GetReservedCoursesRequest,
      com.cluper.course_registration.GetReservedCoursesResponse> getGetReservedCoursesMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.GetReservedCoursesRequest, com.cluper.course_registration.GetReservedCoursesResponse> getGetReservedCoursesMethod;
    if ((getGetReservedCoursesMethod = ReservationServiceGrpc.getGetReservedCoursesMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservedCoursesMethod = ReservationServiceGrpc.getGetReservedCoursesMethod) == null) {
          ReservationServiceGrpc.getGetReservedCoursesMethod = getGetReservedCoursesMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.GetReservedCoursesRequest, com.cluper.course_registration.GetReservedCoursesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "GetReservedCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetReservedCoursesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.GetReservedCoursesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservedCourses"))
                  .build();
          }
        }
     }
     return getGetReservedCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.AddCourseRequest,
      com.cluper.course_registration.AddCourseResponse> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCourse",
      requestType = com.cluper.course_registration.AddCourseRequest.class,
      responseType = com.cluper.course_registration.AddCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.AddCourseRequest,
      com.cluper.course_registration.AddCourseResponse> getAddCourseMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.AddCourseRequest, com.cluper.course_registration.AddCourseResponse> getAddCourseMethod;
    if ((getAddCourseMethod = ReservationServiceGrpc.getAddCourseMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getAddCourseMethod = ReservationServiceGrpc.getAddCourseMethod) == null) {
          ReservationServiceGrpc.getAddCourseMethod = getAddCourseMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.AddCourseRequest, com.cluper.course_registration.AddCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "AddCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.AddCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.AddCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("AddCourse"))
                  .build();
          }
        }
     }
     return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteCourseRequest,
      com.cluper.course_registration.DeleteCourseResponse> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCourse",
      requestType = com.cluper.course_registration.DeleteCourseRequest.class,
      responseType = com.cluper.course_registration.DeleteCourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteCourseRequest,
      com.cluper.course_registration.DeleteCourseResponse> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.DeleteCourseRequest, com.cluper.course_registration.DeleteCourseResponse> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = ReservationServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteCourseMethod = ReservationServiceGrpc.getDeleteCourseMethod) == null) {
          ReservationServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.DeleteCourseRequest, com.cluper.course_registration.DeleteCourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "DeleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.DeleteCourseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteCourse"))
                  .build();
          }
        }
     }
     return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.MakeReservationRequest,
      com.cluper.course_registration.MakeReservationResponse> getMakeReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeReservation",
      requestType = com.cluper.course_registration.MakeReservationRequest.class,
      responseType = com.cluper.course_registration.MakeReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.MakeReservationRequest,
      com.cluper.course_registration.MakeReservationResponse> getMakeReservationMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.MakeReservationRequest, com.cluper.course_registration.MakeReservationResponse> getMakeReservationMethod;
    if ((getMakeReservationMethod = ReservationServiceGrpc.getMakeReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getMakeReservationMethod = ReservationServiceGrpc.getMakeReservationMethod) == null) {
          ReservationServiceGrpc.getMakeReservationMethod = getMakeReservationMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.MakeReservationRequest, com.cluper.course_registration.MakeReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "MakeReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.MakeReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.MakeReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("MakeReservation"))
                  .build();
          }
        }
     }
     return getMakeReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cluper.course_registration.CancelReservationRequest,
      com.cluper.course_registration.CancelReservationResponse> getCancelReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelReservation",
      requestType = com.cluper.course_registration.CancelReservationRequest.class,
      responseType = com.cluper.course_registration.CancelReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cluper.course_registration.CancelReservationRequest,
      com.cluper.course_registration.CancelReservationResponse> getCancelReservationMethod() {
    io.grpc.MethodDescriptor<com.cluper.course_registration.CancelReservationRequest, com.cluper.course_registration.CancelReservationResponse> getCancelReservationMethod;
    if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
          ReservationServiceGrpc.getCancelReservationMethod = getCancelReservationMethod = 
              io.grpc.MethodDescriptor.<com.cluper.course_registration.CancelReservationRequest, com.cluper.course_registration.CancelReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "university.ReservationService", "CancelReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.CancelReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cluper.course_registration.CancelReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CancelReservation"))
                  .build();
          }
        }
     }
     return getCancelReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllStudents(com.cluper.course_registration.GetAllStudentsRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllStudentsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllStudentsMethod(), responseObserver);
    }

    /**
     */
    public void addStudent(com.cluper.course_registration.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.AddStudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddStudentMethod(), responseObserver);
    }

    /**
     */
    public void deleteStudent(com.cluper.course_registration.DeleteStudentRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteStudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteStudentMethod(), responseObserver);
    }

    /**
     */
    public void getAllCourses(com.cluper.course_registration.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllCoursesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    /**
     */
    public void getReservedCourses(com.cluper.course_registration.GetReservedCoursesRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetReservedCoursesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservedCoursesMethod(), responseObserver);
    }

    /**
     */
    public void addCourse(com.cluper.course_registration.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.AddCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourse(com.cluper.course_registration.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteCourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    public void makeReservation(com.cluper.course_registration.MakeReservationRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.MakeReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeReservationMethod(), responseObserver);
    }

    /**
     */
    public void cancelReservation(com.cluper.course_registration.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.CancelReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllStudentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.GetAllStudentsRequest,
                com.cluper.course_registration.GetAllStudentsResponse>(
                  this, METHODID_GET_ALL_STUDENTS)))
          .addMethod(
            getAddStudentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.AddStudentRequest,
                com.cluper.course_registration.AddStudentResponse>(
                  this, METHODID_ADD_STUDENT)))
          .addMethod(
            getDeleteStudentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.DeleteStudentRequest,
                com.cluper.course_registration.DeleteStudentResponse>(
                  this, METHODID_DELETE_STUDENT)))
          .addMethod(
            getGetAllCoursesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.GetAllCoursesRequest,
                com.cluper.course_registration.GetAllCoursesResponse>(
                  this, METHODID_GET_ALL_COURSES)))
          .addMethod(
            getGetReservedCoursesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.GetReservedCoursesRequest,
                com.cluper.course_registration.GetReservedCoursesResponse>(
                  this, METHODID_GET_RESERVED_COURSES)))
          .addMethod(
            getAddCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.AddCourseRequest,
                com.cluper.course_registration.AddCourseResponse>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getDeleteCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.DeleteCourseRequest,
                com.cluper.course_registration.DeleteCourseResponse>(
                  this, METHODID_DELETE_COURSE)))
          .addMethod(
            getMakeReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.MakeReservationRequest,
                com.cluper.course_registration.MakeReservationResponse>(
                  this, METHODID_MAKE_RESERVATION)))
          .addMethod(
            getCancelReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.cluper.course_registration.CancelReservationRequest,
                com.cluper.course_registration.CancelReservationResponse>(
                  this, METHODID_CANCEL_RESERVATION)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllStudents(com.cluper.course_registration.GetAllStudentsRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllStudentsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addStudent(com.cluper.course_registration.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.AddStudentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteStudent(com.cluper.course_registration.DeleteStudentRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteStudentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourses(com.cluper.course_registration.GetAllCoursesRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllCoursesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservedCourses(com.cluper.course_registration.GetReservedCoursesRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.GetReservedCoursesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservedCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCourse(com.cluper.course_registration.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.AddCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(com.cluper.course_registration.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteCourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeReservation(com.cluper.course_registration.MakeReservationRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.MakeReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelReservation(com.cluper.course_registration.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.cluper.course_registration.CancelReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cluper.course_registration.GetAllStudentsResponse getAllStudents(com.cluper.course_registration.GetAllStudentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.AddStudentResponse addStudent(com.cluper.course_registration.AddStudentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.DeleteStudentResponse deleteStudent(com.cluper.course_registration.DeleteStudentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.GetAllCoursesResponse getAllCourses(com.cluper.course_registration.GetAllCoursesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.GetReservedCoursesResponse getReservedCourses(com.cluper.course_registration.GetReservedCoursesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservedCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.AddCourseResponse addCourse(com.cluper.course_registration.AddCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.DeleteCourseResponse deleteCourse(com.cluper.course_registration.DeleteCourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.MakeReservationResponse makeReservation(com.cluper.course_registration.MakeReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.cluper.course_registration.CancelReservationResponse cancelReservation(com.cluper.course_registration.CancelReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.GetAllStudentsResponse> getAllStudents(
        com.cluper.course_registration.GetAllStudentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllStudentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.AddStudentResponse> addStudent(
        com.cluper.course_registration.AddStudentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.DeleteStudentResponse> deleteStudent(
        com.cluper.course_registration.DeleteStudentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.GetAllCoursesResponse> getAllCourses(
        com.cluper.course_registration.GetAllCoursesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.GetReservedCoursesResponse> getReservedCourses(
        com.cluper.course_registration.GetReservedCoursesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservedCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.AddCourseResponse> addCourse(
        com.cluper.course_registration.AddCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.DeleteCourseResponse> deleteCourse(
        com.cluper.course_registration.DeleteCourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.MakeReservationResponse> makeReservation(
        com.cluper.course_registration.MakeReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cluper.course_registration.CancelReservationResponse> cancelReservation(
        com.cluper.course_registration.CancelReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_STUDENTS = 0;
  private static final int METHODID_ADD_STUDENT = 1;
  private static final int METHODID_DELETE_STUDENT = 2;
  private static final int METHODID_GET_ALL_COURSES = 3;
  private static final int METHODID_GET_RESERVED_COURSES = 4;
  private static final int METHODID_ADD_COURSE = 5;
  private static final int METHODID_DELETE_COURSE = 6;
  private static final int METHODID_MAKE_RESERVATION = 7;
  private static final int METHODID_CANCEL_RESERVATION = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_STUDENTS:
          serviceImpl.getAllStudents((com.cluper.course_registration.GetAllStudentsRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllStudentsResponse>) responseObserver);
          break;
        case METHODID_ADD_STUDENT:
          serviceImpl.addStudent((com.cluper.course_registration.AddStudentRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.AddStudentResponse>) responseObserver);
          break;
        case METHODID_DELETE_STUDENT:
          serviceImpl.deleteStudent((com.cluper.course_registration.DeleteStudentRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteStudentResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((com.cluper.course_registration.GetAllCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.GetAllCoursesResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVED_COURSES:
          serviceImpl.getReservedCourses((com.cluper.course_registration.GetReservedCoursesRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.GetReservedCoursesResponse>) responseObserver);
          break;
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((com.cluper.course_registration.AddCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.AddCourseResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((com.cluper.course_registration.DeleteCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.DeleteCourseResponse>) responseObserver);
          break;
        case METHODID_MAKE_RESERVATION:
          serviceImpl.makeReservation((com.cluper.course_registration.MakeReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.MakeReservationResponse>) responseObserver);
          break;
        case METHODID_CANCEL_RESERVATION:
          serviceImpl.cancelReservation((com.cluper.course_registration.CancelReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.cluper.course_registration.CancelReservationResponse>) responseObserver);
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cluper.course_registration.University.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getGetAllStudentsMethod())
              .addMethod(getAddStudentMethod())
              .addMethod(getDeleteStudentMethod())
              .addMethod(getGetAllCoursesMethod())
              .addMethod(getGetReservedCoursesMethod())
              .addMethod(getAddCourseMethod())
              .addMethod(getDeleteCourseMethod())
              .addMethod(getMakeReservationMethod())
              .addMethod(getCancelReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}

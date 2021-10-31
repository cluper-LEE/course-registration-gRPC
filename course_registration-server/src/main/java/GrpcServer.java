import java.io.IOException;

import com.cluper.course_registration.ReservationServiceGrpc;
import com.cluper.course_registration.ReservationServiceGrpc.ReservationServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.ReservationService;

public class GrpcServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting course-registration-server...");

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();	
		ReservationServiceBlockingStub stub = ReservationServiceGrpc.newBlockingStub(channel);
		System.out.println("Stub created");
		
		Server server = ServerBuilder.forPort(8000).addService(new ReservationService(stub)).build();
		server.start();
		System.out.println("Server started at " + server.getPort());
		server.awaitTermination();
	}
}


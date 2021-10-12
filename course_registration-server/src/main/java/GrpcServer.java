import java.io.IOException;

import com.cluper.course_registration.SearchServiceGrpc;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.SearchService;

public class GrpcServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting course-registration-server...");

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();	
		// ���� stub ����. �񵿱� stub�� newStub()���� ����.
		SearchServiceBlockingStub stub = SearchServiceGrpc.newBlockingStub(channel);
		System.out.println("Stub created");
		
		Server server = ServerBuilder.forPort(8000).addService(new SearchService(stub)).build();
		server.start();
		System.out.println("Server started at " + server.getPort());
		server.awaitTermination();
	}
}

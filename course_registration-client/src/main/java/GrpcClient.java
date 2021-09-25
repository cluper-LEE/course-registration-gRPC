import java.util.Scanner;

import com.cluper.course_registration.SearchServiceGrpc;
import com.cluper.course_registration.SearchServiceGrpc.SearchServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import views.VMain;

public class GrpcClient {

	public static void main(String[] args) {
		System.out.println("Starting course_registration_client...");
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();
		SearchServiceBlockingStub stub = SearchServiceGrpc.newBlockingStub(channel);
		System.out.println("Stub created");
		
		Scanner scanner = new Scanner(System.in);
		
		VMain main = new VMain(stub, scanner);
		int returnCode = 1;
		while(returnCode == 1) {
			returnCode = main.show();			
		}
		
		scanner.close();
	}
	
	public static String printSelection(String message, String... options) {
		
		return null;
	}

}

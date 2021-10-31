import java.util.Scanner;

import com.cluper.course_registration.ReservationServiceGrpc;
import com.cluper.course_registration.ReservationServiceGrpc.ReservationServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import views.VMain;

public class GrpcClient {

	public static void main(String[] args) {
		System.out.println("Starting course_registration_client...!");
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();
		ReservationServiceBlockingStub stub = ReservationServiceGrpc.newBlockingStub(channel);
		System.out.println("Stub created");
		Scanner scanner = new Scanner(System.in);
		VMain main = new VMain(stub, scanner);
		
		int returnCode = 1;
		while(returnCode == 1) {
			returnCode = main.show();			
		}
		scanner.close();
	}
}

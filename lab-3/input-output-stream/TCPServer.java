import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(5001);
    System.out.println("Listening for clients...");
    Socket clientSocket = serverSocket.accept();
    String clientSocketIP = clientSocket.getInetAddress().toString();
    int clientSocketPort = clientSocket.getPort();
    System.out.println("[IP: " + clientSocketIP + " ,Port: " + clientSocketPort +"]  " + "Client	 Connection Successful!");

    DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
    DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

    // Read two integers from the client
    int num1 = dataIn.readInt();
    int num2 = dataIn.readInt();

    // Calculations
    int addition = num1 + num2;
    int subtraction = num1 - num2;
    int multiplication = num1 * num2;
    int division = num1 / num2;

    // Send the results back to the client
    dataOut.writeInt(addition);
    dataOut.writeInt(subtraction);
    dataOut.writeInt(multiplication);
    dataOut.writeInt(division);
  }
}

package NetworksP2;
//Hannah Ewing
import java.io.*;
import java.net.*;

public class Server 
{
	public static void main(String argv[]) throws Exception
	{
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket(8082);
		//Socket clientSocket = new Socket("cisone.sbuniv.edu", 8082);
		
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = welcomeSocket.accept();
		
		BufferedReader inFromClient = 
				new BufferedReader(new
						InputStreamReader(clientSocket.getInputStream())); //was connectionSocket
		
		DataOutputStream outToClient =
				new DataOutputStream(clientSocket.getOutputStream()); //was connectionSocket
		do {
		clientSentence = inFromClient.readLine();
		//print clientsentence
		System.out.println(clientSentence);
				
		//capitalizedSentence = clientSentence.toUpperCase() + '\n';
		
		//read from keyboard into capitalizedsentence
		
		capitalizedSentence = inFromUser.readLine();
		
		outToClient.writeBytes(capitalizedSentence + '\n');
		} while (!capitalizedSentence.equals("EXITEXIT")&&!clientSentence.equals("EXITEXIT"));
		welcomeSocket.close(); //was welcomeSocket
	}
}

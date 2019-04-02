import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer(){
        ServerSocket echoServer = null;
        String line;
        BufferedReader in;
        PrintStream out;
        Socket clientSocket = null;

        try {
            echoServer = new ServerSocket(10000);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        try {
            System.out.println("echoServer started...");
            clientSocket = echoServer.accept();
            System.out.println("echoServer: connection accpeted from "+clientSocket.getInetAddress().getHostName());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintStream(clientSocket.getOutputStream());
            boolean loop = true;

            while (loop) {
                line = in.readLine();
                System.out.println(line);
                out.println(line);
                if (line.equalsIgnoreCase("quit")){
                    loop = false;
                    System.out.println("TESTE");
                    in.close();
                    out.close();
                    clientSocket.close();
                    echoServer.close();
                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("echoServer closed...");
    }
}

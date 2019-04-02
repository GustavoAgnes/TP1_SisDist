import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        Scanner k = new Scanner(System.in);
        System.out.println("Modo de operação: \n1- Servidor\n2-Cliente P2P");
        int o = k.nextInt();
        if(o == 1)
        {
            Server s = new Server();
        }
        else if(o == 2){
            Client c = new Client();
        }
        }

    }


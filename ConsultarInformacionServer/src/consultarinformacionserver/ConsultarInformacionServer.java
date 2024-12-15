package consultarinformacionserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ConsultarInformacionServer {

    public static void main(String[] args) {
        Random rand = new Random();
        int port = 1234;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port + ".");

            
            // Aceptar una conexion
            Socket client = server.accept();
            System.out.println("Cliente conectado: " + client.getInetAddress());

            // Leer y responder al cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
           
            String ip = InetAddress.getLocalHost().getHostAddress();
            //System.out.println(ip);
            
            String host = InetAddress.getLocalHost().getHostName();
            //System.out.println(host);
            
            String sistemaOperativo = System.getProperty("os.name");
            //System.out.println(sistemaOperativo);
            
            String answer = "Host: " + host + ", IP: " + ip + ", OS: " + sistemaOperativo;
            output.println(answer); 
            System.out.println(answer);

        } catch (IOException ex) {
        ex.printStackTrace();
        } 
    }
    
}

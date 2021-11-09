package SpaceCowboy.SotonUni.Challenge4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


//Hosts server
public class Server {

    public static void main(String args[]){
        try{
            //Creates server
            ServerSocket ss = new ServerSocket(6569);

            //Connects client to server
            Socket s = ss.accept();
            System.out.println("Client connected");


            //Creates variables for input
            BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //Gets input from clients
            while(true){
                String str = bf.readLine();
                System.out.println(str);
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
}

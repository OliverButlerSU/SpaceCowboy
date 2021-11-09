package SpaceCowboy.SotonUni.Challenge4;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


//Hosts client
public class Client {

    public static void main(String args[]){
        try{
            //Connect to server
            Socket s = new Socket("localhost", 6569);
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            Scanner in = new Scanner(System.in);

            //Get username of user
            System.out.print("What is your name: ");
            String name = in.nextLine();


            //Get input and send to server
            while(true){
                System.out.print(name+": ");
                String input = in.nextLine();
                pr.println(name+": " +input);
                pr.flush();
            }

        //For any error messages with regards to connecting
        } catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
}

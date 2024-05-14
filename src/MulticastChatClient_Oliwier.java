import java.net.*;
import java.io.*;

public class MulticastChatClient_Oliwier {
    public static void main(String[] args)
            throws Exception {
                int portnumber = 4444;
                if (args.length >= 1){
                    portnumber = Integer.parseInt(args[0]);
                }
                    MulticastSocket chatMulticastSocket = new MulticastSocket(4444);

                    InetAddress group = InetAddress.getByName("225.4.5.6");

                    chatMulticastSocket.joinGroup(group);

                    String msg = "";
                    System.out.println("Type a message for the server:");
                    BufferedReader br=
                            new BufferedReader(new InputStreamReader(System.in));
                    msg = br.readLine();

                    DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
                    chatMulticastSocket.send(data);

                    chatMulticastSocket.close();

        }


    }
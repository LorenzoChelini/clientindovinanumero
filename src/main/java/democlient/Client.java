package democlient;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in)) ) {

            System.out.println("Connessione effettuata");
            String response;

            while (true) {
                response = in.readLine();
                if (response.equals("4")) {
                    System.out.println("Connessione chiusa.");
                    break;
                }

                System.out.println("Inserisci il numero:");
                int tentativo = Integer.parseInt(userInput.readLine());
                out.println(tentativo);

                if (response.equals("1")) {
                    System.out.println("Numero troppo piccolo");
                } else if (response.equals("2")) {
                    System.out.println("Numero troppo grande");
                } else if (response.equals("3")) {
                    System.out.println("HAI INDOVINATO!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientStr{

    String nomeServer = "localhost"; // indirizzo server locale
    int portaServer = 12121; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtente; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input

        
    public void compra() throws IOException {
        Compra c = new Compra();
        ThreadInput tin = new ThreadInput(c);
        ThreadOutput to = new ThreadOutput(c);
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        miosocket = new Socket(nomeServer, portaServer);
        outVersoServer = new DataOutputStream(miosocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));

        Messaggio messaggio = new Messaggio();

        //invio l'array vuoto
        //serializzazione
        ObjectMapper objectMapper = new ObjectMapper();
        String vlrToServer = objectMapper.writeValueAsString(messaggio);
        System.out.println("Primo messaggio inviato");
        outVersoServer.writeBytes(vlrToServer + '\n');

        //partono i thread
        to.start();
        tin.start();
    }
 }
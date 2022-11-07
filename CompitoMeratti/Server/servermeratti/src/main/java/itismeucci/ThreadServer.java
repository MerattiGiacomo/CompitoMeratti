package itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ThreadServer extends Thread{
    private Socket client;
    private ServerSocket server;

    Biglietti b1 = new Biglietti(1, "tribuna 1");
    Biglietti b2 = new Biglietti(2, "tribuna 2");
    Biglietti b3 = new Biglietti(3, "spalti 1");

    //aggiunge la lista
    /*
    arrayList<Biglietti> arBiglietti = new ArrayList();
    arBiglietti.add(b1);
    arBiglietti.add(b2);
    arBiglietti.add(b3);
    Messaggio listaBiglietti = new Messaggio(arBiglietti);
     */

    public ThreadServer(Socket client, ServerSocket server){
        this.client = client;
        this.server = server;
    }

    public void run(){
        try{
            compra(client,server);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    void compra(Socket client, ServerSocket server) throws IOException{
        
        while(true){
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String stringaRicevuta = in.readLine();
            //deserializzazione
            ObjectMapper objectMapper = new ObjectMapper();
            Messaggio bigliettiScelti = objectMapper.readValue(stringaRicevuta, Messaggio.class);
            System.out.println(stringaRicevuta);
            //controllo se è il pirmo invio del client
            if(bigliettiScelti.getMessaggio() == null || bigliettiScelti.getMessaggio().size() == 0){
                //serializzo la lista di messaggi
                String listaToClient = objectMapper.writeValueAsString();
                out.writeBytes(listaToClient + '\n');
            }
            //il client ha inviato i biglietti che vuole comprare
            else{

            }
            out.writeBytes(stringaRicevuta + '\n');
        }
    }
}

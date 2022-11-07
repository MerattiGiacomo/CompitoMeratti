package itismeucci;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ServerStr servente = new ServerStr();
        System.out.println("Server avviato");
        servente.avvia();
        
    }
}

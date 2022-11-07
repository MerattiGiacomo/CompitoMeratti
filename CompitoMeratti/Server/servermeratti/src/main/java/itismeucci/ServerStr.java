package itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStr {

    public void avvia() throws IOException {
        ServerSocket server = new ServerSocket(12121);
        for (;;) {
            Socket client;
            try {
                client = server.accept();
                ThreadServer s = new ThreadServer(client, server);
                s.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}

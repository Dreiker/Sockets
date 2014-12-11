package shockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    
    private static final String DIRECCION_SERVIDOR = "localhost";
    private static final int PUERTO = 1600;
    
    public static void main(String[] args) {
        try {
            //Creamos el socket correspondiente del cliente.
            Socket socket = new Socket(DIRECCION_SERVIDOR, PUERTO);
            
            //Escribimos en la salida el mensaje que será recibido por el servidor.
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Mensaje enviado desde el cliente.");
            
            //Miramos lo que hay escrito en la entrada que ha sido recibido desde el servidor.
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            System.out.println(entrada.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

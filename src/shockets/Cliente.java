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
            Socket socketConectado = new Socket(DIRECCION_SERVIDOR, PUERTO);

            DataOutputStream salida = new DataOutputStream(socketConectado.getOutputStream());
            salida.writeUTF("Mensaje enviado desde el cliente.");

            DataInputStream entrada = new DataInputStream(socketConectado.getInputStream());
            System.out.println(entrada.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package shockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {
    
    private static final int PUERTO = 1600;
    
    public static void main(String[] args) {
        try {
            //Creamos una nueva instancia de la clase socket con el puerto en el que deseamos trabajar.
            ServerSocket socket = new ServerSocket(PUERTO);
            
            //A partir de ahora se esperará a que el programa cliente establezca la conexión. Hasta que no se
            //establezca una conexión el programa no avanzará.
            Socket socketConectado = socket.accept();
            
            //Ya tenemos la conexión establecida entre ambos sockets, así que podemos enviar y recibir información
            //En este caso tan solo enviaremos un mensaje.
            DataOutputStream salida = new DataOutputStream(socketConectado.getOutputStream());
            salida.writeUTF("Mensaje enviado desde el servidor.");
            
            //Ahora con la salida. Leeremos lo que haya enviado el otro socket.
            DataInputStream entrada = new DataInputStream(socketConectado.getInputStream());
            System.out.println(entrada.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

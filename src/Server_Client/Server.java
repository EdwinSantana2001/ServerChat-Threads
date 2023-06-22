package Server_Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *The Observable and Observer objects play an important role in implementing Model-View-Controller architecture in Java.
 * They are typically used in a system where one object needs to notify another about the occurrences of some important changes.
 * Observable is a class and Observer is an interface.
 */
public  class Server extends Observable implements Runnable{

    private final int puerto;

    public Server(int puerto){
        this.puerto = puerto;

    }


    @Override
    public void run() {
        ServerSocket servidor = null;//Socket del Servidor
        Socket sc = null;//Socket del Cliente
        DataInputStream in;//Comunicación
        DataOutputStream out;//Comunicación

        try {
            //Creo el Socket del servidor Con el puerto el constructor
            servidor = new ServerSocket(puerto);
            System.out.println("¡¡Servidor Iniciado!!");
            while (true){
                sc = servidor.accept();//Lo que hace es que se queda a la espera de peticiones
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());//Cliente ->Servidor //Comunicación a partir del socked

                String ms= in.readUTF();//Queda a la espera de que el cliente mande "algo" peticion?
                System.out.println(ms);//leo el mensaje mediante consola

                this.setChanged();
                this.notifyObservers(ms);
                this.clearChanged();

                sc.close();
                System.out.println("Cliente desconectado");
            }

        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}

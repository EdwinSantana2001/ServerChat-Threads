package Server_Client;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{

    private int puerto;
    private String ms;

    public Cliente(int puerto, String ms){
        this.puerto = puerto;
        this.ms = ms;
    }


    @Override
    public void run() {
        //Se le asigna un HOST
        final String HOST="127.0.0.1";

        DataOutputStream out;//Comunicación

        try {
            Socket sc = new Socket(HOST,puerto);

            out = new DataOutputStream(sc.getOutputStream());//Servidor ->Cliente

            //Envio mensaje
            out.writeUTF(ms);

            //Cierra Socket
            sc.close();

        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}

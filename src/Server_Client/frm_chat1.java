package Server_Client;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *El Observable es el que va a notificar y el Observer es a quien se le va a notificar
 * @author edwsa
 */
public class frm_chat1 extends javax.swing.JFrame implements Observer{

    /**
         * Java:Treads
         * La clase Tread(hilo, tarea ):es una clase de java para definir 
         * hilos de ejecucion concurrentes dentro de un mismo programa. 
         * En java, como lenguaje O.O, el concepto de concurrencia está 
         * asociado a los objetos: 
         * +Son objetos que actuan concurrentemente con otros.
         * Las clases de objetos(hilos) que puedan actuar concurrentemente 
         * deben extender de la clase Tread.ejemplo
         * ->Class miClaseConcurrente extends Tread {}
         * *Como consejo Obvio: las clases derivadas de Tread deben incluir un metodo: 
         * public void run(){}
         * Este metodo especifica realmente la tarea a realizar.
         * INICIAR UNA TAREA start()
         * El inicio de una ejecucion de una tarea se realiza mediante el 
         * metodo start() heredado de Thread (español =  hilos )
         * Con esto tenemos iniciado el servidor 
         * Add the observer to the server that is observable ya que está pantalla 
         * va ser la notificada
         **/
    /**
     *Diferencias entre JAVA:Threads y Sockets:
     * Socket:El servidor estará a la espera de una conexión, en cuanto 
     * el cliente inicie enviará un mensaje de petición al servidor, 
     * éste le responderá afirmativamente y una vez recibida la 
     * confirmación, el cliente enviará un par de mensajes y 
     * la conexión finalizará.
     * 
     * Breve explicacion del funcionamiento de un precesador:
     * Como sabemo el procesador solo puede realizar una tarea a la vez, 
     * por o que no se puede tener un paralelismo entre los procesos 
     * ejecutandose, a menos que se tengan varios procesadores como tareas se requiera.
     * Por eso se crearon los Threads, haciendo posible la multitarea nos 
     * permite ejecutar varios procesos a la vez; es decir, de forma 
     * concurrente y por tanto eso nos permite hacer programas que se 
     * ejecuten en menor tiempo y sean más eficientes.
     * 
     * Threads:Con los hilos o threads, podemos obtener una ejecución 
     * lo más cercana posible al modelo de los 3 hilos que presenté 
     * arriba. Los threads son estructuras secuenciales que combinan 
     * las líneas de 2 o más procesos en un solo proceso.
     */
    public frm_chat1() {
        initComponents();
        this.getRootPane().setDefaultButton(btn_send);
        frm_chat2 frm = new frm_chat2();
        frm.setVisible(true);
        
        Server s = new  Server(5000);
        s.addObserver(this);// en esta linea le estoy diciendo que los cambios se le notifican a este frm_chat
        Thread t = new Thread(s); //diff de thread y socket
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_outPut = new javax.swing.JTextArea();
        txt_inputs = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat1");

        txtArea_outPut.setEditable(false);
        txtArea_outPut.setColumns(20);
        txtArea_outPut.setRows(5);
        jScrollPane1.setViewportView(txtArea_outPut);

        btn_send.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_send.setText("send ");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        //receive the message  
        if(txt_inputs.getText().toString().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe llenar el texto antes de enviar un mensaje","Acción invalida", JOptionPane.WARNING_MESSAGE);
            
        }else{String message = "1: "+this.txt_inputs.getText()+"\n";
        //notify the change made in the server-chat(Append = Anexar)
        this.txtArea_outPut.append(message);    
        //Conectar con el Cliente(El mensaje viaja al servidor y del servidor a el cliente)
        Cliente c = new Cliente(6000,message);
        Thread t = new Thread(c);
        t.start();
        txt_inputs.setText("");
                     }
    }//GEN-LAST:event_btn_sendActionPerformed
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_chat1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_chat1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_chat1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_chat1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_chat1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_send;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea_outPut;
    private javax.swing.JTextField txt_inputs;
    // End of variables declaration//GEN-END:variables

    /**
    * El parametro arg es un arreglo que recibe datos directos del Commands line 
    *es decir, en el momento en que ejecutamos 
    * nuestra aplicación es posible enviar una información por medio 
    * de él.
    */
    @Override
    public void update(Observable o, Object arg) {
        this.txtArea_outPut.append((String) arg);
    }
}

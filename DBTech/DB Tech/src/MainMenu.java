import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MainMenu extends javax.swing.JFrame {

    
    public MainMenu() {
        initComponents();
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
        refreshLogsButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ApothemataButton = new javax.swing.JButton();
        KratiseisButton = new javax.swing.JButton();
        ListaPelatonButton = new javax.swing.JButton();
        ListaIpallilonButton = new javax.swing.JButton();
        SubTypeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));

        refreshLogsButton.setText("Ανανέωση του log file");
        refreshLogsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshLogsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshLogsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshLogsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ΒΑΣΗ ΔΕΔΟΜΕΝΩΝ ΒΙΒΛΙΟΘΗΚΗΣ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        ApothemataButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ApothemataButton.setText("Αποθέματα");
        ApothemataButton.setToolTipText("Αποθέματα");
        ApothemataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApothemataButtonActionPerformed(evt);
            }
        });

        KratiseisButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        KratiseisButton.setText("Κρατήσεις");
        KratiseisButton.setToolTipText("Κρατήσεις");
        KratiseisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KratiseisButtonActionPerformed(evt);
            }
        });

        ListaPelatonButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ListaPelatonButton.setText("Λίστα Πελατών");
        ListaPelatonButton.setToolTipText("Λίστα Πελατών");
        ListaPelatonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPelatonButtonActionPerformed(evt);
            }
        });

        ListaIpallilonButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ListaIpallilonButton.setText("Λίστα Υπαλλήλων");
        ListaIpallilonButton.setToolTipText("Λίστα Υπαλλήλων");
        ListaIpallilonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaIpallilonButtonActionPerformed(evt);
            }
        });

        SubTypeButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SubTypeButton.setText("Τύποι Εγγραφής");
        SubTypeButton.setToolTipText("Τύποι Εγγραφής");
        SubTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubTypeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ApothemataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListaPelatonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListaIpallilonButton, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(KratiseisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(ListaIpallilonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(ListaPelatonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(KratiseisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(ApothemataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(SubTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaIpallilonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaIpallilonButtonActionPerformed
        ListaIpallilon ipalliloi = new ListaIpallilon();
        ipalliloi.setVisible(true);
    }//GEN-LAST:event_ListaIpallilonButtonActionPerformed

    private void ListaPelatonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPelatonButtonActionPerformed
        ListaPelaton pelates = new ListaPelaton();
        pelates.setVisible(true);
    }//GEN-LAST:event_ListaPelatonButtonActionPerformed

    private void KratiseisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KratiseisButtonActionPerformed
        Kratiseis kratiseis = new Kratiseis();
        kratiseis.setVisible(true);
    }//GEN-LAST:event_KratiseisButtonActionPerformed

    private void ApothemataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApothemataButtonActionPerformed
        ListaBiblion apothemata = new ListaBiblion();
        apothemata.setVisible(true);
    }//GEN-LAST:event_ApothemataButtonActionPerformed

    private void SubTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubTypeButtonActionPerformed
        ListaEggrafon eggrafes = new ListaEggrafon();
        eggrafes.setVisible(true);
    }//GEN-LAST:event_SubTypeButtonActionPerformed

    private void refreshLogsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshLogsButtonActionPerformed
        backlogger();
    }//GEN-LAST:event_refreshLogsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                backlogger();
                new MainMenu().setVisible(true);
            }
        });
    }
    
    public static void backlogger(){
        /*
        String filename="src/logger.txt";
        BufferedWriter bw= null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename, true);
            bw = new BufferedWriter(fw);
            bw.write(getLogs());
            bw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        */
        try {
            PrintWriter writer = new PrintWriter("src/logger.txt");
            writer.print("Αυτές είναι οι αλλαγές που έχουν γίνει στις κρατήσεις :\n"+ getLogs());
            writer.close();
        }catch (Exception e){
            System.err.println(e);}
    }
    
    
    public static String getLogs(){
        MySQLConnect mysqlConnect = new MySQLConnect();
        
        ArrayList Command = new ArrayList();
        ArrayList RID = new ArrayList();
        ArrayList CID = new ArrayList();
        ArrayList BID = new ArrayList();
        ArrayList SID = new ArrayList();
        ArrayList Exp_date = new ArrayList();
        ArrayList StartDate = new ArrayList();

        try {
            Statement st = mysqlConnect.connect().createStatement();
            String sql = "call get_res_logs()";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Command.add(rs.getString("Command"));
                RID.add(rs.getString("RID"));
                CID.add(rs.getString("CID"));
                BID.add(rs.getString("BID"));
                SID.add(rs.getString("SID"));
                Exp_date.add(rs.getString("Exp_date"));
                StartDate.add(rs.getString("StartDate"));


            }
        }catch (Exception e) {
            System.err.println(e);
        }
        Command.add("Command");
        RID.add("RID");
        CID.add("CID");
        BID.add("BID");
        SID.add("SID");
        Exp_date.add("Exp_date");
        StartDate.add("LogDate");

        String [] s = new String[Command.size()];

        s[0] ="|"+ Command.get(Command.size()-1)+"|\t|"+RID.get(Command.size()-1)+"|\t|"+CID.get(Command.size()-1)+"|\t|"+
                    BID.get(Command.size()-1)+"|\t|"+SID.get(Command.size()-1)+"|\t|"+Exp_date.get(Command.size()-1)+"|\t\t|"+
                    StartDate.get(Command.size()-1)+"|\n";


        for (int i=0; i<Command.size()-1; i++){
            s[i+1] = Command.get(i)+"\t\t"+RID.get(i)+"\t"+CID.get(i)+"\t"+
                    BID.get(i)+"\t"+SID.get(i)+"\t"+Exp_date.get(i)+"\t"+
                    StartDate.get(i)+"\t";
        }
        String logs="\n";
        for (int i=0; i<s.length;i++){
            logs +=s[i] +"\n";
        }
        
        mysqlConnect.disconnect();
        return logs;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApothemataButton;
    private javax.swing.JButton KratiseisButton;
    private javax.swing.JButton ListaIpallilonButton;
    private javax.swing.JButton ListaPelatonButton;
    private javax.swing.JButton SubTypeButton;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton refreshLogsButton;
    // End of variables declaration//GEN-END:variables
}

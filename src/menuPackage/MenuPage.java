/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menuPackage;

import WelcomePages.LoginP;
import java.awt.Color;
import javax.swing.JLabel;
import modeloDesign.AnimateBTT;
import raventab.CoachTabs;
import raventab.TraineeTabs;


public class MenuPage extends javax.swing.JFrame {

    public static JLabel btnCoaches;
    public static JLabel btnCourse;

    
    AnimateBTT ColorOP = new AnimateBTT ();
    
    
    public MenuPage() {
        initComponents();
        setBackground(new Color (0,0,0,0));
     ColorOP.AnimattIni();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new nicemenu.PanelGradient();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Menu = new nicemenu.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        btt_inicio = new nicemenu.PanelGradient();
        lbl_ini = new javax.swing.JLabel();
        btt_prueba = new nicemenu.PanelGradient();
        lbl_prueba = new javax.swing.JLabel();
        btt_pruebaOne = new nicemenu.PanelGradient();
        lbl_pruebaOne = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        panelGradient1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGradient1.add(jButton1);
        jButton1.setBounds(30, 520, 110, 40);

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("main");
        setMinimumSize(new java.awt.Dimension(175, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(204, 204, 204));
        Menu.setRoundBottomLeft(200);
        Menu.setRoundTopRight(200);
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Pristina", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu page");
        Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 80));

        btt_inicio.setBackground(new java.awt.Color(255, 153, 153));
        btt_inicio.setColorGradient(new java.awt.Color(255, 51, 51));
        btt_inicio.setRadius(10);
        btt_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_inicioMousePressed(evt);
            }
        });
        btt_inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ini.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ini.setFont(new java.awt.Font("Lucida Fax", 2, 18)); // NOI18N
        lbl_ini.setForeground(new java.awt.Color(204, 204, 204));
        lbl_ini.setText("Coaches");
        lbl_ini.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                lbl_iniAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lbl_ini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_iniMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_iniMousePressed(evt);
            }
        });
        btt_inicio.add(lbl_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 32));

        Menu.add(btt_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 100, 32));

        btt_prueba.setBackground(new java.awt.Color(255, 0, 204));
        btt_prueba.setColorGradient(new java.awt.Color(102, 0, 102));
        btt_prueba.setRadius(10);
        btt_prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaMousePressed(evt);
            }
        });
        btt_prueba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_prueba.setBackground(new java.awt.Color(204, 204, 255));
        lbl_prueba.setFont(new java.awt.Font("Lucida Fax", 2, 18)); // NOI18N
        lbl_prueba.setForeground(new java.awt.Color(51, 51, 51));
        lbl_prueba.setText("Courses");
        lbl_prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pruebaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaMousePressed(evt);
            }
        });
        btt_prueba.add(lbl_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 32));

        Menu.add(btt_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 100, 32));

        btt_pruebaOne.setBackground(new java.awt.Color(0, 255, 0));
        btt_pruebaOne.setColorGradient(new java.awt.Color(102, 51, 0));
        btt_pruebaOne.setRadius(10);
        btt_pruebaOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btt_pruebaOneMousePressed(evt);
            }
        });
        btt_pruebaOne.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_pruebaOne.setBackground(new java.awt.Color(204, 204, 255));
        lbl_pruebaOne.setFont(new java.awt.Font("Lucida Fax", 2, 18)); // NOI18N
        lbl_pruebaOne.setForeground(new java.awt.Color(51, 51, 51));
        lbl_pruebaOne.setText("Trainees");
        lbl_pruebaOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pruebaOneMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_pruebaOneMousePressed(evt);
            }
        });
        btt_pruebaOne.add(lbl_pruebaOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 32));

        Menu.add(btt_pruebaOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 100, 32));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("____________");
        Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 150, 20));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("\" The pain you feel today will be the strength you feel tomorrow \".");
        Menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 440, 30));

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("____________________");
        Menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, 20));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("___________________________");
        Menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, -1, 20));

        jLabel7.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("HEROES ");
        Menu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 130, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("GYM");
        Menu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 80, 30));
        Menu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, -1, 550));

        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btt_pruebaOneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaOneMousePressed
        ColorOP.AnimattpruebaOne();
    }//GEN-LAST:event_btt_pruebaOneMousePressed

    private void lbl_pruebaOneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaOneMousePressed
        ColorOP.AnimattpruebaOne();
    }//GEN-LAST:event_lbl_pruebaOneMousePressed

    private void btt_pruebaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_pruebaMousePressed
        ColorOP.Animattprueba();
    }//GEN-LAST:event_btt_pruebaMousePressed

    private void lbl_pruebaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaMousePressed
        ColorOP.Animattprueba();
    }//GEN-LAST:event_lbl_pruebaMousePressed

    private void btt_inicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btt_inicioMousePressed
        ColorOP.AnimattIni();
    }//GEN-LAST:event_btt_inicioMousePressed

    private void lbl_iniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iniMousePressed
        ColorOP.AnimattIni();
    }//GEN-LAST:event_lbl_iniMousePressed

    private void lbl_iniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_iniMouseClicked
        // TODO add your handling code here:
        CoachTabs coach=new CoachTabs(); coach.setVisible(true); dispose();
    }//GEN-LAST:event_lbl_iniMouseClicked

    private void lbl_iniAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lbl_iniAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_iniAncestorMoved

    private void lbl_pruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaMouseClicked
        raventab.CourseTabs course = new raventab.CourseTabs();
        course.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_pruebaMouseClicked

    private void lbl_pruebaOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pruebaOneMouseClicked
        // TODO add your handling code here:
        TraineeTabs traine=new TraineeTabs(); traine.setVisible(true); dispose();
    }//GEN-LAST:event_lbl_pruebaOneMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static nicemenu.PanelRound Menu;
    public static nicemenu.PanelGradient btt_inicio;
    public static nicemenu.PanelGradient btt_prueba;
    public static nicemenu.PanelGradient btt_pruebaOne;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lbl_ini;
    public static javax.swing.JLabel lbl_prueba;
    public static javax.swing.JLabel lbl_pruebaOne;
    private nicemenu.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables

}

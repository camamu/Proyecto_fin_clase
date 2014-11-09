/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Informe extends javax.swing.JFrame {
int opcion = 0;
    /**
     * Creates new form Alarmas
     */
    public Informe() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/IconoCES.png")).getImage());
        grupo.add(admitidos);
        grupo.add(reservados);
        grupo.add(matriculados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        admitidos = new javax.swing.JRadioButton();
        reservados = new javax.swing.JRadioButton();
        matriculados = new javax.swing.JRadioButton();
        Panel = new Panel("/Imagenes/LogoCES.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar informe");

        jButton1.setText("Generar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        admitidos.setText("Clientes admitidos");
        admitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admitidosActionPerformed(evt);
            }
        });

        reservados.setText("Clientes reservados");
        reservados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservadosActionPerformed(evt);
            }
        });

        matriculados.setText("Clientes matriculados");
        matriculados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reservados)
                            .addComponent(admitidos)
                            .addComponent(matriculados))
                        .addGap(150, 150, 150)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(admitidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reservados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matriculados)
                        .addGap(3, 3, 3))
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matriculadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculadosActionPerformed
        // TODO add your handling code here:
        if (matriculados.isSelected()) {
            opcion = 3;
        }
    }//GEN-LAST:event_matriculadosActionPerformed

    private void reservadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservadosActionPerformed
        // TODO add your handling code here:
        if (reservados.isSelected()) {
            opcion = 2;
        }
    }//GEN-LAST:event_reservadosActionPerformed

    private void admitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admitidosActionPerformed
        // TODO add your handling code here:
        if (admitidos.isSelected()) {
            opcion = 1;
        }
    }//GEN-LAST:event_admitidosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GenInforme infome = new GenInforme();
        switch(opcion){
            case 1:
                try {
                infome.admitido();
                } catch (FileNotFoundException ex) {
                Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
 
                File file1 = new File("C:/Informes/admitido.html");
                Desktop.getDesktop().open(file1);
                } catch(Exception e) {
                e.printStackTrace();
                }

                break;
            case 2:
                infome.reservado();
                try{
                File file2 = new File("C:/Informes/reservado.html");
                Desktop.getDesktop().open(file2);
                } catch(Exception e) {
                e.printStackTrace();
                }
                break;
            case 3:
                infome.matriculado();
                try{
                File file3 = new File("C:/Informes/matriculado.html");
                Desktop.getDesktop().open(file3);
                } catch(Exception e) {
                e.printStackTrace();
                }
                break;
            default:
                JOptionPane.showMessageDialog(null,"Selecciona una opción");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JRadioButton admitidos;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton matriculados;
    private javax.swing.JRadioButton reservados;
    // End of variables declaration//GEN-END:variables
}
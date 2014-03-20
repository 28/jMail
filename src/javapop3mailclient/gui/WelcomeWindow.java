package javapop3mailclient.gui;

import java.io.IOException;
import javapop3mailclient.controller.Controller;
import javapop3mailclient.controller.HostParseException;
import javapop3mailclient.systemoperations.CredentialsFormException;
import javapop3mailclient.systemoperations.ErrResponseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dejan Josifovic
 */
public class WelcomeWindow extends javax.swing.JFrame {

    /**
     *
     */
    public WelcomeWindow() {
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

        getMailButton = new java.awt.Button();
        emailTextField = new java.awt.TextField();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        welcomeWindowMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaPOP3MailClient - Welcome");

        getMailButton.setLabel("Get Mail");
        getMailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMailButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("E-mail:");

        passwordLabel.setText("Password:");

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        welcomeWindowMenuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        welcomeWindowMenuBar.add(helpMenu);

        setJMenuBar(welcomeWindowMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailLabel)
                    .addComponent(passwordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getMailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(getMailButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        try {
            Controller.getInstance().exit();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "JavaPOP3MailClient - Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     *
     * @param evt
     */
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutWindow aboutWindow = new AboutWindow(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**
     *
     * @param evt
     */
    private void getMailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMailButtonActionPerformed
        try {
            String email = emailTextField.getText().trim();
            String password = new String(passwordPasswordField.getPassword());
            Controller.getInstance().signIn(email, password);
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            this.dispose();
        } catch (HostParseException | IOException | CredentialsFormException | ErrResponseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "JavaPOP3MailClient - Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
    }//GEN-LAST:event_getMailButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WelcomeWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel emailLabel;
    private java.awt.TextField emailTextField;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private java.awt.Button getMailButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JMenuBar welcomeWindowMenuBar;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        emailTextField.setText("");
        passwordPasswordField.setText("");
    }
}

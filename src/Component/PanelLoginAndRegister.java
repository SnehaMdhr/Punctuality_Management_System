package Component;

import swing.MyTextField;
import swing.MyPasswordField;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import swing.Button;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane implements ActionListener{

    Button loginButton;
    Button cmd;
    MyTextField txtUser ;
    MyTextField txtEmail;
    MyPasswordField txtPassword;
    
    public PanelLoginAndRegister() {
        initComponents();
        initLogin();
        initRegister();
        login.setVisible(false);
        register.setVisible(true);
        
    }
    
    private void initRegister(){
        register.setLayout(new MigLayout("wrap" , "push[center]push","push[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font ("Times new roman" , 1 , 30));
        label.setForeground(new Color(100, 20, 201 ));
        register.add(label);
        
        txtUser= new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        
        register.add(txtUser, "w 50% , x 25%,y 35%");
        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 50% , x 25%,y 45%");
        
        txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPassword.setHint("Password");
        register.add(txtPassword, "w 50% , x 25%,y 55%");
        cmd = new Button();
        
        cmd.setBackground(new Color(100, 20, 201));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cmd ){
        try{
            conn conn = new conn();
            String userName = txtUser.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();

            // Ensure that the table has a `username` column or modify the query to insert only into `email` and `password`
            String query = "INSERT INTO users (username, email, password) VALUES ('" + userName + "', '" + email + "', '" + password + "')";
            
            conn.s.executeUpdate(query);
            conn.s.close();
            System.out.println("User registered successfully.");
            JOptionPane.showMessageDialog(null, "User registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        else if(ae.getSource() == loginButton){
        
            try{
            conn conn = new conn();
            String email = txtEmail.getText();
            String password = txtPassword.getText();
            String query = "select * from users where email = '"+email+"' and password = '"+password+"'";
            
            
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successful");
                new dashboardadm().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid");
            }
            }
            catch(Exception e){
                e.printStackTrace();

            }
    }
        
    }
    
    
    
    
    
    private void initLogin(){
     login.setLayout(new MigLayout("wrap" , "push[center]push","push[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font ("Times new roman" , 1 , 30));
        label.setForeground(new Color(100, 20, 201));
        login.add(label);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 50% , x 25%,y 30%");
        
        MyPasswordField txtPassword = new  MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPassword.setHint("Password");
        login.add(txtPassword, "w 50% , x 25%,y 40%");
        
        
        
        loginButton = new Button();
        loginButton.setBackground(new Color(100, 20, 201));
        loginButton.setForeground(new Color(250, 250, 250));
        loginButton.setText("Log In");
        login.add(loginButton, "w 40%,x 30%,y 55%");
        
        loginButton.addActionListener(this);
    }
     public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}

package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JFrame frame;

    public void start(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Login window = new Login();
                    window.frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public Login(){
        initialize();
    }

    private void initialize(){
        frame = new JFrame("game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setSize(screenSize);
        //frame.setBounds(100, 100, 1000, 500);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(frame.getBounds().height/2,100,120,30);
        frame.getContentPane().add(lblName);

        JTextField name = new JTextField();
        name.setBounds(frame.getBounds().height/2+150,100,160,30);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblSurname = new JLabel("Surname");
        System.out.println(screenSize.height);
        lblSurname.setBounds(frame.getBounds().height/2,200,120,30);
        frame.getContentPane().add(lblSurname);

        JTextField surname = new JTextField();
        surname.setBounds(frame.getBounds().height/2+150,200,160,30);
        frame.getContentPane().add(surname);
        surname.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(frame.getBounds().height/2,300,120,30);
        frame.getContentPane().add(lblPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(frame.getBounds().height/2+150,300,160,30);
        frame.getContentPane().add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usName = name.getText();
                String usSurname = surname.getText();
                String usPassword = passwordField.getText();

                if(usName.equals("name") && usSurname.equals("surname") &&
                        usPassword.equals("password")){
                    JOptionPane.showMessageDialog(frame, "Successfully log in");
                }else{
                    JOptionPane.showMessageDialog(frame, "Invalid username or password");
                }
            }
        });
        loginButton.setBounds(frame.getBounds().height/2, 400, 90, 30);
        frame.getContentPane().add(loginButton);
    }
}

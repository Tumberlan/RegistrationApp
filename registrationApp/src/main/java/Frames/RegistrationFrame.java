package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RegistrationFrame{

    private JFrame frame;

    public void start(File usersData){
        frame.setVisible(true);
    }

    public RegistrationFrame(JFrame frame, File usersData){
        this.frame = frame;
        frame.setName("Registration");
        initialize(usersData);
    }

    public void setVision(boolean vision){
        frame.setVisible(vision);
    }

    private void initialize(File usersData){
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
        name.setBounds(frame.getBounds().height/2+100,100,160,30);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(frame.getBounds().height/2,200,120,30);
        frame.getContentPane().add(lblSurname);

        JTextField surname = new JTextField();
        surname.setBounds(frame.getBounds().height/2+100,200,160,30);
        frame.getContentPane().add(surname);
        surname.setColumns(10);

        JLabel lblBirthDate = new JLabel("Birth date");
        lblBirthDate.setBounds(frame.getBounds().height/2,300,120,30);
        frame.getContentPane().add(lblBirthDate);

        JTextField birthDate = new JTextField();
        birthDate.setBounds(frame.getBounds().height/2+100,300,160,30);
        frame.getContentPane().add(birthDate);
        birthDate.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(frame.getBounds().height/2,400,120,30);
        frame.getContentPane().add(lblPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(frame.getBounds().height/2+100,400,160,30);
        frame.getContentPane().add(passwordField);

        JLabel lblPasswordConfirm1 = new JLabel("Confirm");
        lblPasswordConfirm1.setBounds(frame.getBounds().height/2,490,120,30);
        frame.getContentPane().add(lblPasswordConfirm1);
        JLabel lblPasswordConfirm2 = new JLabel("password");
        lblPasswordConfirm2.setBounds(frame.getBounds().height/2,505,120,30);
        frame.getContentPane().add(lblPasswordConfirm2);

        JPasswordField passwordConfirmField = new JPasswordField();
        passwordConfirmField.setBounds(frame.getBounds().height/2+100,500,160,30);
        frame.getContentPane().add(passwordConfirmField);

        JButton loginButton = new JButton("Registration");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usName = name.getText();
                String usSurname = surname.getText();
                String usPassword = passwordField.getText();

                if(usName.equals("name")){

                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(usersData);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    assert fileOutputStream != null;
                    PrintStream printStream = new PrintStream(fileOutputStream);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(usName).append(";").append(usSurname).append(";").append(usPassword);
                    printStream.println(stringBuilder.toString());
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    GreetingFrame greetingFrame = null;
                    try {
                        greetingFrame = new GreetingFrame(frame,usersData);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    greetingFrame.start();


                }
            }
        });
        loginButton.setBounds(frame.getBounds().height/2+60, 600, 120, 40);
        frame.getContentPane().add(loginButton);
    }
}

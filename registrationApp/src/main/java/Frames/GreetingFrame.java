package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GreetingFrame {

    JFrame frame;

    public void start(){
        frame.setVisible(true);
    }

    public GreetingFrame(JFrame frame, File usersData) throws IOException {
        this.frame = frame;
        frame.setName("Greetings");
        initialize(usersData);
    }

    public void setVision(boolean vision){
        frame.setVisible(vision);
    }

    private void initialize(File usersData) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setSize(screenSize);
        //frame.setBounds(100, 100, 1000, 500);
        frame.getContentPane().setLayout(null);

        JButton greetingsButton = new JButton("Greetings");
        greetingsButton.addActionListener(new ActionListener() {
            FileReader fileReader = new FileReader(usersData);
            BufferedReader reader = new BufferedReader(fileReader);
            String newString = reader.readLine();
            String[] subString = newString.split(";");
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello, dear " + subString[0]+"!");
            }
        });
        greetingsButton.setBounds(frame.getBounds().height/2+60, 600, 120, 40);
        frame.getContentPane().add(greetingsButton);

    }
}

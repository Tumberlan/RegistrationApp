package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GreetingFrame {

    private static final int START_FRAME_LOCATION_X = 0;
    private static final int START_FRAME_LOCATION_Y = 0;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 40;
    private static final int NAME_POSITION_IN_FILE_STRING = 0;
    private final JFrame frame;

    public void start() {
        frame.setVisible(true);
    }

    public GreetingFrame(JFrame frame, File usersData) throws IOException {
        this.frame = frame;
        initialize(usersData);
    }

    private void initialize(File usersData) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(START_FRAME_LOCATION_X, START_FRAME_LOCATION_Y);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xForButton = (screenSize.width) / 2 - BUTTON_WIDTH / 2;
        int yForButton = (screenSize.height) / 2 - BUTTON_HEIGHT / 2;
        frame.setSize(screenSize);
        frame.getContentPane().setLayout(null);

        JButton greetingsButton = new JButton("Greetings");
        greetingsButton.addActionListener(new ActionListener() {
            FileReader fileReader = new FileReader(usersData);
            BufferedReader reader = new BufferedReader(fileReader);
            String newString = reader.readLine();
            String[] subString = newString.split(";");

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello, dear " + subString[NAME_POSITION_IN_FILE_STRING] + "!");
            }
        });
        greetingsButton.setBounds(xForButton, yForButton, BUTTON_WIDTH, BUTTON_HEIGHT);
        frame.getContentPane().add(greetingsButton);

    }
}

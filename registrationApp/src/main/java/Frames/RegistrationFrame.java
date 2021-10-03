package Frames;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegistrationFrame {

    private static final int START_FRAME_LOCATION_X = 0;
    private static final int START_FRAME_LOCATION_Y = 0;
    private static final int LABEL_WIDTH = 120;
    private static final int LABEL_AND_FIELD_HEIGHT = 30;
    private static final int FIELD_WIDTH = 160;
    private static final int FIELD_OFFSET = 100;
    private static final int BUTTON_WIDTH = 120;
    private static final int BUTTON_HEIGHT = 40;
    private static final int NAME_Y = 100;
    private static final int SURNAME_Y = 200;
    private static final int BIRTH_DATE_Y = 300;
    private static final int PASSWORD_Y = 400;
    private static final int PASSWORD_CONFIRMATION_Y_TOP = 490;
    private static final int PASSWORD_CONFIRMATION_Y_BOT = 505;
    private static final int PASSWORD_CONFIRMATION_Y = 500;
    private static final int BUTTON_Y = 600;
    private static final int YEAR_DATE_POSITION = 5;
    private static final int MONTH_DAY_DATE_POSITION = 2;
    private static final int AVAILABLE_YEAR_GAP = 12;
    private static final int AVAILABLE_MONTH_GAP = 0;
    private static final int AVAILABLE_MONTH_DAY_GAP = 0;
    private static final int AVAILABLE_NAME_LENGTH = 2;
    private static final int AVAILABLE_SURNAME_LENGTH = 1;
    private static final int AVAILABLE_PASSWORD_LENGTH = 6;
    private static final String NUMBERS_IN_PASSWORD = ".*\\d+.*";
    private static final String NO_LETTERS_IN_PASSWORD = "\\d+";

    private final JFrame frame;
    private String userName;
    private String userSurname;
    private String userPassword;


    public void start() {
        frame.setVisible(true);
    }

    public RegistrationFrame(JFrame frame, File usersData) {
        this.frame = frame;
        initialize(usersData);
    }

    private void initialize(File usersData) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(START_FRAME_LOCATION_X, START_FRAME_LOCATION_Y);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xForLabel = (screenSize.width) / 2 - LABEL_WIDTH;
        int xForButton = (screenSize.width) / 2 - BUTTON_WIDTH / 2;
        int xForField = xForLabel + FIELD_OFFSET;
        frame.setSize(screenSize);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(xForLabel, NAME_Y, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblName);

        JTextField name = new JTextField();
        name.setBounds(xForField, NAME_Y, FIELD_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(xForLabel, SURNAME_Y, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblSurname);

        JTextField surname = new JTextField();
        surname.setBounds(xForField, SURNAME_Y, FIELD_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(surname);
        surname.setColumns(10);

        JLabel lblBirthDate = new JLabel("Birth date");
        lblBirthDate.setBounds(xForLabel, BIRTH_DATE_Y, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblBirthDate);


        JDateChooser birthDate = new JDateChooser();
        birthDate.setLocale(Locale.ENGLISH);
        birthDate.setBounds(xForField, BIRTH_DATE_Y, FIELD_WIDTH, LABEL_AND_FIELD_HEIGHT);
        birthDate.setCalendar(Calendar.getInstance());
        frame.getContentPane().add(birthDate);


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(xForLabel, PASSWORD_Y, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblPassword);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(xForField, PASSWORD_Y, FIELD_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(passwordField);

        JLabel lblPasswordConfirm1 = new JLabel("Confirm");
        lblPasswordConfirm1.setBounds(xForLabel, PASSWORD_CONFIRMATION_Y_TOP, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblPasswordConfirm1);

        JLabel lblPasswordConfirm2 = new JLabel("password");
        lblPasswordConfirm2.setBounds(xForLabel, PASSWORD_CONFIRMATION_Y_BOT, LABEL_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(lblPasswordConfirm2);

        JPasswordField passwordConfirmField = new JPasswordField();
        passwordConfirmField.setBounds(xForField, PASSWORD_CONFIRMATION_Y, FIELD_WIDTH, LABEL_AND_FIELD_HEIGHT);
        frame.getContentPane().add(passwordConfirmField);

        JButton loginButton = new JButton("Registration");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isFieldsCorrect(name, surname, birthDate, passwordField, passwordConfirmField)) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(usersData);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    assert fileOutputStream != null;
                    PrintStream printStream = new PrintStream(fileOutputStream);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(userName).append(";").append(userSurname).append(";").append(userPassword);
                    printStream.println(stringBuilder.toString());
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    GreetingFrame greetingFrame = null;
                    try {
                        greetingFrame = new GreetingFrame(frame, usersData);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    greetingFrame.start();
                }

            }
        });
        loginButton.setBounds(xForButton, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        frame.getContentPane().add(loginButton);
    }


    public boolean isFieldsCorrect(JTextField name, JTextField surname, JDateChooser birthDate, JPasswordField password, JPasswordField passwordConfirmation) {

        userName = name.getText();
        if (userName.length() < AVAILABLE_NAME_LENGTH) {
            JOptionPane.showMessageDialog(frame, "Name should be longer than 1 symbol");
            return false;
        }

        userSurname = surname.getText();
        if (userSurname.length() < AVAILABLE_SURNAME_LENGTH) {
            JOptionPane.showMessageDialog(frame, "Surname should be longer than 0 symbols");
            return false;
        }

        String birthDateString = birthDate.getDate().toString();
        String[] userBirthDate = birthDateString.split(" ");
        Date nowDate = new Date();
        String nowDateString = nowDate.toString();
        String[] nowTime = nowDateString.split(" ");
        int yearGap = Integer.parseInt(nowTime[YEAR_DATE_POSITION]) - Integer.parseInt(userBirthDate[YEAR_DATE_POSITION]);
        int monthGap = nowDate.getMonth() - birthDate.getDate().getMonth();
        int monthDayGap = Integer.parseInt(nowTime[MONTH_DAY_DATE_POSITION]) - Integer.parseInt(userBirthDate[MONTH_DAY_DATE_POSITION]);
        if (yearGap < AVAILABLE_YEAR_GAP || (yearGap == AVAILABLE_YEAR_GAP && monthGap < AVAILABLE_MONTH_GAP) ||
                (yearGap == AVAILABLE_YEAR_GAP && monthGap == AVAILABLE_MONTH_GAP && monthDayGap < AVAILABLE_MONTH_DAY_GAP)) {
            JOptionPane.showMessageDialog(frame, "You're too young, sorry. Yo need to be 12+ years old");
            return false;
        }

        userPassword = password.getText();
        if (userPassword.length() < AVAILABLE_PASSWORD_LENGTH) {
            JOptionPane.showMessageDialog(frame, "Your password should be longer than 5 symbols");
            return false;
        }
        if (!userPassword.matches(NUMBERS_IN_PASSWORD) || userPassword.matches(NO_LETTERS_IN_PASSWORD)) {
            JOptionPane.showMessageDialog(frame, "Your password should contain numbers and letters");
            return false;
        }

        String userPasswordConfirmation = passwordConfirmation.getText();
        if (!userPasswordConfirmation.equals(userPassword)) {
            JOptionPane.showMessageDialog(frame, "Your passwords don't match");
            return false;
        }

        return true;
    }


}

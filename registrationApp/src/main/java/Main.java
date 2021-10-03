import Frames.RegistrationFrame;
import Login.Login;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args){
        //new JFormattedTextFieldTest();
        File usersData = new File("src\\main\\resources", "usersData.txt");
        JFrame frame = new JFrame("app");
        RegistrationFrame registrationFrame = new RegistrationFrame(frame,usersData);
        registrationFrame.start(usersData);
    }
}

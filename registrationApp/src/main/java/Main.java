import Frames.RegistrationFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {

    public static void main(String[] args){
        //new JFormattedTextFieldTest();
        File usersData = new File("src\\main\\resources", "usersData.txt");
        JFrame frame = new JFrame("app");
        GridBagLayout layout = new GridBagLayout();
        RegistrationFrame registrationFrame = new RegistrationFrame(frame,usersData);
        registrationFrame.start();
    }
}

import Frames.RegistrationFrame;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File usersData = new File("src\\main\\resources", "usersData.txt");
        JFrame frame = new JFrame("app");
        RegistrationFrame registrationFrame = new RegistrationFrame(frame, usersData);
        registrationFrame.start();
    }
}

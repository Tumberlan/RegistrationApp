import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static enum STATES{REGISTRATION, EXECUTION}
    public static STATES state = STATES.REGISTRATION;

    public Panel(){
        super();
        setFocusable(true);
        requestFocus();


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(state.equals(STATES.REGISTRATION)){

        }
    }


}

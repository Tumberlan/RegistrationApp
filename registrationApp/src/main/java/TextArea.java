import javax.swing.*;
import java.awt.*;

public class TextArea extends JFrame {

    public TextArea() {

        super("First window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea firstTextArea = new JTextArea("Insert your name", 8,10);

        firstTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        firstTextArea.setTabSize(10);

        JTextArea secondTextArea = new JTextArea("Insert your surname", 8, 10);
        secondTextArea.setLineWrap(true);
        secondTextArea.setWrapStyleWord(true);

        JPanel contents = new JPanel();
        contents.add(new JScrollPane(firstTextArea));
        contents.add(new JScrollPane(secondTextArea));
        setContentPane(contents);

        setSize(400, 300);
        setVisible(true);
    }
}

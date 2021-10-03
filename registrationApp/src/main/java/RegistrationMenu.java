import java.awt.*;

public class RegistrationMenu {

    private int buttonsNumber;
    private Color color;
    private double buttonX;
    private double buttonY;
    private double buttonWidth;
    private double buttonHeight;

    String[] buttonsList;

    public RegistrationMenu(){
        buttonX = 100;
        buttonY = 0;
        buttonWidth = 300;
        buttonHeight = 80;
        color = Color.yellow;
        buttonsList = new String[]{"1", "2", "3", "4"};
        buttonsNumber = buttonsList.length;
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < buttonsNumber; i++){
            Button button = new Button(buttonsList[i]);
            button.setFont(new Font("Arial", Font.ITALIC, 50));
            button.setBackground(color);

        }
    }
}

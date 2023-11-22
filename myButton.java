import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import java.beans.EventHandler;
import java.util.ArrayList;

public class myButton extends ToggleButton {
    int number;

    public myButton(int num){
        super(Integer.toString(num));
        number = num;
    }

    Integer getNum(){
        return number;
    }
}

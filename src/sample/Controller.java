package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;

public class Controller {

    int number;



    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    private TextField Display;


    public void buttonPress(ActionEvent event){

        if(event.getSource() == button1 ){

            Display.appendText("1");
        }
       else if(event.getSource() == button2){

           Display.appendText("2");
       }
        else if(event.getSource() == button3){

            Display.appendText("3");
        }
        else if(event.getSource() == button4){

            Display.appendText("4");
        }
        else if(event.getSource() == button5){

            Display.appendText("5");
        }
        else if(event.getSource() == button6){

            Display.appendText("6");
        }

        else if(event.getSource() == button7){

            Display.appendText("7");
        }

        else if(event.getSource() == button8){

            Display.appendText("8");
        }

        else if(event.getSource() == button9){

            Display.appendText("9");
        }






    }


}

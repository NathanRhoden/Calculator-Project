package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Scanner;
import java.util.Stack;

public class Controller {

    int number;
    int result;


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
    private Button button0;
    @FXML
    private TextField Display;
    @FXML
    private Button button_BACK;
    @FXML
    private Button additionButton;
    @FXML
    private Button EQUALS_Button;
    @FXML
    private TextField historyTextField;

    private Stack<Integer> CALC_MEMORY = new Stack<>();





    //COULD TRY SWITCH CASE HERE
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
        else if(event.getSource() == button0){

            Display.appendText("0");
        }
        else if(event.getSource() == button_BACK){

            Display.deletePreviousChar();

        }







    }

    public int getNumberINT(){

        return Integer.parseInt(Display.getText());
    }
    public String getNumberString(){

        return Display.getText();
    }
    public void  printToScreen(int number){

        Display.appendText(Integer.toString(number));
    }

    private void pushToStack(int n){

        CALC_MEMORY.push(n);
    }

    public void ADD_BUTTON_PRESSED(){

        int FIRST_NUMBER;
        int SECOND_NUMBER = 0 ;
        int result= 0;

        if(CALC_MEMORY.isEmpty()) {
            FIRST_NUMBER = getNumberINT();
            CALC_MEMORY.push(FIRST_NUMBER);
            historyTextField.appendText(Display.getText() + " + ");
            clearDisplay();;
        }



    }
    private void clearDisplay(){
        Display.clear();
    }




}

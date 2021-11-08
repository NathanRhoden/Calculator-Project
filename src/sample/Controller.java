package sample;

import com.sun.prism.image.CachingCompoundImage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

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
    private Button clear_Button;
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
    } //CHANGES STRING TO INT AFTER READING FROM DISPLAY

    public String returnNumberAsString(){

        return Display.getText();
    } //CHANGES INT TO STRING AFTER READING FROM DISPLAY

    public void  printToScreen(int number){

        Display.appendText(Integer.toString(number));
    } // PRINTS INT ONTO DISPLAY

    private void pause(){
        Platform.enterNestedEventLoop(additionButton);

    }
    private void resume(){
        Platform.exitNestedEventLoop(additionButton, null);
    }

    public void clearButton(MouseEvent event){

        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {

            Display.clear();

        }
        else if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){

            Display.clear();
            CALC_MEMORY.clear();
            historyTextField.clear();
        }

    }










    private String INT_TO_STRING(int number){

        return Integer.toString(number);


    } // CONVERTS INT TO STRING GIVEN AS ARG

    public void handle_ADDITION(MouseEvent event){

        int RESULT = 0 ;

        if(CALC_MEMORY.isEmpty()){

            RESULT += getNumberINT();
            CALC_MEMORY.push(RESULT);
            System.out.println(RESULT + " : Added to stack");
            System.out.println(RESULT);
            System.out.println("NO STACK");
            historyTextField.appendText(returnNumberAsString() + " + ");
            Display.clear();


        }
        else if(!CALC_MEMORY.isEmpty()){


            RESULT += CALC_MEMORY.peek() + getNumberINT();
            CALC_MEMORY.push(RESULT);
            System.out.println(RESULT + " : Added to stack");
            System.out.println(RESULT);
            System.out.println("ON TOP OF STACK");
            clearDisplay();
            Display.appendText(String.valueOf(RESULT));

        }



    }


    private void clearDisplay(){ // CLEARS DISPLAY
        Display.clear();
    }




}

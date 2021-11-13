package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.util.Stack;

public class Controller {


    float result;
    float a = 0;
    String calculation;


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
    private Button multiplicationButton;
    @FXML
    private Button clear_Button;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button EQUALS_Button;
    @FXML
    private TextField historyTextField;

    private Stack<Float> CALC_MEMORY = new Stack<>();

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
    private void clearDisplay(){ // CLEARS DISPLAY
        Display.clear();
    }
    public float  getNumberINT(){

        return Integer.parseInt(Display.getText());
    } //CHANGES STRING TO INT AFTER READING FROM DISPLAY
    public String returnNumberAsString(){

        return Display.getText();
    } //CHANGES INT TO STRING AFTER READING FROM DISPLAY
    public void  printToScreen(float number){

        Display.appendText(Float.toString(number));

    } // PRINTS INT ONTO DISPLAY
    public void clearButton(MouseEvent event){

        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {

            Display.clear();

        }
        else if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){

            Display.clear();
            CALC_MEMORY.clear();
            historyTextField.clear();
            System.out.println("Stack emptied");
        }

    }
    private String INT_TO_STRING(Float number){

        return Float.toString(number);


    } // CONVERTS INT TO STRING GIVEN AS ARG




    public void addition(){
        calc_setup("+");
        historyTextField.appendText(returnNumberAsString() + " + ");
        CALC_MEMORY.push(getNumberINT());
        System.out.println("In stack : " + CALC_MEMORY.peek());
        clearDisplay();
    }
    public void subtraction(){
        calc_setup("-");
        historyTextField.appendText(returnNumberAsString() + " - ");
        CALC_MEMORY.push(getNumberINT());
        System.out.println("In stack : " + CALC_MEMORY.peek());
        clearDisplay();
    }
    public void multiplication(){
        calc_setup("*");
        historyTextField.appendText(returnNumberAsString() + " x ");
        CALC_MEMORY.push(getNumberINT());
        System.out.println("In stack : " + CALC_MEMORY.peek());
        clearDisplay();

    }

    public void calc_setup(String calculation){

        this.calculation  = calculation;
    }

    public void calculationA(){

        a = CALC_MEMORY.peek();

        switch (calculation){
            case "+" ->{
                result = a + getNumberINT();
                historyTextField.appendText(INT_TO_STRING(CALC_MEMORY.peek()) + " + " + returnNumberAsString() + " = ");
                clearDisplay();
                printToScreen(result);
                CALC_MEMORY.push(result);
                System.out.println("In stack : " + CALC_MEMORY.peek());
;

            }
            case "-" -> {
                result = a - getNumberINT();
                historyTextField.appendText(INT_TO_STRING(CALC_MEMORY.peek()) + " - " + returnNumberAsString() + " = ");
                clearDisplay();
                printToScreen(result);
                CALC_MEMORY.push(result);
                System.out.println("In stack : " + CALC_MEMORY.peek());
            }
            case "*" ->{
                result = a * getNumberINT();
                historyTextField.clear();
                historyTextField.appendText(INT_TO_STRING(CALC_MEMORY.peek()) + " x " + returnNumberAsString() + " = ");
                clearDisplay();
                printToScreen(result);
                CALC_MEMORY.push(result);
                System.out.println("In stack : " + CALC_MEMORY.peek());

            }
        }



    }








}

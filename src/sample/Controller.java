package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.Stack;

public class Controller {


    float result;
    float TOP_OF_STACK = 0;
    String calculation;

    //region {BUTTONS}
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
    private Button decimal_button;
    @FXML
    private Button divisionButton;
    @FXML
    private Button squareRootButton;
    @FXML
    private Button squareButton;
    @FXML
    private Button one_Over_X_Button;
    @FXML
    private Button inverseButton;
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
    private Button percentageButton;
    @FXML
    private Button backButton;
    @FXML
    private Button removeLastDigit;
    @FXML
    private TextField historyTextField;
    //endregion

    private Stack<Float> CALC_MEMORY = new Stack<>();


    public void buttonPress(ActionEvent event){

        if(event.getSource() == button1 ){

            printToScreen(1);
        }
       else if(event.getSource() == button2){

            printToScreen(2);
       }
        else if(event.getSource() == button3){

            printToScreen(3);
        }
        else if(event.getSource() == button4){

            printToScreen(4);
        }
        else if(event.getSource() == button5){

            printToScreen(5);
        }
        else if(event.getSource() == button6){

            printToScreen(6);
        }

        else if(event.getSource() == button7){

            printToScreen(7);
        }

        else if(event.getSource() == button8){

            printToScreen(8);
        }

        else if(event.getSource() == button9){

            printToScreen(9);
        }
        else if(event.getSource() == button0){

            printToScreen(0);
        }
        else if(event.getSource() == button_BACK){

            Display.deletePreviousChar();

        }
        else if(event.getSource() == decimal_button){
            printToScreen(".");
        }

    }//PRINTS THE VARIOUS BUTTON PRESSES TO SCREEN
    private void clearDisplay(){ // CLEARS DISPLAY
        Display.clear();
    } //CLEARS THE MAIN DISPLAY
    public float getNumberDisplayedAsFloat(){

        return Float.parseFloat(Display.getText());
    } //CHANGES STRING TO INT AFTER READING FROM DISPLAY
    public String returnNumberAsString(){

        return Display.getText();
    } //CHANGES INT TO STRING AFTER READING FROM DISPLAY
    private String returnNumberAsString(int num){
        return String.valueOf(num);

    }
    private void clearHistoryTextField(){
        historyTextField.clear();
    }

    public void getHistoryTextField() {
        if (!historyTextField.getText().isEmpty()){

            historyTextField.appendText(calculation);

        }
    }//ATTEMPT AT FIX FOR HISTORY TEXT FIELD

    private void printToScreen(float number){

        Display.appendText(Float.toString(number));

    } // PRINTS FLOAT ONTO DISPLAY
    private void printToScreen(int result){
        Display.appendText(Integer.toString(result));
    }//PRINTS INT TO SCREEN
    private void printToScreen(String string){Display.appendText(string);}//PRINTS STRING TO SCREEN


    public void clearButton(MouseEvent event){

        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {

            Display.clear();

        }
        else if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2){

            Display.clear();
            CALC_MEMORY.clear();
            clearHistoryTextField();
            System.out.println("Stack emptied");
        }

    }//1 CLICK CLEARS THE DISPLAY 2 CLICKS CLEARS THE STACK
    private String INT_TO_STRING(int number){

        return Float.toString(number);


    } // CONVERTS INT TO STRING GIVEN AS ARG
    private void appendFinalCalculation(){
        historyTextField.appendText(" " + returnNumberAsString());
        clearDisplay();
        if(numberValidation(result)) {
            int j = (int) result;
            printToScreen(j);

        }
        else{
            printToScreen(result);
        }

        CALC_MEMORY.push(result);
        System.out.println("In stack : " + CALC_MEMORY.peek());
    }// APPENDS THE RESULT OF THE FINAL CALCULATION TO THE DISPLAY
    private boolean numberValidation(float num){

        if (num % 1 == 0) {
             return true;
        }
        return  false;

    }//CHECKS IF THE NUMBER HAS AN DECIMAL POINTS IF NOT IT TRUNCATES THE NUMBER
    private boolean numberValidation(double num){
        if (num % 1 == 0) {
            return true;
        }
        return  false;
    }
    private void historyCheck(){

        if (historyTextField.getText().contains(calculation)){

            historyTextField.clear();




        }

    }


    //HANDLES THE OPERATIONS OF THE CALCULATOR
    public void addition(){

        calc_setup("+");
        if(!historyTextField.getText().isEmpty()){

            TOP_OF_STACK = CALC_MEMORY.peek() + getNumberDisplayedAsFloat();
            CALC_MEMORY.push(TOP_OF_STACK);
            clearDisplay();
            clearHistoryTextField();
            printToScreen(TOP_OF_STACK);
            historyTextField.appendText(returnNumberAsString());
            clearDisplay();
            System.out.println(TOP_OF_STACK);

        }
        else {
            historyTextField.appendText(returnNumberAsString() + " + ");
            CALC_MEMORY.push(getNumberDisplayedAsFloat());
            System.out.println("In stack : " + CALC_MEMORY.peek());
            clearDisplay();
        }
    }
    public void subtraction(){
        calc_setup("-");
        if(!historyTextField.getText().isEmpty()){

            TOP_OF_STACK = CALC_MEMORY.peek() - getNumberDisplayedAsFloat();
            CALC_MEMORY.push(TOP_OF_STACK);
            clearDisplay();
            clearHistoryTextField();
            printToScreen(TOP_OF_STACK);
            historyTextField.appendText(returnNumberAsString());
            clearDisplay();
            System.out.println(TOP_OF_STACK);

        }
        else {
            clearHistoryTextField();
            historyTextField.appendText(returnNumberAsString() + " - ");
            CALC_MEMORY.push(getNumberDisplayedAsFloat());
            System.out.println("In stack : " + CALC_MEMORY.peek());
            clearDisplay();
        }
    }
    public void multiplication(){
        calc_setup("*");
        historyTextField.appendText(returnNumberAsString() + " x ");
        CALC_MEMORY.push(getNumberDisplayedAsFloat());
        System.out.println("In stack : " + CALC_MEMORY.peek());
        clearDisplay();

    }
    public void one_over_X(){
        float i = getNumberDisplayedAsFloat();
        clearDisplay();
        float result = 1/i;
        printToScreen(result);

    }
    public void division(){
        calc_setup("/");
        historyTextField.appendText(returnNumberAsString() + " ÷ ");
        CALC_MEMORY.push(getNumberDisplayedAsFloat());
        System.out.println("In stack : " + CALC_MEMORY.peek());
        clearDisplay();
    }
    public void invert(){

        int i  = -1;
        float k = getNumberDisplayedAsFloat();
        float result = k * i;
        clearDisplay();
        if(numberValidation(result)){
            int j = (int) result;
            printToScreen(j);
        }
        else{
            printToScreen(result);
        }




    }
    public void powerOf(){

        float i = getNumberDisplayedAsFloat();
        clearDisplay();
        float result = i*i;
        System.out.println(result);
        if(numberValidation(result)){
            int j = (int) result;
            printToScreen(j);
            System.out.println(j);

        }
        else {
            printToScreen(result);
        }
    }
    public void sqrt(){
        double k = Math.sqrt(Double.parseDouble(Display.getText()));
        clearDisplay();
        if(numberValidation(k)){
            int j = (int) k;
            printToScreen(j);
        }
        else{
            Display.appendText(Double.toString(k));
        }

    }
    public void percentage(){

        if (historyTextField.getText().isEmpty()){
            clearDisplay();
            printToScreen(0);
        }
        else{
            float i = getNumberDisplayedAsFloat();
            clearDisplay();
            float conversion = i/100 * CALC_MEMORY.peek();
            printToScreen(conversion);




        }


    }
    public void deleteLast(){

        int len = Display.getLength();
        char[] num = Display.getText().toCharArray();
        char[] newNumber = new char[len - 1];
        clearDisplay();

        for (int i = 0; i < newNumber.length; i++) {
            newNumber[i] = num[i];
            System.out.println(newNumber[i]);

        }

        String  s= Arrays.toString(newNumber);

        System.out.println(s);







    }


    public void calc_setup(String calculation){

        this.calculation  = calculation;
    } //SETS THE STRING FOR SWITCH CASE

    public void Equals_calculation(){

        TOP_OF_STACK = CALC_MEMORY.peek();

        switch (calculation){
            case "+" ->{
                result = TOP_OF_STACK + getNumberDisplayedAsFloat();
                appendFinalCalculation();

            }
            case "-" -> {
                result = TOP_OF_STACK - getNumberDisplayedAsFloat();
                appendFinalCalculation();
            }
            case "*" ->{
                result = TOP_OF_STACK * getNumberDisplayedAsFloat();
                appendFinalCalculation();

            }
            case "/" ->{
                result = TOP_OF_STACK / getNumberDisplayedAsFloat();
                appendFinalCalculation();
            }

        }



    }








}

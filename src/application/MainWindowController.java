package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

public class MainWindowController {
	@FXML
	private Button button1;
	@FXML
	private TextField input;
	@FXML
	private Label label1;
	@FXML
	private Label output;
	@FXML
	private RadioButton number;
	@FXML
	private ToggleGroup functionality;
	@FXML
	private RadioButton prime;
	@FXML
	private RadioButton factor;
	@FXML
	private RadioButton ArmStrongNumber;
	@FXML
	private RadioButton factorial;


	
	
	
	
	@FXML
	public void Factorials(String numbers) {
		int origi=Integer.parseInt(numbers);
		int result=1;
		for(int i=1; i<origi+1;i++) {
			result=result*i;
		}
		output.setText("Factorials: "+result);
	}
	
	
	
	//Find Armstrong numbers method
	 
	@FXML
	public void ArmStrong(String numbers) {
		String[] digits =(""+numbers).split("");
		int total=Integer.parseInt(numbers);
		int compare=0;
		for (int i=0;i<digits.length;i++) {
			int place=digits.length;
			compare+=Math.pow((double)Integer.parseInt(digits[i]),(double)place);
			
		}
		
		if (compare==total) {
			output.setText("Yes");
		}
		else {
			output.setText("No");
		}
	
		
	}
	
	/**
	 * The method that is called when button1 is clicked.
	 * 
	 * It has no inputs. It gets the current value of the textfield input.
	 * It has no returns. It sets the corresponding output to the corresponding label.
	 */
	// Event Listener on Button[#button1].onAction
	@FXML
	public void calculate() {
		ActionEvent blank = null;
		if(number.isSelected())
			printNumber(blank);
		else if(prime.isSelected())
			printPrime(blank);
		else if(factor.isSelected())
			printFactor(blank);
		else if(ArmStrongNumber.isSelected())
			ArmStrongNumber(blank);
		else if(factorial.isSelected())
			FactorialNumber(blank);
		else
			output.setText("Please select an option");
		
		
	}
	
	
	/**
	 * Find the factors of a number.
	 * 
	 * @param number The number whose factor is to be found
	 * @return		 Returns the factors of number in a string format. Each factor is separated by a "," except for the last one.
	 */
	public String getFactors(int number) {
		String answer = "";
		for(int i = 1; i < number; i++) 
			if(number % i == 0)
				answer += i + ", ";

		answer += number;
		return answer;	
	}
	
	
	/**
	 * Determine if a number is a Prime Number or not based on its factors.
	 * 
	 * @param facts Factors of number in a string format. Each factor is separated by a "," except for the last one.
	 * @return		True if number is a Prime. False if number is NOT a Prime Number.
	 */
	public boolean isPrime(String facts) {
		String[] factors = facts.split("\\s");
		if(factors.length == 2)
			return true;
		return false;
	}
	
	
	// Event Listener on RadioButton[#number].onAction
	@FXML
	public void printNumber(ActionEvent event) {
		try {
			int yourNumber = Integer.parseInt(input.getText());
			output.setText("Number: " +  yourNumber);
		}catch (NumberFormatException ex) {
		    output.setText("Invalid Input");
		}
	}
	
	
	// Event Listener on RadioButton[#prime].onAction
	@FXML
	public void printPrime(ActionEvent event) {
		try {
		    boolean prime = isPrime(getFactors(Integer.parseInt(input.getText())));
		    output.setText("Prime: "+ prime);
		}catch (NumberFormatException ex) {
		    output.setText("Invalid Input");
	}
	}
	
	
	// Event Listener on RadioButton[#factor].onAction
	@FXML
	public void printFactor(ActionEvent event) {
		try {
			String factors = getFactors(Integer.parseInt(input.getText()));
			System.out.print(event);
		    output.setText("Factors: " + factors);
		}catch (NumberFormatException ex) {
		    output.setText("Invalid Input");
		}
	}
	
	//Event Listener on RadioButton ArmStrongNumber
	@FXML
	public void ArmStrongNumber(ActionEvent e) {
		ArmStrong(input.getText());
	}
	
	@FXML
	public void FactorialNumber(ActionEvent e) {
		Factorials(input.getText());
	}
	
	
}

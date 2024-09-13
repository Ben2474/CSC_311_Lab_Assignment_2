package org.example.csc_311_lab_assignment_2;
// Import of JavaFx classes
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Loan Calculator class is extended to the application of JavaFX
public class LoanCalculator extends Application {
// Declaring TextFields
private TextField tfaInterestRate = new TextField(); // Annual Interest Rate
private TextField tfnOfYears = new TextField(); // Number of Years
private TextField la = new TextField(); // Loan Amount
private TextField tfmPayment = new TextField(); // Monthly Payment
private TextField tftPayment = new TextField(); // Total Payment
private Button btcPayment = new Button("Compute payment"); // Button to calculate payment

@Override
public void start(Stage stage) {
// Make a GridPane and configure its layout
GridPane gPane = new GridPane();
gPane.setAlignment(Pos.CENTER);
gPane.setPadding(new Insets(10.0,10.0,10.0,10.0));
gPane.setHgap(10.0);
gPane.setVgap(10.0);

// Adding labels and text fields to GridPane
gPane.add(new Label("Annual Interest Rate: "),0,0);
gPane.add(tfaInterestRate,1,0);
gPane.add(new Label("Number of Years: "),0,1);
gPane.add(tfnOfYears,1,1);
gPane.add(new Label("Loan Amount: "),0,2);
gPane.add(la,1,2);
gPane.add(new Label("Monthly Payment: "),0,3);
gPane.add(tfmPayment,1,3);
gPane.add(new Label("Total Payment: "),0,4);
gPane.add(tftPayment,1,4);
gPane.add(btcPayment,1,5);

// Setting the output text fields as non-editable
tfmPayment.setEditable(false);
tftPayment.setEditable(false);

// Aligning the text fields and the button to the bottom right of GridPane
tfaInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
tfnOfYears.setAlignment(Pos.BOTTOM_RIGHT);
la.setAlignment(Pos.BOTTOM_RIGHT);
tfmPayment.setAlignment(Pos.BOTTOM_RIGHT);
tftPayment.setAlignment(Pos.BOTTOM_RIGHT);
btcPayment.setAlignment(Pos.BOTTOM_RIGHT);

// Setting the action for the calculate button
btcPayment.setOnAction(e-> calculate());

// Make the scene, set the title, and show the stage
Scene sc = new Scene(gPane);
stage.setTitle("Loan Calculator");
stage.setScene(sc);
stage.show();
}

// Calculate method
private void calculate() {
// Analyzing the input value by parsing
double loanAmount = Double.parseDouble(la.getText());
double annualInterestRate = Double.parseDouble(tfaInterestRate.getText());
int numOfYears = Integer.parseInt(tfnOfYears.getText());

// The monthly interest rate and the number of payments are calculated
double monthlyInterestRate = annualInterestRate / 1200;
int numOfPayments = numOfYears * 12;

//The monthly and total payments are calculated
double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate,numOfPayments)) / (Math.pow(1+monthlyInterestRate,numOfPayments)-1);
double totalPayment = monthlyPayment * numOfPayments;

// This is the display of the results in currency
tfmPayment.setText(String.format("$%.2f",monthlyPayment));
tftPayment.setText(String.format("$%.2f",totalPayment));
}

// Main Method launches the application
public static void main(String[] args) {
        launch();
    }
}

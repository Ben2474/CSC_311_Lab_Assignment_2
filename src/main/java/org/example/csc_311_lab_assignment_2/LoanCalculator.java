package org.example.csc_311_lab_assignment_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoanCalculator extends Application {
private TextField la = new TextField();
    private TextField tfannInterestRate = new TextField();
    private TextField tfnumOfYears = new TextField();
    private TextField tfmonthlyPayment = new TextField();
    private TextField tftotalPayment = new TextField();
    private Button btcomputePayment = new Button("Compute payment");

    @Override
    public void start(Stage stage) {
GridPane gPane = new GridPane();
gPane.setAlignment(Pos.CENTER);
gPane.setPadding(new Insets(11.5,12.5,13.5,14.5));
gPane.setHgap(5.5);
gPane.setVgap(5.5);
gPane.add(new Label("Loan Amount: "),0,0);
gPane.add(la,1,0);
gPane.add(new Label("Annual Interest Rate: "),0,1);
gPane.add(tfannInterestRate,1,1);
gPane.add(new Label("Number of Years: "),0,2);
gPane.add(tfnumOfYears,1,2);
gPane.add(new Label("Monthly Payment: "),0,3);
gPane.add(tfmonthlyPayment,1,3);
gPane.add(new Label("Total Payment: "),0,4);
gPane.add(tftotalPayment,1,4);
gPane.add(btcomputePayment,1,5);
tfmonthlyPayment.setEditable(false);
tftotalPayment.setEditable(false);
la.setAlignment(Pos.BOTTOM_RIGHT);
tfannInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
tfnumOfYears.setAlignment(Pos.BOTTOM_RIGHT);
tfmonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
tftotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
btcomputePayment.setOnAction(e-> calculateLoanPayment());
Scene sc = new Scene(gPane);
stage.setTitle("Loan Calculator");
stage.setScene(sc);
stage.show();
    }

private void calculateLoanPayment() {
double loanAmount = Double.parseDouble(la.getText());
double annualInterestRate = Double.parseDouble(tfannInterestRate.getText());
int numOfYears = Integer.parseInt(tfnumOfYears.getText());
double monthlyInterestRate = annualInterestRate / 1200;
double monthlyPayment = loanAmount* monthlyInterestRate / (1-1 / Math.pow(1 + monthlyInterestRate,numOfYears*12));
double totalPayment = monthlyPayment * numOfYears * 12;
tfmonthlyPayment.setText(String.format("$%.2f",monthlyPayment));
tftotalPayment.setText(String.format("$%.2f",totalPayment));
    }
    public static void main(String[] args) {
        launch();
    }
}
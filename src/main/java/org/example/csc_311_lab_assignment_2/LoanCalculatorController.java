package org.example.csc_311_lab_assignment_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoanCalculatorController {

    @FXML
private TextField tfaInterestRate;

    @FXML
private TextField tfnOfYears;

    @FXML
private TextField la;

    @FXML
private TextField tfmPayment;

    @FXML
private TextField tftPayment;

    @FXML
private Button btcPayment;

    @FXML
void calculate(ActionEvent event) {
        double loanAmount = Double.parseDouble(la.getText());
        double annualInterestRate = Double.parseDouble(tfaInterestRate.getText());
        int numOfYears = Integer.parseInt(tfnOfYears.getText());
        double monthlyInterestRate = annualInterestRate / 1200;
        int numOfPayments = numOfYears * 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate,numOfPayments)) / (Math.pow(1+monthlyInterestRate,numOfPayments)-1);
        double totalPayment = monthlyPayment * numOfPayments;
        tfmPayment.setText(String.format("$%.2f",monthlyPayment));
        tftPayment.setText(String.format("$%.2f",totalPayment));
        btcPayment.setOnAction(this::calculate);

    }

}

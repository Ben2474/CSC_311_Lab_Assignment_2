module org.example.csc_311_lab_assignment_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc_311_lab_assignment_2 to javafx.fxml;
    exports org.example.csc_311_lab_assignment_2;
}
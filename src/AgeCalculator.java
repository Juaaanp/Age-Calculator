import java.time.LocalDate;
import java.time.Period;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;;;


public class AgeCalculator extends Application{

    @Override
    public void start(Stage stage1) {
        
        // Elements creation
        DatePicker dataPicker = new DatePicker();
        Button btnCalculate = new Button("Calculate age");
        Label lblAge = new Label("please, select your birthdate");
        Label lblWelcome = new Label("Hello, im going to calculate your age");
        
        // This method work for calculate user's age and have a conditional in case that user doesn't put his birthdate.
        btnCalculate.setOnAction(e -> {
            LocalDate birthDate = dataPicker.getValue();
            LocalDate dateNow = LocalDate.now();
            if (birthDate != null){
                Period age = Period.between(birthDate, dateNow);
                lblAge.setText("Age: " + age.getYears());
            }
            else {
                lblAge.setText("PLEASE, SELECT YOUR BIRTHDATE >:c");
            }
        });
        
        // Spaces between each element of window
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(50,50,50,50));
        layout.getChildren().addAll(lblWelcome,dataPicker,lblAge, btnCalculate);

        // Window size (width, height)
        Scene scene = new Scene(layout, 320, 300);

        stage1.setTitle("Age Calculator");
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

   
package sample;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import database.DBLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.CaloriesLogic;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;


//Der Controller ist für die Logik des Interface zuständig
public class Controller {

    CaloriesLogic caloriesLogic = new CaloriesLogic();

    ObservableList<String> activityList = FXCollections.observableArrayList("liegende oder sitzende Lebensweise", "wenig oder keine anstrengende Freizeitaktivität", "gehende oder stehende Tätigkeit", "überwiegend gehende und stehende Tätigkeit", "körperlich anstrengende Tätigkeit");


    ObservableList<String> palvalueList1 = FXCollections.observableArrayList("1.2");
    ObservableList<String> palvalueList2 = FXCollections.observableArrayList("1.4", "1.5");
    ObservableList<String> palvalueList3 = FXCollections.observableArrayList("1.6", "1.7");
    ObservableList<String> palvalueList4 = FXCollections.observableArrayList("1.8", "1.9");
    ObservableList<String> palvalueList5 = FXCollections.observableArrayList("2.0", "2.1", "2.2", "2.3", "2.4");

    ObservableList<String> mealList = FXCollections.observableArrayList("Frühstück", "Mittagessen", "Abendessen", "Snack");

    ObservableList<String> cardioList = FXCollections.observableArrayList("Crosstrainer", "Joggen", "Radfahren", "Schwimmen", "Stairmaster");

    ObservableList<String> trainingList = FXCollections.observableArrayList("Arme", "Beine", "Brust", "Rücken", "Schultern");


    //Views
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField age;
    @FXML
    private TextField size;
    @FXML
    private TextField weight;

    @FXML
    private DecimalNumberField carb_input;
    @FXML
    private DecimalNumberField fat_input;
    @FXML
    private DecimalNumberField protein_input;

    @FXML
    private ComboBox activity;
    @FXML
    private ComboBox palvalue;
    @FXML
    private ComboBox meals;
    @FXML
    private ComboBox cardio;
    @FXML
    private ComboBox training;

    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXCheckBox sportActivity;

    @FXML
    private Label bmi;
    @FXML
    private Label calories;
    @FXML
    private Label carbs;
    @FXML
    private Label fat;
    @FXML
    private Label protein;
    @FXML
    private Label calories_sum;

    @FXML
    private JFXDatePicker datepicker1;


    //greift auf die Main Methode zu um das Window in der Main Methode zu schließen
    public Main main;


    public void setMain(Main main) {
        this.main = main;
    }


    @FXML
    private void initialize() {

        activity.setValue("liegende oder sitzende Lebensweise");
        activity.setItems(activityList);

        palvalue.setValue("1.2");
        palvalue.setItems(palvalueList1);

        meals.setItems(mealList);

        cardio.setItems(cardioList);

        training.setItems(trainingList);

        datepicker1.setValue(LocalDate.now());
    }



    @FXML
    private void palValueChoice() {
        if (activity.getValue().equals("liegende oder sitzende Lebensweise")) {
            palvalue.setValue("1.2");
            palvalue.setItems(palvalueList1);
        }
        if (activity.getValue().equals("wenig oder keine anstrengende Freizeitaktivität")) {
            palvalue.setValue("1.4");
            palvalue.setItems(palvalueList2);
        }
        if (activity.getValue().equals("gehende oder stehende Tätigkeit")) {
            palvalue.setValue("1.6");
            palvalue.setItems(palvalueList3);
        }
        if (activity.getValue().equals("überwiegend gehende und stehende Tätigkeit")) {
            palvalue.setValue("1.8");
            palvalue.setItems(palvalueList4);
        }
        if (activity.getValue().equals("körperlich anstrengende Tätigkeit")) {
            palvalue.setValue("2.0");
            palvalue.setItems(palvalueList5);
        } else {
        }
    }


    // Button Controlle Speichern: Speichert die Daten in eine Datenbank
    @FXML
    private void save(){

        DBLogic db = new DBLogic();

        db.connection();
        db.dbInsert(firstname.getText(),lastname.getText(),Integer.parseInt(age.getText()),Integer.parseInt(size.getText()));

    }



    // Button Controller Berechnen: berechnet BMI, Kalorien, Fett, Kohlenhydrate Protein
    @FXML
    private void calculate() {

        caloriesLogic.setAge(Double.parseDouble(age.getText()));
        caloriesLogic.setSize(Double.parseDouble(size.getText()));
        caloriesLogic.setWeight(Double.parseDouble(weight.getText()));

        String i = palvalue.getSelectionModel().getSelectedItem().toString();

        caloriesLogic.setPalvalue(Double.parseDouble(i));


        if (male.isSelected()) {
            caloriesLogic.setGenderMale(true);
            caloriesLogic.setGenderFemale(false);
        }

        if (female.isSelected()) {
            caloriesLogic.setGenderMale(false);
            caloriesLogic.setGenderFemale(true);
        }


        if (sportActivity.isSelected()) {
            caloriesLogic.setSportpalvalue(true);
        } else {
            caloriesLogic.setSportpalvalue(false);
        }


        caloriesLogic.bmi();
        caloriesLogic.pal();
        caloriesLogic.nutrition();


        bmi.setText(String.valueOf(caloriesLogic.getBmi()));
        calories.setText(String.valueOf(caloriesLogic.getCalories()));
        carbs.setText(String.valueOf(caloriesLogic.getCarbs()));
        fat.setText(String.valueOf(caloriesLogic.getFat()));
        protein.setText(String.valueOf(caloriesLogic.getProtein()));
    }

    @FXML
    private void calculateCalories() {
        Double carb = Double.parseDouble(StringUtils.defaultIfEmpty(carb_input.getText(),"0"));
        Double fat = Double.parseDouble(StringUtils.defaultIfEmpty(fat_input.getText(), "0"));
        Double protein = Double.parseDouble(StringUtils.defaultIfEmpty(protein_input.getText(),"0"));

        calories_sum.setText(String.valueOf(carb*4.1 + fat*9.3 + protein*4.1));
    }
}

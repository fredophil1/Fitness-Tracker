package logic;

public class CaloriesLogic {

    String firstname;
    String lastname;

    boolean genderMale;
    boolean genderFemale;
    boolean sportpalvalue;

    private double weight;
    private double age;
    private double size;
    private double calories;

    private double palvalue;

    private double bmi;
    private double carbs;
    private double fat;
    private double protein;

    //berechnet den täglichen Kalorienbedarf für einen Mann im Ruhezustand
    public double male() {

        return ((10 * weight) + (6.25 * size) - (5 * age) + 5);

    }

    //berechnet den täglichen Kalorienbedarf für eine Frau im Ruhezustand
    public double female() {

        return ((10 * weight) + (6.25 * size) - (5 * age) - 161);

    }

    public boolean calcpalvalue() {


        return true;
    }

    //berechnet den täglichen Kalorienbedarf einer Person incl. Bewegung
    public double pal() {

        if (genderMale == true && sportpalvalue == true) {
            setCalories(male() * (palvalue + 0.3));
            return male() * palvalue;
        }

        if (genderFemale == true && sportpalvalue == true) {
            setCalories(female() * (palvalue + 0.3));
            return female() * palvalue;
        }

        if (genderMale == true) {
            setCalories(male() * palvalue);
            return male() * palvalue;
        }
        if (genderFemale == true) {
            setCalories(female() * palvalue);
            return female() * palvalue;
        } else {
            return 404;
        }

    }

    //berechnet die tägliche Kalorienverteilung von Fett, Kohlenhydraten & Protein auf Basis des täglichen Kalorienbedarf incl. Bewegung
    public boolean nutrition() {

        setFat(weight * 1);
        setProtein(weight * 2.5);

        setCarbs((calories - (weight * 1 * 9.3) - (weight * 2.5 * 4.1)) / 4.1);


        return true;

    }

    //berechnet den aktuelle BMI der Person
    public boolean bmi() {

        setBmi(weight / ((size / 100) * (size / 100)));

        return true;
    }

    //==============
    //Getter Methods
    //==============

    public double getWeight() {
        return weight;
    }

    public double getAge() {
        return age;
    }

    public double getSize() {
        return size;
    }

    public double getCalories() {
        calories = Math.round(calories * 100.0) / 100.0;
        return calories;
    }

    public double getPalvalue() {
        return palvalue;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getCarbs() {
        carbs = Math.round(carbs * 100.0) / 100.0;
        return carbs;
    }

    public double getFat() {
        fat = Math.round(fat * 100.0) / 100.0;
        return fat;
    }

    public double getProtein() {
        protein = Math.round(protein * 100.0) / 100.0;
        return protein;
    }

    public double getBmi() {
        bmi = Math.round(bmi * 100.0) / 100.0;
        return bmi;
    }

    public boolean isSportpalvalue() {
        return sportpalvalue;
    }

    public boolean isGenderMale() {
        return genderMale;
    }

    public boolean isGenderFemale() {
        return genderFemale;
    }

    //==============
    //Setter Methods
    //==============

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setPalvalue(double palvalue) {
        this.palvalue = palvalue;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGenderMale(boolean male) {
        this.genderMale = male;
    }

    public void setGenderFemale(boolean female) {
        this.genderFemale = female;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setSportpalvalue(boolean sportpalvalue) {
        this.sportpalvalue = sportpalvalue;
    }
}



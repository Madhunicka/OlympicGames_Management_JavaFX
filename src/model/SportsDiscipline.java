package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SportsDiscipline {
    private final StringProperty name;

    public SportsDiscipline(String name) {
        this.name = new SimpleStringProperty(name);
    }

    // Getter and setter for the name property
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    // Property accessor method
    public StringProperty nameProperty() {
        return name;
    }
}



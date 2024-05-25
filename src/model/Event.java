package model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class Event {
    private final SimpleStringProperty sport;
    private final SimpleStringProperty venue;
    private final SimpleObjectProperty<LocalDate> date;

    public Event(String sport, String venue, LocalDate date) {
        this.sport = new SimpleStringProperty(sport);
        this.venue = new SimpleStringProperty(venue);
        this.date = new SimpleObjectProperty<>(date);
    }

    // Getters and setters
    public String getSport() {
        return sport.get();
    }

    public void setSport(String sport) {
        this.sport.set(sport);
    }

    public SimpleStringProperty sportProperty() {
        return sport;
    }

    public String getVenue() {
        return venue.get();
    }

    public void setVenue(String venue) {
        this.venue.set(venue);
    }

    public SimpleStringProperty venueProperty() {
        return venue;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}

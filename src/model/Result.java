package model;

import javafx.beans.property.SimpleStringProperty;
import model.Event;
import model.Athlete;

public class Result {
    private Event event;
    private Athlete athlete;
    private String score;
    private String medal;

    public Result(Event event, Athlete athlete, String score, String medal) {
        this.event = event;
        this.athlete = athlete;
        this.score = score;
        this.medal = medal;
    }

    // Getters and setters
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    // Properties
    public SimpleStringProperty eventProperty() {
        return new SimpleStringProperty(event.getSport());
    }

    public SimpleStringProperty athleteProperty() {
        return new SimpleStringProperty(athlete.getName());
    }

    public SimpleStringProperty scoreProperty() {
        return new SimpleStringProperty(score);
    }

    public SimpleStringProperty medalProperty() {
        return new SimpleStringProperty(medal);
    }
}


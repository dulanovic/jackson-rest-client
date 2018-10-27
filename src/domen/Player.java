package domen;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Player {

    private String id;
    private String fullName;
    private int height;
    private int weight;
    private String position;
    private String jerseyNumber;
    private String college;
    private String birthPlace;

    public Player() {
    }

    public Player(String id, String fullName, int height, int weight, String position, String jerseyNumber, String college, String birthPlace) {
        this.id = id;
        this.fullName = fullName;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.college = college;
        this.birthPlace = birthPlace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    @JsonSetter("full_name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    @JsonSetter("jersey_number")
    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @JsonSetter("birth_place")
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "#" + jerseyNumber + " - " + fullName;
    }

}

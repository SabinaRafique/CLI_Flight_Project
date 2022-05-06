package passengers;

import flights.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Passenger {
    private String name;
    private String telNumber;
    private String passportNumber;
    private String passengerID;
    private Gender gender;
    private Nationality nationality;

    public Passenger(String name, String telNumber, String passportNumber, Gender gender, Nationality nationality) {
        this.name = name;
        this.telNumber = telNumber;
        this.passportNumber = passportNumber;
        this.passengerID = UUID.randomUUID().toString();
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passengerID='" + passengerID + '\'' +
                ", gender=" + gender +
                ", nationality=" + nationality +
                '}';
    }
}

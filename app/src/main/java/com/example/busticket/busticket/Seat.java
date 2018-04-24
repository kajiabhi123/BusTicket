package com.example.busticket.busticket;

/**
 * Created by compware on 1/28/2018.
 */

public class Seat {
    String  number;
    boolean isBooked ,isChecked;


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public boolean isBooked()
    {
        return isBooked;
    }

    public void setBooked(boolean booked)
    {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return number + " " + isBooked;
    }
}

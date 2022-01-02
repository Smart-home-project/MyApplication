package com.example.myapplication.Cleaning;

public class CleaningDevice {
    private String name;
    private int onOff,vacuumPower,capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOnOff() {
        return onOff;
    }

    public void setOnOff(int onOff) {
        this.onOff = onOff;
    }

    public int getVacuumPower() {
        return vacuumPower;
    }

    public void setVacuumPower(int vacuumPower) {
        this.vacuumPower = vacuumPower;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

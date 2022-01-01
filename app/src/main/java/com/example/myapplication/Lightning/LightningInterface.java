package com.example.myapplication.Lightning;

public interface LightningInterface {
    void printDevices();
    boolean addDevices(LightningDevice lw);
    void assignTask(LightningDevice lw);
    //Device Class created
    boolean isDeviceTurnedOn();
    void printTurnedOnDevices();
    void printTurnedOffDevices();

}

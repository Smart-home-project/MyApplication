package com.example.myapplication.Cleaning;

public interface CleaningInterface {
    void printDevices();
    boolean addDevices(CleaningDevice cd);
    void assignTask();
    //Device Class created
    boolean deviceAvailable();
    int deviceProcess();
}

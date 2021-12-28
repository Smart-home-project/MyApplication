package com.example.myapplication.Heating;

public interface HeatingInterface {
    void printDevices();
    boolean addDevices();
    void assignTask();
    //Device Class created
    boolean deviceAvailable();
    int roomTemprature();
    int getRoomTempOfRoom(int roomIndex);
    int setTempOfRoom(int roomIndex);

}

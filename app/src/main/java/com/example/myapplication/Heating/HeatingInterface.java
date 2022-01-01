package com.example.myapplication.Heating;

public interface HeatingInterface {
    void printDevices();
    boolean addDevices(HeatingMachine hm);
    void assignTask();
    //Device Class created
    boolean deviceAvailable();
    int roomTemprature();
    int getRoomTempOfRoom(int roomIndex);
    int setTempOfRoom(int roomIndex);

}

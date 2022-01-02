package com.example.myapplication.Heating;

public class HeatingMachine {
    private String name;
    private int onOff,capacity,temp,desiredTemp;

 //   public HeatingMachine(String name1, int onOff1, int capacity1,int temp1, int desiredTemp1){
 //       name=name1;
 //       onOff=onOff1;
 //       capacity=capacity1;
 //       temp=temp1;
 //       desiredTemp=desiredTemp1;
 //   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getDesiredTemp() {
        return desiredTemp;
    }

    public void setDesiredTemp(int desiredTemp) {
        this.desiredTemp = desiredTemp;
    }

    public int getOnOff() {
        return onOff;
    }

    public void setOnOff(int onOff) {
        this.onOff = onOff;
    }
}

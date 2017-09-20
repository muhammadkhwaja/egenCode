package com.egen.pwtsensor.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;



@Entity("sensordata")
public class SensorData {

    @Id
    private ObjectId id;

    String timeStamp;

    String value;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SensorData() {
    }

    public SensorData(String timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}


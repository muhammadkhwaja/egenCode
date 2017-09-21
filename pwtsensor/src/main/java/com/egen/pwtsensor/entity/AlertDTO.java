package com.egen.pwtsensor.entity;


import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Id;




public class AlertDTO {

    @Id
    private ObjectId id;

    Long timeStamp;

    String value;

    int baseWeight;

    public AlertDTO() {
    }

    public AlertDTO(ObjectId id, Long timeStamp, String value, int baseWeight) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.value = value;
        this.baseWeight = baseWeight;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(int baseWeight) {
        this.baseWeight = baseWeight;
    }
}


package com.egen.pwt.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Data
@Entity("alertsdata")
@NoArgsConstructor
@Getter @Setter
public class AlertsData {

    @Id
    private ObjectId id;


    Long timeStamp;
    int value;

    int baseWeight;
    String alert;


    public AlertsData() {
    }

    public AlertsData(ObjectId id, Long timeStamp, int value, int baseWeight, String alert) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.value = value;
        this.baseWeight = baseWeight;
        this.alert = alert;
    }

    public int getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(int baseWeight) {
        this.baseWeight = baseWeight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }




    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }


}

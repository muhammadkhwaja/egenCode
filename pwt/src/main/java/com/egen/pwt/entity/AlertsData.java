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



    String alert;

    public AlertsData() {
    }


    public AlertsData( ObjectId id,String alert) {
        this.id = id;

        this.alert = alert;
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

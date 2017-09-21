package com.egen.pwt.rules;

import com.egen.pwt.entity.AlertsData;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;


@Rule(name = "UnderWeightRule",
        description = "Check if person's weight is < 10% of base weight and marks the person as UnderWeight")
public class UnderWeightRule {

    private AlertsData alertsData;



    public UnderWeightRule(AlertsData alertsData){
        this.alertsData=alertsData;
    }

    @Condition
    public boolean isOverWeight(){
        return alertsData.getValue()<alertsData.getBaseWeight()-alertsData.getBaseWeight()*0.1;
    }

    @Action
    public void markAsOverWeight(){
        alertsData.setAlert("UnderWeight");
        System.out.println("marked as underwieght");
    }

}

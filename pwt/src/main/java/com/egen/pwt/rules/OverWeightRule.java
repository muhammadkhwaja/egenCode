package com.egen.pwt.rules;

import com.egen.pwt.entity.AlertsData;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;


@Rule(name = "OverWeightRule",
        description = "Check if person's weight is > 10% of base weight and marks the person as OverWeight")
public class OverWeightRule {

    private AlertsData alertsData;



    public OverWeightRule(AlertsData alertsData){
            this.alertsData=alertsData;
    }

    @Condition
    public boolean isOverWeight(){
        return alertsData.getValue()>alertsData.getBaseWeight()+alertsData.getBaseWeight()*0.1;
    }

    @Action
    public void markAsOverWeight(){
        alertsData.setAlert("OverWeight");
        System.out.println("marked as overwieght");
    }

}

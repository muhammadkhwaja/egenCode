package com.egen.pwt.controller;


import com.egen.pwt.entity.AlertsData;
import com.egen.pwt.entity.SensorData;
import com.egen.pwt.repository.AlertsDataRepo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alerts")
public class AlertsDataController {

    @Autowired
    private AlertsDataRepo alertsDataRepo;

    @Autowired
    private Datastore datastore;



    @RequestMapping(method = RequestMethod.GET, value="/read")
    public List<AlertsData> getAllData(){


        Query<AlertsData> query = datastore.createQuery(AlertsData.class);

        List<AlertsData> list = query.asList();

        return list;
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/create")
    public Map<String, Object> insertData(@RequestBody SensorData sensorData){
        String alert;
        int baseWeight=90;
        if(Integer.parseInt(sensorData.getValue())>baseWeight+baseWeight*0.01)
        {
            alert="Overweight";
            AlertsData alertsData = new AlertsData();
            alertsData.setAlert(alert);
            datastore.save(alertsData);
            Map<String, Object> response = new LinkedHashMap<String, Object>();
            response.put("message", "Oveerweight");
            response.put("data", alertsDataRepo.save(alertsData));
            return response;

        }
        else if(Integer.parseInt(sensorData.getValue())>baseWeight+baseWeight*0.01){ alert="below weight";
            AlertsData alertsData = new AlertsData();
            alertsData.setAlert(alert);
            datastore.save(alertsData);
            Map<String, Object> response = new LinkedHashMap<String, Object>();
            response.put("message", "Below weight");
            response.put("data", alertsDataRepo.save(alertsData));
            return response;}
        else{alert="NULL";}
         Map<String, Object> response = new LinkedHashMap<String, Object>();

        return response;
    }
}

package com.egen.pwt.controller;


import com.egen.pwt.entity.AlertsData;
import com.egen.pwt.repository.AlertsDataRepo;
import com.egen.pwt.rules.OverWeightRule;

import com.egen.pwt.rules.UnderWeightRule;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    public Map<String, Object> insertData(@RequestBody AlertsData alertsData){
        String alert;
        int baseWeightData=alertsData.getBaseWeight();
        System.out.println("baseweight "+alertsData.getBaseWeight());
        System.out.println("baseweight "+alertsData.getValue());
        long alertTime=(new Timestamp(System.currentTimeMillis()).getTime())/1000;
        alertsData.setTimeStamp(alertTime);
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
        OverWeightRule overWeightRule=new OverWeightRule(alertsData);
        UnderWeightRule underWeightRule = new UnderWeightRule(alertsData);
        rulesEngine.registerRule(overWeightRule);
        rulesEngine.registerRule(underWeightRule);
        rulesEngine.fireRules();
        System.out.println("Here rules output"+alertsData.getAlert());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        datastore.save(alertsData);
        response.put("message", alertsData.getAlert());
        response.put("data", alertsDataRepo.save(alertsData));
        return response;
    }

    //localhost:9000/alerts/readbytimerange?start=1505971233&end=1505972448
    @RequestMapping(method = RequestMethod.GET,value="/readbytimerange")
    public List<AlertsData> readByTimeRange(@RequestParam String start, @RequestParam String end){
        long startDate = Long.parseLong(start);
        long endDate = Long.parseLong(end);
        Query<AlertsData> query1 = datastore.find(AlertsData.class);
        query1.criteria("timeStamp").greaterThanOrEq(startDate).add(query1.criteria("timeStamp").lessThan(endDate));

        List<AlertsData> list = query1.asList();


        return list;
    }
}

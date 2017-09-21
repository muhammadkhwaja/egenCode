package com.egen.pwtsensor.controller;

import com.egen.pwtsensor.entity.AlertDTO;
import com.egen.pwtsensor.entity.SensorData;
import com.egen.pwtsensor.repository.SensorDataRepository;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.wordnik.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.joda.time.format.ISODateTimeFormat;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping("/")
public class SensorDataController {

    final static Logger logger = Logger.getLogger(SensorDataController.class);
     int  count=1;
     int baseWeight;

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private Datastore datastore;



    @RequestMapping(method = RequestMethod.GET, value="read")
    public List<SensorData> getAllData(){

        Query<SensorData> query = datastore.createQuery(SensorData.class);
        List<SensorData> list = query.asList();
        return list;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> insertData(@RequestBody Map<String, Object> sensorMap){
        AlertDTO alertDTO=new AlertDTO();
        alertDTO.setValue(sensorMap.get("value").toString());
        if(count==1)
            baseWeight=Integer.parseInt(sensorMap.get("value").toString());
            alertDTO.setBaseWeight(baseWeight);
        count++;
        System.out.println("Base weight is "+baseWeight);
        SensorData sensorData = new SensorData(new Long(sensorMap.get("timeStamp").toString()),sensorMap.get("value").toString());

        System.out.println("Here data from emulator is "+sensorMap.toString());


      /*  Iterator<SensorData> aggregate= datastore.createAggregation(SensorData.class).group(Arrays.asList(Group.grouping("$hour", "timestamp")), Group.grouping("count", new Accumulator("$sum", 1)))
                .aggregate(SensorData.class);
*/

        datastore.save(sensorData);
        try{
        Gson gson = new Gson();
        String json = gson.toJson(alertDTO);
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url="http://localhost:9000/alerts/create";
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        restTemplate.put(url, entity);}
        catch (Exception e){
            System.out.println("Error here"+e);
        }
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Data collected successfully");
        response.put("data", sensorDataRepository.save(sensorData));
        System.out.println("Save data");
        return response;
    }

    //localhost:8080/sensordata/readbytimerange?start=1505971233&end=1505972448
    @RequestMapping(method = RequestMethod.GET,value="/readbytimerange")
    public List<SensorData> readByTimeRange(@RequestParam String start, @RequestParam String end){
        long startDate = Long.parseLong(start);
        long endDate = Long.parseLong(end);
        Query<SensorData> query1 = datastore.find(SensorData.class);
        query1.criteria("timeStamp").greaterThanOrEq(startDate).add(query1.criteria("timeStamp").lessThan(endDate));
        logger.info("getting query data");
        List<SensorData> list = query1.asList();


        return list;
    }
}
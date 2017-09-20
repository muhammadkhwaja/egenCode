package com.egen.pwtsensor.controller;

import com.egen.pwtsensor.entity.SensorData;
import com.egen.pwtsensor.repository.SensorDataRepository;
import com.google.gson.Gson;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sensordata")
public class SensorDataController {

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


    @RequestMapping(method = RequestMethod.POST,value="create")
    public Map<String, Object> insertData(@RequestBody Map<String, Object> sensorMap){

        SensorData sensorData = new SensorData(sensorMap.get("timeStamp").toString(),sensorMap.get("value").toString());
        datastore.save(sensorData);
        Gson gson = new Gson();
        String json = gson.toJson(sensorMap);
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url="http://localhost:9000/alerts/create";
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        restTemplate.put(url, entity);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Data collected successfully");
        response.put("data", sensorDataRepository.save(sensorData));
        return response;
    }


}
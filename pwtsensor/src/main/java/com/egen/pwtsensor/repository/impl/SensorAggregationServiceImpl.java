package com.egen.pwtsensor.repository.impl;


import com.egen.pwtsensor.repository.SensorAggregationService;
import com.egen.pwtsensor.repository.SensorDataRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import static jdk.nashorn.internal.objects.NativeArray.sort;
import static org.mongodb.morphia.utils.IndexType.ASC;

public class SensorAggregationServiceImpl implements SensorAggregationService{


    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Override
    @Scheduled(cron = "0 0-59 * * * *")
    public void performAggregationPerMinute() {
        DateTime now = new DateTime();


    }

    @Override
    @Scheduled(cron = "0 0 * * * *")
    public void performAggregationPerHour() {
        DateTime now = new DateTime();

    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void performAggregationPerDay(){
        DateTime now = new DateTime();

    }


    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void performAggregationPerMonth() {
        DateTime now = new DateTime();
        // start of month
        DateTime startDate = new DateTime(now.getYear(), now.getMonthOfYear(), 1, 0, 0);
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void performAggregationPerYear() {
        DateTime now = new DateTime();
        // start of year
        DateTime startDate = new DateTime(now.getYear(), 1, 1, 0, 0);
    }
}

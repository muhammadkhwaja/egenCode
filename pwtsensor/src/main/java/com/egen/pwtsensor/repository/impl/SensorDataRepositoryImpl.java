package com.egen.pwtsensor.repository.impl;

import com.egen.pwtsensor.entity.SensorData;
import com.egen.pwtsensor.repository.SensorDataRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class SensorDataRepositoryImpl implements SensorDataRepository {

    @Autowired
    private Datastore datastore;

    @Override
    public Iterable<Key<SensorData>> save(SensorData... sensorData) {
        return datastore.save(sensorData);
    }

    @Override
    public Key<SensorData> save(SensorData sensorData) {
        return datastore.save(sensorData);
    }

    @Override
    public void aggregatePerMinute(SensorData sensorData, Date startDate, Date endDate) {


    }
}

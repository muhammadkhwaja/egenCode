package com.egen.pwtsensor.repository;

import com.egen.pwtsensor.entity.SensorData;
import org.mongodb.morphia.Key;

import java.util.Date;

public interface SensorDataRepository {

    Iterable<Key<SensorData>> save(SensorData... sensorData);

    Key<SensorData> save(SensorData sensorData);

    public void aggregatePerMinute(SensorData sensorData, Date startDate, Date endDate);

}

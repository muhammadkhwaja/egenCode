package com.egen.pwtsensor.repository;

import com.egen.pwtsensor.PwtsensorApplicationTests;
import com.egen.pwtsensor.entity.SensorData;
import org.junit.Test;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class SensorDataRepositoryTest extends PwtsensorApplicationTests{

    @Autowired
    private SensorDataRepository sensorDataRepository;


    @Test
    public void testSave() {


        SensorData value1 = new SensorData("1436465637","23");

        Key<SensorData> sensor232 = sensorDataRepository.save(value1);
        assertNotNull(value1);

    }
}

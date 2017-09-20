package com.egen.pwt.repository;

import com.egen.pwt.PwtAlertsApplicationTests;
import com.egen.pwt.entity.AlertsData;
import org.junit.Test;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class AlertsDataRepoTest extends PwtAlertsApplicationTests {
    @Autowired
    private AlertsDataRepo alertsDataRepo;


    @Test
    public void testSave() {


        AlertsData value1 = new AlertsData();
        value1.setAlert("low weight");
        Key<AlertsData> sensor232 = alertsDataRepo.save(value1);
        assertNotNull(value1);

    }

}

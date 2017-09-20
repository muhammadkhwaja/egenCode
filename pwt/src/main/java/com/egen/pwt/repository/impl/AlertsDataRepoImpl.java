package com.egen.pwt.repository.impl;

import com.egen.pwt.entity.AlertsData;
import com.egen.pwt.repository.AlertsDataRepo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AlertsDataRepoImpl implements AlertsDataRepo {

    @Autowired
    private Datastore datastore;

    @Override
    public Iterable<Key<AlertsData>> save(AlertsData... alertsData) {
        return datastore.save(alertsData);
    }

    @Override
    public Key<AlertsData> save(AlertsData alertsData) {
        return datastore.save(alertsData);
    }


}

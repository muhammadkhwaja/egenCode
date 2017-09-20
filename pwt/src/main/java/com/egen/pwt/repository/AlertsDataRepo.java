package com.egen.pwt.repository;

import com.egen.pwt.entity.AlertsData;
import org.mongodb.morphia.Key;

public interface AlertsDataRepo {

    Iterable<Key<AlertsData>> save(AlertsData... alertsData);

    Key<AlertsData> save(AlertsData alertsData);
}

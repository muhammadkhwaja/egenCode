package com.egen.pwtsensor.repository;

public interface SensorAggregationService {

    void performAggregationPerMinute();


    void performAggregationPerHour();

    void performAggregationPerDay();

    void performAggregationPerMonth();

    void performAggregationPerYear();


}

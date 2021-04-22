package com.oracletest.main.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Client Report Response Domain
 * */
public class ClientReport {
    private String client;
    private HashMap<String, Long> uniqueCustomersByContractCount;
    private HashMap<String, Long> uniqueCustomersByGeoZoneCount;
    private HashMap<String, List<String>> uniqueCustomersListByGeoZone;
    private HashMap<String, String> averageDurationPerGeoZone;

    public ClientReport(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public HashMap<String, Long> getUniqueCustomersByContractCount() {
        return uniqueCustomersByContractCount;
    }

    public void setUniqueCustomersByContractCount(HashMap<String, Long> uniqueCustomersByContractCount) {
        this.uniqueCustomersByContractCount = uniqueCustomersByContractCount;
    }

    public HashMap<String, Long> getUniqueCustomersByGeoZoneCount() {
        return uniqueCustomersByGeoZoneCount;
    }

    public void setUniqueCustomersByGeoZoneCount(HashMap<String, Long> uniqueCustomersByGeoZoneCount) {
        this.uniqueCustomersByGeoZoneCount = uniqueCustomersByGeoZoneCount;
    }

    public HashMap<String, List<String>> getUniqueCustomersListByGeoZone() {
        return uniqueCustomersListByGeoZone;
    }

    public void setUniqueCustomersListByGeoZone(HashMap<String, List<String>> uniqueCustomersListByGeoZone) {
        this.uniqueCustomersListByGeoZone = uniqueCustomersListByGeoZone;
    }

    public HashMap<String, String> getAverageDurationPerGeoZone() {
        return averageDurationPerGeoZone;
    }

    public void setAverageDurationPerGeoZone(HashMap<String, String> averageDurationPerGeoZone) {
        this.averageDurationPerGeoZone = averageDurationPerGeoZone;
    }

    @Override
    public String toString() {
        return "ClientReport{" +
                "client='" + client + '\'' +
                ", uniqueCustomersByContractCount=" + uniqueCustomersByContractCount +
                ", uniqueCustomersByGeoZoneCount=" + uniqueCustomersByGeoZoneCount +
                ", uniqueCustomersListByGeoZone=" + uniqueCustomersListByGeoZone +
                ", averageDurationPerGeoZone=" + averageDurationPerGeoZone +
                '}';
    }
}

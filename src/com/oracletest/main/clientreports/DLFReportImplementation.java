package com.oracletest.main.clientreports;

import com.oracletest.main.ProjectDataFilter;
import com.oracletest.main.domain.ClientReport;
import com.oracletest.main.domain.ProjectData;
import com.oracletest.main.factory.Report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DLFReportImplementation implements Report {
    private final List<ProjectData> projectDataList;
    ClientReport dlfReport = new ClientReport("DLF");

    public DLFReportImplementation(List<ProjectData> projectDataList) {
        this.projectDataList = projectDataList;
    }

    @Override
    public ClientReport generateReport() {
        uniqueCustomersByContractIdCount();
        uniqueCustomersByGeoZoneCount();
        uniqueCustomersByGeoZoneList();
        averageBuildDurationPerGeoZone();
        return dlfReport;
    }

    public void uniqueCustomersByContractIdCount() {
        Map<String, List<ProjectData>> dataGroupByContractId = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getContractId, Collectors.toList()));
        this.dlfReport.setUniqueCustomersByContractCount(getStringLongHashMap(dataGroupByContractId));
    }

    public void uniqueCustomersByGeoZoneCount() {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        this.dlfReport.setUniqueCustomersByGeoZoneCount(getStringLongHashMap(dataGroupByGeoZone));
    }

    public void uniqueCustomersByGeoZoneList() {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        HashMap<String, List<String>> uniqueCustomersByGeoZoneMap = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByGeoZone.entrySet()) {
            List<String> list = data.getValue().stream().filter(ProjectDataFilter.distinctByProperty(ProjectData::getCustomerId))
                    .map(ProjectData::getCustomerId)
                    .collect(Collectors.toList());
            uniqueCustomersByGeoZoneMap.put(data.getKey(), list);
        }
        this.dlfReport.setUniqueCustomersListByGeoZone(uniqueCustomersByGeoZoneMap);
    }

    /**
     * Method to calculate average build duration for each Geo-Zone
     */

    public void averageBuildDurationPerGeoZone() {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        HashMap<String, String> durationByZoneMap = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByGeoZone.entrySet()) {
            double averageDuration = data.getValue().stream()
                    .mapToLong(ProjectData::getBuildDuration).average().orElse(Double.NaN);
            durationByZoneMap.put(data.getKey(), averageDuration + "s");
        }
        this.dlfReport.setAverageDurationPerGeoZone(durationByZoneMap);
    }


    private static HashMap<String, Long> getStringLongHashMap(Map<String, List<ProjectData>> dataGroupByProperty) {
        HashMap<String, Long> uniqueCustomersByProperty = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByProperty.entrySet()) {
            Long count = data.getValue().stream().filter(ProjectDataFilter.distinctByProperty(ProjectData::getCustomerId)).count();
            uniqueCustomersByProperty.put(data.getKey(), count);
        }
        return uniqueCustomersByProperty;
    }
}

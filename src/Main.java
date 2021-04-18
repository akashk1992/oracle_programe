import domain.ProjectData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String projectDataString = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectApple,5678s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

        List<ProjectData> projectDataList = extractProjectData(projectDataString);

        uniqueCustomersByContractIdCount(projectDataList);
        uniqueCustomersByGeoZoneCount(projectDataList);
        uniqueCustomersByGeoZoneList(projectDataList);
        averageBuildDurationPerGeoZone(projectDataList);
    }


    /**
     * Building data in list of objects of better manipulation
     * */
    private static List<ProjectData> extractProjectData(String projectDataString) {
        String[] rows = projectDataString.split("\n");

        return Arrays.stream(rows)
                .map(row -> row.split(","))
                .map(rowElement -> new ProjectData(
                        rowElement[0],
                        rowElement[1],
                        rowElement[2],
                        rowElement[3],
                        rowElement[4],
                        Long.parseLong(rowElement[5].replace("s", ""))
                )).collect(Collectors.toList());
    }

    private static void uniqueCustomersByContractIdCount(List<ProjectData> projectDataList) {
        Map<String, List<ProjectData>> dataGroupByContractId = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getContractId, Collectors.toList()));

        HashMap<String, Long> uniqueCustomersByContractId = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByContractId.entrySet()) {
            Long count = data.getValue().stream().filter(ProjectDataFilter.distinctByProperty(ProjectData::getCustomerId)).count();
            uniqueCustomersByContractId.put(data.getKey(), count);
        }
        System.out.println("The number of unique customerId for each contractId.");
        System.out.println(uniqueCustomersByContractId);
        System.out.println("-----------------------------------------------------");
    }

    private static void uniqueCustomersByGeoZoneCount(List<ProjectData> projectDataList) {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        HashMap<String, Long> uniqueCustomersByGeoZoneMap = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByGeoZone.entrySet()) {
            Long count = data.getValue().stream().filter(ProjectDataFilter.distinctByProperty(ProjectData::getCustomerId)).count();
            uniqueCustomersByGeoZoneMap.put(data.getKey(), count);
        }
        System.out.println("The number of unique customerId for each geozone");
        System.out.println(uniqueCustomersByGeoZoneMap);
        System.out.println("-----------------------------------------------");
    }


    /**
     * Method to filter unique customer id's list by each Geo-Zone
     */
    private static void uniqueCustomersByGeoZoneList(List<ProjectData> projectDataList) {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        HashMap<String, List<String>> uniqueCustomersByGeoZoneMap = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByGeoZone.entrySet()) {
            List<String> list = data.getValue().stream().filter(ProjectDataFilter.distinctByProperty(ProjectData::getCustomerId))
                    .map(ProjectData::getCustomerId)
                    .collect(Collectors.toList());
            uniqueCustomersByGeoZoneMap.put(data.getKey(), list);
        }
        System.out.println("The list of unique customerId for each geozone");
        System.out.println(uniqueCustomersByGeoZoneMap);
        System.out.println("------------------------------------------------");
    }

    /**
     * Method to calculate average build duration for each Geo-Zone
     */

    private static void averageBuildDurationPerGeoZone(List<ProjectData> projectDataList) {
        Map<String, List<ProjectData>> dataGroupByGeoZone = projectDataList.stream()
                .collect(Collectors.groupingBy(ProjectData::getGeoZone, Collectors.toList()));

        HashMap<String, String> uniqueCustomersByGeoZoneMap = new HashMap<>();
        for (Map.Entry<String, List<ProjectData>> data : dataGroupByGeoZone.entrySet()) {
            double averageDuration = data.getValue().stream()
                    .mapToLong(ProjectData::getBuildDuration).average().orElse(Double.NaN);
            uniqueCustomersByGeoZoneMap.put(data.getKey(), averageDuration + "s");
        }
        System.out.println("The Average build duration for each geozone");
        System.out.println(uniqueCustomersByGeoZoneMap);
    }
}

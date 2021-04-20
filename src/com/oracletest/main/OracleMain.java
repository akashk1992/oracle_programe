package com.oracletest.main;

import com.oracletest.main.domain.ProjectData;
import com.oracletest.main.factory.ReportGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OracleMain {
    public static void main(String[] args) {
        String projectDataString = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectApple,5678s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

        List<ProjectData> projectDataList = extractProjectData(projectDataString);

        ReportGenerator reportGenerator = new ReportGenerator();

        reportGenerator.getReport(Client.DLF, projectDataList);

        reportGenerator.getReport(Client.RELINFRA, projectDataList);
    }


    /**
     * Building data in list of objects of better manipulation
     */
    public static List<ProjectData> extractProjectData(String projectDataString) {

        String[] rows = projectDataString.split("\n");

        return Arrays.stream(rows)
                .map(row -> row.split(","))
                .map(rowElement -> new ProjectData.ProjectDataBuilder()
                        .setCustomerId(rowElement[0])
                        .setContractId(rowElement[1])
                        .setGeoZone(rowElement[2])
                        .setTeamCode(rowElement[3])
                        .setProjectCode(rowElement[4])
                        .setBuildDuration(Long.parseLong(rowElement[5].replace("s", "")))
                        .build())
                .collect(Collectors.toList());
    }
}

package com.oracletest.test;

import com.oracletest.main.clientreports.DLFReportImplementation;
import com.oracletest.main.OracleMain;
import com.oracletest.main.domain.ClientReport;
import com.oracletest.main.domain.ProjectData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    private List<ProjectData> projectDatsList;

    @BeforeEach
    public void setup() {
        String projectDataString = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectApple,5678s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

        projectDatsList = OracleMain.extractProjectData(projectDataString);

    }

    /**
     * To test specific unit of work
     * */
//    @Test
//    public void testUniqueCustomersByContractIdCount() {
//        HashMap<String, Long> resultMap = OracleMain.uniqueCustomersByContractIdCount(projectDatsList);
//        Assertions.assertEquals(3, resultMap.get("2345"));
//    }
//
//    @Test
//    public void testUniqueCustomersByGeoZoneCount() {
//        HashMap<String, Long> resultMap = OracleMain.uniqueCustomersByGeoZoneCount(projectDatsList);
//        Assertions.assertEquals(2, resultMap.get("us_west"));
//    }
//
//    @Test
//    public void testAverageBuildDurationPerGeoZone() {
//        HashMap<String, String> resultMap = OracleMain.averageBuildDurationPerGeoZone(projectDatsList);
//        Assertions.assertEquals("3445.0s", resultMap.get("us_east"));
//    }

    @Test
    public void generateDLFReport() {
        DLFReportImplementation reportImplementation = new DLFReportImplementation(projectDatsList);
        ClientReport result = reportImplementation.generateReport();
//        System.out.println(result);
        Assertions.assertEquals("DLF", result.getClient());
        Assertions.assertEquals(3, result.getUniqueCustomersByContractCount().get("2345"));
        Assertions.assertEquals(2, result.getUniqueCustomersByGeoZoneCount().get("us_west"));
        Assertions.assertEquals("3445.0s", result.getAverageDurationPerGeoZone().get("us_east"));
    }

    /**
     * Test case to test report generation for different client
     * */
//    @Test
//    public void generateRelInfraReport() {
//        RELINFRAReportImplementation reportImplementation = new RELINFRAReportImplementation(projectDatsList);
//        ClientReport result = reportImplementation.generateReport();
//    }


}

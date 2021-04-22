package com.oracletest.main.clientreports;

import com.oracletest.main.domain.ClientReport;
import com.oracletest.main.domain.ProjectData;
import com.oracletest.main.factory.Report;

import java.util.List;

/**
 * Client 2 specific requirements
 */

/**
 * This client may require to find unique customers by Team Code or Project Code OR
 * say, average duration per team or project ..
 * so we can write this client specific implementation here
 */
public class RELINFRAReportImplementation implements Report {
    private final List<ProjectData> projectDataList;
    ClientReport relInfraReport = new ClientReport("RELINFRA");

    public RELINFRAReportImplementation(List<ProjectData> projectDataList) {
        this.projectDataList = projectDataList;
    }

    @Override
    public ClientReport generateReport() {

        /**
         * Code to get client data and generate data
         * */
        return relInfraReport;
    }
}

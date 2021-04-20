package com.oracletest.main.factory;

import com.oracletest.main.Client;
import com.oracletest.main.clientreports.DLFReportImplementation;
import com.oracletest.main.clientreports.RELINFRAReportImplementation;
import com.oracletest.main.domain.ProjectData;

import java.util.List;

public class ReportGenerator {

    public Report getReport(Client client, List<ProjectData> projectDataList) {
        switch (client) {
            case DLF:
                return new DLFReportImplementation(projectDataList);
            case RELINFRA:
                return new RELINFRAReportImplementation(projectDataList);
        }
        return null;
    }
}

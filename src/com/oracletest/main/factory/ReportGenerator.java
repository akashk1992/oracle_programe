package com.oracletest.main.factory;

import com.oracletest.main.Client;
import com.oracletest.main.clientreports.DLFReportImplementation;
import com.oracletest.main.clientreports.RELINFRAReportImplementation;
import com.oracletest.main.domain.ProjectData;

import java.util.List;


/**
 * Factory class to delegate the
 * object creational process depending upon the client
 */
public class ReportGenerator {

    public Report getReport(Client client, List<ProjectData> projectDataList) {
        switch (client) {
            case DLF:
                /**
                 * Client 1 specifc requirements to generate report
                 * */
                return new DLFReportImplementation(projectDataList);
            case RELINFRA:
                /**
                 * Client 1 specifc requirements to generate report
                 * */
                return new RELINFRAReportImplementation(projectDataList);
        }
        return null;
    }
}

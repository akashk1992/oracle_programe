package com.oracletest.main.builder;

import com.oracletest.main.domain.ProjectData;

public class ProjectDataBuilder {
    private String customerId;
    private String contractId;
    private String geoZone;
    private String teamCode;
    private String projectCode;
    private Long buildDuration;

    public ProjectDataBuilder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public ProjectDataBuilder setContractId(String contractId) {
        this.contractId = contractId;
        return this;
    }

    public ProjectDataBuilder setGeoZone(String geoZone) {
        this.geoZone = geoZone;
        return this;
    }

    public ProjectDataBuilder setTeamCode(String teamCode) {
        this.teamCode = teamCode;
        return this;
    }

    public ProjectDataBuilder setProjectCode(String projectCode) {
        this.projectCode = projectCode;
        return this;
    }

    public ProjectDataBuilder setBuildDuration(Long buildDuration) {
        this.buildDuration = buildDuration;
        return this;
    }

    public ProjectData build() {
        return new ProjectData(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}

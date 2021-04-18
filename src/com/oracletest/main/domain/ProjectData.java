package com.oracletest.main.domain;

public class ProjectData {
    private String customerId;
    private String contractId;
    private String geoZone;
    private String teamCode;
    private String projectCode;
    private Long buildDuration;

    public ProjectData() {
    }

    public ProjectData(String customerId, String contractId, String geoZone, String teamCode, String projectCode, Long buildDuration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geoZone = geoZone;
        this.teamCode = teamCode;
        this.projectCode = projectCode;
        this.buildDuration = buildDuration;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGeoZone() {
        return geoZone;
    }

    public void setGeoZone(String geoZone) {
        this.geoZone = geoZone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Long getBuildDuration() {
        return buildDuration;
    }

    public void setBuildDuration(Long buildDuration) {
        this.buildDuration = buildDuration;
    }

    @Override
    public String toString() {
        return "ProjectData{" +
                "customerId=" + customerId +
                ", contractId=" + contractId +
                ", geozone='" + geoZone + '\'' +
                ", teamCode='" + teamCode + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", buildDuration=" + buildDuration +
                '}';
    }
}

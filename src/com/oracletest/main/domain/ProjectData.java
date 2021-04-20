package com.oracletest.main.domain;

public class ProjectData {
    private final ProjectDataBuilder projectDataBuilder;

    public ProjectData(ProjectDataBuilder projectDataBuilder) {
        this.projectDataBuilder = projectDataBuilder;
    }

    public String getCustomerId() {
        return this.projectDataBuilder.customerId;
    }

    public String getContractId() {
        return this.projectDataBuilder.contractId;
    }

    public String getGeoZone() {
        return this.projectDataBuilder.geoZone;
    }

    public String getTeamCode() {
        return this.projectDataBuilder.teamCode;
    }

    public String getProjectCode() {
        return this.projectDataBuilder.projectCode;
    }

    public Long getBuildDuration() {
        return this.projectDataBuilder.buildDuration;
    }

    public static class ProjectDataBuilder {
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
            return new ProjectData(this);
        }

        @Override
        public String toString() {
            return "ProjectDataBuilder{" +
                    "customerId='" + customerId + '\'' +
                    ", contractId='" + contractId + '\'' +
                    ", geoZone='" + geoZone + '\'' +
                    ", teamCode='" + teamCode + '\'' +
                    ", projectCode='" + projectCode + '\'' +
                    ", buildDuration=" + buildDuration +
                    '}';
        }
    }
}

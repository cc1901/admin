package robort.domain;

public enum RobotsHealthy {
    WORKING("正常工作"), DOWN("机器人故障");

    private String statusDescription;

    private RobotsHealthy(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String description() {
        return statusDescription;
    }
}

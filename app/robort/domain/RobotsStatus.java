package robort.domain;

public class RobotsStatus {

    private RobotsHealthy robotsHealthy;

    public RobotsStatus(RobotsHealthy robotsHealthy) {
        this.robotsHealthy = robotsHealthy;
    }

    public RobotsHealthy getRobotsHealthy() {
        return robotsHealthy;
    }
}

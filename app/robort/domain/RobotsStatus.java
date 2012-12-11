package robort.domain;

import java.util.ArrayList;
import java.util.List;

public class RobotsStatus {
    private RobotsHealthy robotsHealthy;
    private RobotsKnowledge robotsKnowledge;

    public RobotsStatus(RobotsHealthy robotsHealthy) {
        this.robotsHealthy = robotsHealthy;
        this.robotsKnowledge = new RobotsKnowledge(new ArrayList<String>());
    }

    public RobotsStatus(RobotsHealthy robotsHealthy, RobotsKnowledge robotsKnowledge) {
        this.robotsHealthy = robotsHealthy;
        this.robotsKnowledge = robotsKnowledge;
    }

    public RobotsHealthy getRobotsHealthy() {
        return robotsHealthy;
    }

    public List<String> getRobotsKnowledge() {
        return robotsKnowledge.getKnowledge();
    }
}

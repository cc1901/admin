package robort.service;

import org.codehaus.jackson.JsonNode;
import play.Play;
import play.libs.WS;
import robort.domain.RobotsHealthy;
import robort.domain.RobotsStatus;


public class ReportRobotsService {
    public RobotsStatus getRobotsStatus() {
        String robotsUrl = Play.application().configuration().getString("robots.url");
        WS.Response response = WS.url(robotsUrl).post("{\"question\":\"你好\",\"context\":\"\"}").get();
        if (response == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        JsonNode chatResponseJson = response.asJson();
        if (chatResponseJson == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        if (chatResponseJson.findPath("answer") == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        String answer = chatResponseJson.findPath("answer").getTextValue();
        return new RobotsStatus(RobotsHealthy.WORKING);
    }
}

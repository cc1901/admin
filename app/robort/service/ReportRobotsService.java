package robort.service;

import org.codehaus.jackson.JsonNode;
import play.Logger;
import play.Play;
import play.libs.WS;
import robort.domain.RobotsHealthy;
import robort.domain.RobotsKnowledge;
import robort.domain.RobotsStatus;
import robort.util.JsonParser;

import java.io.IOException;


public class ReportRobotsService {
    public RobotsStatus getRobotsStatus() {
        String robotsUrl = Play.application().configuration().getString("robots.url");
        WS.Response response = WS.url(robotsUrl).setHeader("Content-type", "application/json").post("{\"question\":\"$check_status\",\"context\":\"\"}").get();
        Logger.info(response.getBody().toString() + "----------------");
        if (response == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        JsonNode chatResponseJson = null;
        try {
            chatResponseJson = response.asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (chatResponseJson == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        if (chatResponseJson.findPath("answer") == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        String answer = chatResponseJson.findPath("answer").getTextValue();
        RobotsKnowledge robotsKnowledge = null;
        try {
            robotsKnowledge = new JsonParser<RobotsKnowledge>().parse(answer, RobotsKnowledge.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (robotsKnowledge == null || robotsKnowledge.getKnowledge() == null) {
            return new RobotsStatus(RobotsHealthy.DOWN);
        }
        return new RobotsStatus(RobotsHealthy.WORKING, robotsKnowledge);
    }
}

package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import robort.domain.RobotsStatus;
import robort.service.ReportRobotsService;
import views.html.report;

public class Report extends Controller {
    public static Result reportRobotsStatus() {
        RobotsStatus robotsStatus = new ReportRobotsService().getRobotsStatus();
        return ok(report.render(robotsStatus));
    }
}

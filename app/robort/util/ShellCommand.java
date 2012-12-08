package robort.util;

import play.Logger;

import java.io.IOException;

public class ShellCommand {
    public static void run(String command) {
        Runtime run = Runtime.getRuntime();
        try {
            Logger.info("command to run is: " + command);
            Logger.info("current path is: " + System.getProperty("user.dir"));
            Process process = run.exec(command);
            process.waitFor();
        } catch (InterruptedException e) {
            Logger.error("command fail+++++++++++++++++++++++++++++", e);
            e.printStackTrace();
        } catch (IOException e) {
            Logger.error("io fail+++++++++++++++++++++++++++++", e);
            e.printStackTrace();
        }
    }
}

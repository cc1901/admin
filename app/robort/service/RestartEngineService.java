package robort.service;

import robort.util.ShellCommand;

public class RestartEngineService {
    public void restart() {
        String restartEngineCommand = "/etc/init.d/tomcat restart";
        ShellCommand.run(restartEngineCommand);
    }
}

package kz.edu.nu.cs.exercise;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

class Logger {
    private static Logger singleton = null;

    private List<String> logs = new ArrayList<>();

    private Logger() {

    }

    static Logger getInstance() {
        if (singleton == null)
            singleton = new Logger();
        return singleton;
    }

    void log(HttpServletRequest request) {
        String record = request.getRemoteHost();
        logs.add(record);
    }

    String getLogs() {
        return "Logs:\n" + String.join("\n", logs);
    }
}

package kz.edu.nu.cs.exercise;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String record = df.format(new Date());
        record += "|" + request.getRemoteHost();
        record += "|" + request.getContextPath();
        logs.add(record);
    }

    String getLogs() {
        return "Logs:\n" + String.join("\n", logs);
    }
}

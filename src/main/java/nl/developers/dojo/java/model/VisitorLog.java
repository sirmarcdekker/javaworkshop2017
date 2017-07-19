package nl.developers.dojo.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorLog {
    private LocalDate logDate;
    private List<String> visitors = new ArrayList<>();

    public VisitorLog(LocalDate logDate) {
        this.logDate = logDate;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public void addVisitor(String name) {
        visitors.add(name);
    }
}

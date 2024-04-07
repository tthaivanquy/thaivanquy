package baitap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Document {
    private List<String> lines;

    public Document() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void removeEmptyLines() {
        lines = lines.stream().filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());
    }

    public List<String> getLines() {
        return lines;
    }
}

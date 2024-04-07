package baitap;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {
    public void saveToFile(List<String> lines, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    public List<String> loadFromFile(String filePath) throws IOException {
        List<String> lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lines = reader.lines().collect(Collectors.toList());
        }
        return lines;
    }
}
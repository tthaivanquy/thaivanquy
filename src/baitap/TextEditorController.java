package baitap;

import java.io.IOException;
import java.util.List;

public class TextEditorController {
    private Document document;
    private FileHandler fileHandler;

    public TextEditorController(Document document, FileHandler fileHandler) {
        this.document = document;
        this.fileHandler = fileHandler;
    }

    public Document getDocument() {
        return document;
    }

    public void loadFile(String filePath) {
        try {
            List<String> lines = fileHandler.loadFromFile(filePath);
            document.getLines().clear();
            document.getLines().addAll(lines);
        } catch (IOException e) {
            // Xử lý lỗi khi load file
        }
    }

    public void saveFile(String filePath) {
        try {
            fileHandler.saveToFile(document.getLines(), filePath);
        } catch (IOException e) {
            // Xử lý lỗi khi lưu file
        }
    }

    public void addLine(String line) {
        document.addLine(line);
    }

    public void removeEmptyLines() {
        document.removeEmptyLines();
    }
}
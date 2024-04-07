package baitap;

public class TextEditor {
	public static void main(String[] args) {
		Document dout= new Document();
		FileHandler file= new FileHandler();
		 TextEditorController controller = new TextEditorController(dout, file);
	        TextView view = new TextView(controller);
	        
	        // Hiển thị giao diện
	        view.display();
	    }
}
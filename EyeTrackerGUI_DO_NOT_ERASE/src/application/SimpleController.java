package application;

import javafx.fxml.FXML;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

public class SimpleController {
	/*@FXML //  fx:id="myButton"
    private Button myButton; // Value injected by FXMLLoader


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }*/
	@FXML
	private Text textDrag;
	
	@FXML
	public void drag(){
		 Dragboard db = textDrag.startDragAndDrop(TransferMode.COPY);
		 ClipboardContent content = new ClipboardContent();
	     content.putString(textDrag.getText());
	     db.setContent(content);
	}
	
	@FXML
	public void dropped(DragEvent event){
		Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
        	Text textDrag2 = new Text();
           textDrag2.setText(db.getString());
           textDrag2.setLayoutX(event.getX());
           textDrag2.setLayoutY(event.getY());
           success = true;
        }
        /* let the source know whether the string was successfully 
         * transferred and used */
        event.setDropCompleted(success);
        
        event.consume();	
	}
}

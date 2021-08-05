package righttriangle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TVController implements EventHandler {
    
    private RightTriangle model;
    private TextView tv;
    
    public TVController (RightTriangle model) {
        this.model = model;
        this.tv = new TextView(this.model);
        this.tv.tfBase.setOnAction(this);
        this.tv.tfHeight.setOnAction(this);        
    }
    
    public TextView getTextView () {
        return this.tv;
    }
    
   @Override public void handle(Event event) {
        TextField tf = (TextField)event.getSource();
        try{
            double number = Double.parseDouble(tf.getText());
            if (number < 0) throw new NumberFormatException();
            String id = tf.getId();
            if (id.equals("tfBase")) {
                this.model.setBase(number);
            } else {
                this.model.setHeight(number);
            }
        } catch (NumberFormatException e) {
            this.tv.update(model, null);
        }
    }
}

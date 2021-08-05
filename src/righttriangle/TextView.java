package righttriangle;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextView extends GridPane implements Observer {
    
    private RightTriangle target;
    private Label lblBase;
    private Label lblHeight;
    private Label lblHypotenuse;
    public TextField tfBase;
    public TextField tfHeight;
    private Label lblCalcHypotenuse;
    
    public TextView(RightTriangle rt) {
        this.target = rt;
        this.target.addObserver(this);
        this.lblBase = new Label("Base");
        this.lblHeight = new Label("Height");
        this.lblHypotenuse = new Label("Hypotenuse     ");
        this.tfBase = new TextField(String.valueOf(target.getBase()));
        this.tfBase.setId("tfBase");
        this.tfHeight = new TextField(String.valueOf(target.getHeight()));
        this.tfHeight.setId("tfHeight");
        this.lblCalcHypotenuse = new Label(String.valueOf(target.getHypotenuse()));
        this.add(lblBase, 0, 0);
        this.add(tfBase, 1, 0);
        this.add(lblHeight, 0, 1);
        this.add(tfHeight, 1, 1);
        this.add(lblHypotenuse, 0, 2);
        this.add(lblCalcHypotenuse, 1, 2);
    }
    
    @Override public void update(Observable model, Object arg) {
        RightTriangle rt = (RightTriangle)model;
        this.tfBase.setText(String.valueOf(rt.getBase()));
        this.tfHeight.setText(String.valueOf(rt.getHeight()));
        this.lblCalcHypotenuse.setText(String.valueOf(rt.getHypotenuse()));
    }
    
}

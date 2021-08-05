package righttriangle;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Group;

public class GraphicalView extends Group implements Observer{
    
    private RightTriangle target;
    private Double[] origin;
    private Double[] y;
    private Double[] x;
    
    private GraphicalView(RightTriangle rt) {
        this.target = rt;
        this.target.addObserver(this);
        // this.origin = 50.0 + target.getHeight();
    }
    
    @Override public void update(Observable model, Object arg) {
        RightTriangle rt = (RightTriangle)model;
    }
}
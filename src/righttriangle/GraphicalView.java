package righttriangle;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public class GraphicalView extends Group implements Observer{
    
    private RightTriangle target;
    private Double[] origin;
    private Double[] y;
    private Double[] x;
    private double yOffset = 150.0;
    private double xOffset = 25.0;
    
    public GraphicalView(RightTriangle rt) {
        this.target = rt;
        this.target.addObserver(this);
        calcPoints();
        drawTriangle();
    }
    
    private void calcPoints(){
        this.origin = new Double[2];
        this.origin[0] = xOffset;
        this.origin[1] = yOffset + target.getHeight();
        this.y = new Double[2];
        this.y[0] = xOffset;
        this.y[1] = yOffset;
        this.x = new Double[2];
        this.x[0] = xOffset + target.getBase();
        this.x[1] = yOffset + target.getHeight();
    }
    
    private void drawTriangle(){
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            origin[0], origin[1],
            y[0], y[1],
            x[0], x[1] 
        });
        if (this.getChildren().size() > 0) {
            this.getChildren().clear();
        }
        this.getChildren().add(polygon);
    }
    
    @Override public void update(Observable model, Object arg) {
        RightTriangle rt = (RightTriangle)model;
        calcPoints();
        drawTriangle();
    }
}
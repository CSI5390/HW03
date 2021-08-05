package righttriangle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Base extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        RightTriangle rt = new RightTriangle(225, 225);
        TVController tvc = new TVController(rt);
        GraphicalView gv = new GraphicalView(rt);
        
        // primaryStage.setScene(new Scene(tvc.getTextView(), 500, 500));
        
        Group gControls = new Group(tvc.getTextView());
        Group gTriangle = new Group(gv);
        Group g = new Group(gControls, gTriangle);
        Scene s = new Scene(g, 600, 600);
        
        primaryStage.setTitle("CSI5390 Machado Right Triangle");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

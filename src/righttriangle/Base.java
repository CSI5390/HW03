package righttriangle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Base extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        RightTriangle rt = new RightTriangle(10, 10);
        TVController tvc = new TVController(rt);
        
        primaryStage.setTitle("CSI5390 Machado Right Triangle");
        primaryStage.setScene(new Scene(tvc.getTextView(), 500, 500));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

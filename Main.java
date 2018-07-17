import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

/* Classe de entrada do programa */
public class Main extends Application {

    private static double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
    private static double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

    @Override
    public void start(Stage primaryStage) {

        try {
            
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, Color.BLACK);
            definePrimaryStage(scene, primaryStage);

            final Canvas canvas = new Canvas(screenWidth, screenHeight);
            GraphicsContext context = canvas.getGraphicsContext2D();

            /* Carregamento dos arquivos. */
            Loader loader = new Loader("../iluminacao.txt", "../camera.cfg", "../tui.byu");
            Camera camera = loader.loadCamera();
            Illumination illumination = loader.loadScene(camera.worldToView(), camera.getCoordinates());
            SceneObject object = loader.loadObject(camera.worldToView(), camera.getCoordinates());
            
            /* Cálculo das normais e normalização */

            root.getChildren().add(canvas);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void definePrimaryStage(Scene scene, Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if(KeyCode.ESCAPE == event.getCode())
                primaryStage.close();
        });
    }
    
}
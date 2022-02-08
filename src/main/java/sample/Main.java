package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // Загружаем FXML файл с данными о сцене.
        primaryStage.setTitle("Tournament Grid"); // Ставим название приложения.
        Scene scene = new Scene(root, 1920, 1080); // Строим сцену FullHD
        primaryStage.getIcons().add(new Image("https://i.imgur.com/9Dgr8nI.png"));
        primaryStage.setScene(scene);

        primaryStage.setFullScreen(true); // Включение режим полного-экрана.
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); // Выключаю выход из полноэкраного режима. Только Alt+Tab сворачивает.
        primaryStage.setResizable(false); // Изменять размер рамки пользователь не может.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

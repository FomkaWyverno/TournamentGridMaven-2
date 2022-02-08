package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EggController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane xPanel;

    @FXML
    private ImageView xX1Y3;

    @FXML
    private ImageView xX2Y3;

    @FXML
    private ImageView xX3Y3;

    @FXML
    private ImageView xX3Y2;

    @FXML
    private ImageView xX3Y1;

    @FXML
    private ImageView xX2Y2;

    @FXML
    private ImageView xX1Y2;

    @FXML
    private ImageView xX1Y1;

    @FXML
    private ImageView xX2Y1;

    @FXML
    private AnchorPane oPanel;

    @FXML
    private ImageView oX1Y3;

    @FXML
    private ImageView oX2Y3;

    @FXML
    private ImageView oX3Y3;

    @FXML
    private ImageView oX2Y2;

    @FXML
    private ImageView oX3Y2;

    @FXML
    private ImageView oX1Y2;

    @FXML
    private ImageView oX1Y1;

    @FXML
    private ImageView oX2Y1;

    @FXML
    private ImageView oX3Y1;

    @FXML
    private Button bX1Y3;

    @FXML
    private Button bX2Y3;

    @FXML
    private Button bX3Y3;

    @FXML
    private Button bX3Y2;

    @FXML
    private Button bX2Y2;

    @FXML
    private Button bX1Y2;

    @FXML
    private Button bX1Y1;

    @FXML
    private Button bX2Y1;

    @FXML
    private Button bX3Y1;

    @FXML
    private AnchorPane pWIN;

    @FXML
    private JFXButton bWiN;

    @FXML
    private AnchorPane pLOSE;

    @FXML
    private JFXButton bLOSE;

    @FXML
    private AnchorPane pDraw;

    @FXML
    private JFXButton bDraw;

    @FXML
    void initialize() {
        LogicGame.setButtons(new Button[][]{{bX1Y1,bX2Y1,bX3Y1},
                                            {bX1Y2,bX2Y2,bX3Y2},
                                            {bX1Y3,bX2Y3,bX3Y3}});

        LogicGame.setImgX(new ImageView[][]{{xX1Y1,xX2Y1,xX3Y1},
                                            {xX1Y2,xX2Y2,xX3Y2},
                                            {xX1Y3,xX2Y3,xX3Y3}});

        LogicGame.setImgO(new ImageView[][]{{oX1Y1,oX2Y1,oX3Y1},
                                            {oX1Y2,oX2Y2,oX3Y2},
                                            {oX1Y3,oX2Y3,oX3Y3}});

        LogicGame.setpLose(pLOSE);
        LogicGame.setpWin(pWIN);
        LogicGame.setpDraw(pDraw);

        bX1Y3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(1,3);
                bX1Y3.setDisable(true);
            }
        });
        bX2Y3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(2,3);
                bX2Y3.setDisable(true);
            }
        });
        bX3Y3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(3,3);
                bX3Y3.setDisable(true);
            }
        });
        bX1Y2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(1,2);
                bX1Y2.setDisable(true);
            }
        });
        bX2Y2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(2,2);
                bX2Y2.setDisable(true);
            }
        });
        bX3Y2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(3,2);
                bX3Y2.setDisable(true);
            }
        });
        bX1Y1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(1,1);
                bX1Y1.setDisable(true);
            }
        });
        bX2Y1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(2,1);
                bX2Y1.setDisable(true);
            }
        });
        bX3Y1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.click(3,1);
                bX3Y1.setDisable(true);
            }
        });

        bWiN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.resetGame();
                pWIN.setVisible(false);
            }
        });
        bLOSE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.resetGame();
                pLOSE.setVisible(false);
            }
        });
        bDraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGame.resetGame();
                pDraw.setVisible(false);
            }
        });
    }
}

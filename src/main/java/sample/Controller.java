package sample;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView redMark;

    @FXML
    private ImageView greenMark;

    @FXML
    private AnchorPane panelQuatersFinal;

    @FXML
    private TextField qfPlayer1BlueCommand1;

    @FXML
    private TextField qfPlayer2BlueCommand1;

    @FXML
    private TextField qfPlayer1RedCommand1;

    @FXML
    private TextField qfPlayer2RedCommand1;

    @FXML
    private TextField qfPlayer1BlueCommand2;

    @FXML
    private TextField qfPlayer2BlueCommand2;

    @FXML
    private TextField qfPlayer1RedCommand2;

    @FXML
    private TextField qfPlayer2RedCommand2;

    @FXML
    private ImageView qfBattle1;

    @FXML
    private TextField qfPlayer1BlueCommand3;

    @FXML
    private TextField qfPlayer2BlueCommand3;

    @FXML
    private TextField qfPlayer1RedCommand3;

    @FXML
    private TextField qfPlayer2RedCommand3;

    @FXML
    private TextField qfPlayer1BlueCommand4;

    @FXML
    private TextField qfPlayer2BlueCommand4;

    @FXML
    private TextField qfPlayer1RedCommand4;

    @FXML
    private TextField qfPlayer2RedCommand4;

    @FXML
    private ImageView qfBattle2;

    @FXML
    private AnchorPane panelPreFinal;

    @FXML
    private TextField pfPlayer1BlueCommand1;

    @FXML
    private TextField pfPlayer2BlueCommand1;

    @FXML
    private TextField pfPlayer1RedCommand1;

    @FXML
    private TextField pfPlayer2RedCommand1;

    @FXML
    private ImageView pfBattle1;

    @FXML
    private TextField pfPlayer1BlueCommand2;

    @FXML
    private TextField pfPlayer2BlueCommand2;

    @FXML
    private TextField pfPlayer1RedCommand2;

    @FXML
    private TextField pfPlayer2RedCommand2;

    @FXML
    private ImageView pfBattle2;

    @FXML
    private AnchorPane panelFinal;

    @FXML
    private TextField fPlayer1BlueCommand1;

    @FXML
    private TextField fPlayer2BlueCommand1;

    @FXML
    private TextField fPlayer1RedCommand2;

    @FXML
    private TextField fPlayer2RedCommand2;

    @FXML
    private ImageView fBattle;

    @FXML
    private AnchorPane panelWinner;

    @FXML
    private TextField winnerP1;

    @FXML
    private TextField winnerP2;

    @FXML
    private JFXButton qfBlueGroup1;

    @FXML
    private JFXButton qfRedGroup1;

    @FXML
    private JFXButton qfBlueGroup2;

    @FXML
    private JFXButton qfRedGroup2;

    @FXML
    private JFXButton pfBlueGroup1;

    @FXML
    private JFXButton pfRedGroup1;

    @FXML
    private JFXButton fBlueGroup;

    @FXML
    private JFXButton fRedGroup;

    @FXML
    private JFXButton pfBlueGroup2;

    @FXML
    private JFXButton pfRedGroup2;

    @FXML
    private JFXButton qfBlueGroup4;

    @FXML
    private JFXButton qfRedGroup4;

    @FXML
    private JFXButton qfBlueGroup3;

    @FXML
    private JFXButton qfRedGroup3;

    @FXML
    private Button changeBlue1Group1qf;

    @FXML
    private Button changeBlue2Group1qf;

    @FXML
    private Button changeRed1Group1qf;

    @FXML
    private Button changeRed2Group1qf;

    @FXML
    private Button changeBlue1Group2qf;

    @FXML
    private Button changeBlue2Group2qf;

    @FXML
    private Button changeRed1Group2qf;

    @FXML
    private Button changeRed2Group2qf;

    @FXML
    private Button changeRed2Group1pf;

    @FXML
    private Button changeRed1Group1pf;

    @FXML
    private Button changeBlue2Group1pf;

    @FXML
    private Button changeBlue1Group1pf;

    @FXML
    private Button changeBlue1GroupF;

    @FXML
    private Button changeBlue2GroupF;

    @FXML
    private Button changeRed2GroupF;

    @FXML
    private Button changeRed1GroupF;

    @FXML
    private Button changeBlue2Group2pf;

    @FXML
    private Button changeBlue1Group2pf;

    @FXML
    private Button changeRed1Group2pf;

    @FXML
    private Button changeRed2Group2pf;

    @FXML
    private Button changeRed2Group4qf;

    @FXML
    private Button changeRed1Group4qf;

    @FXML
    private Button changeBlue2Group4qf;

    @FXML
    private Button changeBlue1Group4qf;

    @FXML
    private Button changeRed2Group3qf;

    @FXML
    private Button changeRed1Group3qf;

    @FXML
    private Button changeBlue2Group3qf;

    @FXML
    private Button changeBlue1Group3qf;

    @FXML
    private Button mixButton;

    @FXML
    private JFXButton eggButton;

    @FXML
    private TextField nickFlied;

    private static TextField nickWriter;
    private static Button buttonMix;
    private static HashMap<String,TextField> tournamentFields = new HashMap<>(30);
    private static HashMap<String,JFXButton> tournamentButton = new HashMap<>(14);

    private static ImageView buttonMixOff;
    private static ImageView buttonMixOn;
    private static ImageView markGreen;
    private static ImageView markRed;
    private static Button[] buttonsChange;

    static {
        Image imgOff = new Image("resources/mixButton.png"); // file:.resources\mixButton.png
        buttonMixOff = new ImageView(imgOff); // Загружаем выключенную кнопку для микса играков.
        Image imgOn = new Image("resources/mixButtonPressed.png"); //file:.resources\mixButtonPressed.png
        buttonMixOn = new ImageView(imgOn); // Загружаем нажатую кнопку для микса играков.
    }

    public static TextField getNickWriter() {
        return nickWriter;
    }

    public static ImageView getMarkGreen() {
        return markGreen;
    }

    public static ImageView getMarkRed() {
        return markRed;
    }

    public static Button getButtonMix() {
        return buttonMix;
    }

    public static HashMap<String, TextField> getTournamentFields() {
        return tournamentFields;
    }

    public static HashMap<String,JFXButton> getTournamentButton() {
        return tournamentButton;
    }

    public static Button[] getButtonsChange() {
        return buttonsChange;
    }

    @FXML
    void initialize() {

        buttonsChange = new Button[]{
                changeBlue1Group1qf,
                changeBlue2Group1qf,
                changeRed1Group1qf,
                changeRed2Group1qf,
                changeBlue1Group2qf,
                changeBlue2Group2qf,
                changeRed1Group2qf,
                changeRed2Group2qf,
                changeRed2Group1pf,
                changeRed1Group1pf,
                changeBlue2Group1pf,
                changeBlue1Group1pf,
                changeBlue1GroupF,
                changeBlue2GroupF,
                changeRed2GroupF,
                changeRed1GroupF,
                changeBlue2Group2pf,
                changeBlue1Group2pf,
                changeRed1Group2pf,
                changeRed2Group2pf,
                changeRed2Group4qf,
                changeRed1Group4qf,
                changeBlue2Group4qf,
                changeBlue1Group4qf,
                changeRed2Group3qf,
                changeRed1Group3qf,
                changeBlue2Group3qf,
                changeBlue1Group3qf};

        for (Button button : buttonsChange) {
            button.setDisable(true);
        }

        //Quarter-Final
        tournamentFields.put("qfPlayer1BlueCommand1",qfPlayer1BlueCommand1);
        tournamentFields.put("qfPlayer2BlueCommand1",qfPlayer2BlueCommand1);
        tournamentFields.put("qfPlayer1RedCommand1",qfPlayer1RedCommand1);
        tournamentFields.put("qfPlayer2RedCommand1",qfPlayer2RedCommand1);
        tournamentFields.put("qfPlayer1BlueCommand2",qfPlayer1BlueCommand2);
        tournamentFields.put("qfPlayer2BlueCommand2",qfPlayer2BlueCommand2);
        tournamentFields.put("qfPlayer1RedCommand2",qfPlayer1RedCommand2);
        tournamentFields.put("qfPlayer2RedCommand2",qfPlayer2RedCommand2);
        tournamentFields.put("qfPlayer1BlueCommand3",qfPlayer1BlueCommand3);
        tournamentFields.put("qfPlayer2BlueCommand3",qfPlayer2BlueCommand3);
        tournamentFields.put("qfPlayer1RedCommand3",qfPlayer1RedCommand3);
        tournamentFields.put("qfPlayer2RedCommand3",qfPlayer2RedCommand3);
        tournamentFields.put("qfPlayer1BlueCommand4",qfPlayer1BlueCommand4);
        tournamentFields.put("qfPlayer2BlueCommand4",qfPlayer2BlueCommand4);
        tournamentFields.put("qfPlayer1RedCommand4",qfPlayer1RedCommand4);
        tournamentFields.put("qfPlayer2RedCommand4",qfPlayer2RedCommand4);
        //Pre-Final
        tournamentFields.put("pfPlayer1BlueCommand1",pfPlayer1BlueCommand1);
        tournamentFields.put("pfPlayer2BlueCommand1",pfPlayer2BlueCommand1);
        tournamentFields.put("pfPlayer1RedCommand1",pfPlayer1RedCommand1);
        tournamentFields.put("pfPlayer2RedCommand1",pfPlayer2RedCommand1);
        tournamentFields.put("pfPlayer1BlueCommand2",pfPlayer1BlueCommand2);
        tournamentFields.put("pfPlayer2BlueCommand2",pfPlayer2BlueCommand2);
        tournamentFields.put("pfPlayer1RedCommand2",pfPlayer1RedCommand2);
        tournamentFields.put("pfPlayer2RedCommand2",pfPlayer2RedCommand2);
        //Final
        tournamentFields.put("fPlayer1BlueCommand1",fPlayer1BlueCommand1);
        tournamentFields.put("fPlayer2BlueCommand1",fPlayer2BlueCommand1);
        tournamentFields.put("fPlayer1RedCommand1",fPlayer1RedCommand2);
        tournamentFields.put("fPlayer2RedCommand2",fPlayer2RedCommand2);
        //Winner
        tournamentFields.put("winnerP1",winnerP1);
        tournamentFields.put("winnerP2",winnerP2);


        //Quarter-Final
        tournamentButton.put("qfBlueGroup1",qfBlueGroup1);
        tournamentButton.put("qfRedGroup1",qfRedGroup1);
        tournamentButton.put("qfBlueGroup2",qfBlueGroup2);
        tournamentButton.put("qfRedGroup2",qfRedGroup2);
        tournamentButton.put("qfBlueGroup3",qfBlueGroup3);
        tournamentButton.put("qfRedGroup3",qfRedGroup3);
        tournamentButton.put("qfBlueGroup4",qfBlueGroup4);
        tournamentButton.put("qfRedGroup4",qfRedGroup4);
        //Pre-Final
        tournamentButton.put("pfBlueGroup1",pfBlueGroup1);
        tournamentButton.put("pfRedGroup1",pfRedGroup1);
        tournamentButton.put("pfBlueGroup2",pfBlueGroup2);
        tournamentButton.put("pfRedGroup2",pfRedGroup2);
        //Final
        tournamentButton.put("fBlueGroup",fBlueGroup);
        tournamentButton.put("fRedGroup",fRedGroup);

        mixButton.setGraphic(buttonMixOff); // Устанавливаем изображание на кнопке
        nickWriter = nickFlied; // Перекидуем nickField в static переменную nickWriter
        markGreen = greenMark; // Аналогично с nickField
        markRed = redMark;
        buttonMix = mixButton;
        nickFlied.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nickFlied.getText().length() > 2 && !TGrid.isHavePlayer(nickFlied.getText())) { // При вводе данных если пользователь нажмет ENTER попадаем сюда.
                    if (!TGrid.isFull()) { // Если строку он написал больше 2 символов, и Турнирные места не заполненые, то выполняется код ниже.
                        TGrid.addPlayer(nickFlied.getText());
                        nickFlied.setText("");
                    }
                } else {
                    TGrid.playError();
                }

            }
        });

        // Кнопка перемешивание играков в турнирной сетке
        mixButton.setDisable(true); // Иницилизируем как выключеную кнопку.
        mixButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mixButton.setGraphic(buttonMixOff); // Если человек не увел курсор от кнопки и отжал то есть он кликнул по ней и отпустил то выполняется это.
            }
        });
        mixButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mixButton.setGraphic(buttonMixOn); // Как только пользователь нажал на кнопку, кнопка принимает вид нажатой кнопки.
            }
        });
        mixButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mixButton.setGraphic(buttonMixOff); // Когда человек отпустил левую кнопку мыши то кнопка принимает вид не нажатой кнопки.
                TGrid.mixPlayers();
            }
        });


        // QUARTER-FINAL -- ИНИЦИЛИЗАЦИЯ КНОПОК И ТЕКСТОВЫХ ПОЛЕЙ СМЕНЫ НИКА В ТУРНИРНОЙ СЕТКЕ

        changeBlue1Group1qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group1qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group1qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1RedCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group1qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2RedCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue1Group2qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1BlueCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group2qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2BlueCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group2qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group2qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue1Group3qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1BlueCommand3.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group3qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2BlueCommand3.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group3qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1RedCommand3.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group3qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2RedCommand3.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue1Group4qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1BlueCommand4.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group4qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2BlueCommand4.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group4qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer1RedCommand4.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group4qf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        qfPlayer2RedCommand4.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });

        // PRE-FINAL

        changeBlue1Group1pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer1BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group1pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer2BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group1pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer1RedCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group1pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer2RedCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue1Group2pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer1BlueCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2Group2pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer2BlueCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1Group2pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer1RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2Group2pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        pfPlayer2RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });

        // FINAL
        changeBlue1GroupF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        fPlayer1BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeBlue2GroupF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        fPlayer2BlueCommand1.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed1GroupF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        fPlayer1RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        changeRed2GroupF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nickFlied.setDisable(false);
                nickFlied.setEditable(true);
                nickFlied.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String str = nickFlied.getText();
                        fPlayer2RedCommand2.setText(str);
                        nickFlied.setText("");
                        nickFlied.setDisable(true);
                        nickFlied.setEditable(false);
                    }
                });
            }
        });
        eggButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("eggGame.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Tic Tac Toe");
                    stage.setResizable(false);
                    stage.getIcons().add(new Image("https://i.imgur.com/9Dgr8nI.png"));
                    stage.setScene(new Scene(root,480,480));
                    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent event) {
                            LogicGame.resetGame();
                        }
                    });
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        TGrid.load();
    }
}

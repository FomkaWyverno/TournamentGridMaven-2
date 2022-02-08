package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class TGrid {
    private static final TextField nickFlied = Controller.getNickWriter();
    private static final Button mixButton = Controller.getButtonMix();
    private static final HashMap<String,TextField> tournamentFields = Controller.getTournamentFields();
    private static final HashMap<String, JFXButton> tournamentButton = Controller.getTournamentButton();

    private static final ImageView greenMark = Controller.getMarkGreen();
    private static final ImageView redMark = Controller.getMarkRed();
    private static final String[] players = new String[16];
    private static int sizePlayers = 0;
    private static boolean isFull;
    private static final Button changeButtons[] = Controller.getButtonsChange();
    //Quarter-Final

    private static final TextField[] qfFieldsBlueGroup1 = new TextField[2];
    private static final TextField[] qfFieldsRedGroup1 = new TextField[2];

    private static final TextField[] qfFieldsBlueGroup2 = new TextField[2];
    private static final TextField[] qfFieldsRedGroup2 = new TextField[2];

    private static final TextField[] qfFieldsBlueGroup3 = new TextField[2];
    private static final TextField[] qfFieldsRedGroup3 = new TextField[2];

    private static final TextField[] qfFieldsBlueGroup4 = new TextField[2];
    private static final TextField[] qfFieldsRedGroup4 = new TextField[2];

    //Pre-Final

    private static final TextField[] pfFieldsBlueGroup1 = {
            tournamentFields.get("pfPlayer1BlueCommand1"),
            tournamentFields.get("pfPlayer2BlueCommand1")};
    private static final TextField[] pfFieldsRedGroup1 = {
            tournamentFields.get("pfPlayer1RedCommand1"),
            tournamentFields.get("pfPlayer2RedCommand1")};

    private static final TextField[] pfFieldsBlueGroup2 = {
            tournamentFields.get("pfPlayer1BlueCommand2"),
            tournamentFields.get("pfPlayer2BlueCommand2")};
    private static final TextField[] pfFieldsRedGroup2 = {
            tournamentFields.get("pfPlayer1RedCommand2"),
            tournamentFields.get("pfPlayer2RedCommand2")};

    // Final

    private static final TextField[] fFieldsBlueGroup = {
            tournamentFields.get("fPlayer1BlueCommand1"),
            tournamentFields.get("fPlayer2BlueCommand1")};

    private static final TextField[] fFieldsRedGroup = {
            tournamentFields.get("fPlayer1RedCommand1"),
            tournamentFields.get("fPlayer2RedCommand2")};

    // Winner

    private static final TextField[] fieldsWinnerGroup = {
            tournamentFields.get("winnerP1"),
            tournamentFields.get("winnerP2")};

    private static final TextField[] commands = {
            tournamentFields.get("qfPlayer1BlueCommand1"),
            tournamentFields.get("qfPlayer2BlueCommand1"),
            tournamentFields.get("qfPlayer1RedCommand1"),
            tournamentFields.get("qfPlayer2RedCommand1"),
            tournamentFields.get("qfPlayer1BlueCommand2"),
            tournamentFields.get("qfPlayer2BlueCommand2"),
            tournamentFields.get("qfPlayer1RedCommand2"),
            tournamentFields.get("qfPlayer2RedCommand2"),
            tournamentFields.get("qfPlayer1BlueCommand3"),
            tournamentFields.get("qfPlayer2BlueCommand3"),
            tournamentFields.get("qfPlayer1RedCommand3"),
            tournamentFields.get("qfPlayer2RedCommand3"),
            tournamentFields.get("qfPlayer1BlueCommand4"),
            tournamentFields.get("qfPlayer2BlueCommand4"),
            tournamentFields.get("qfPlayer1RedCommand4"),
            tournamentFields.get("qfPlayer2RedCommand4")};

    static {
        // Обьденяю групы в массив.
        qfFieldsBlueGroup1[0] = tournamentFields.get("qfPlayer1BlueCommand1");
        qfFieldsBlueGroup1[1] = tournamentFields.get("qfPlayer2BlueCommand1");
        qfFieldsRedGroup1[0] = tournamentFields.get("qfPlayer1RedCommand1");
        qfFieldsRedGroup1[1] = tournamentFields.get("qfPlayer2RedCommand1");
        qfFieldsBlueGroup2[0] = tournamentFields.get("qfPlayer1BlueCommand2");
        qfFieldsBlueGroup2[1] = tournamentFields.get("qfPlayer2BlueCommand2");
        qfFieldsRedGroup2[0] = tournamentFields.get("qfPlayer1RedCommand2");
        qfFieldsRedGroup2[1] = tournamentFields.get("qfPlayer2RedCommand2");
        qfFieldsBlueGroup3[0] = tournamentFields.get("qfPlayer1BlueCommand3");
        qfFieldsBlueGroup3[1] = tournamentFields.get("qfPlayer2BlueCommand3");
        qfFieldsRedGroup3[0] = tournamentFields.get("qfPlayer1RedCommand3");
        qfFieldsRedGroup3[1] = tournamentFields.get("qfPlayer2RedCommand3");
        qfFieldsBlueGroup4[0] = tournamentFields.get("qfPlayer1BlueCommand4");
        qfFieldsBlueGroup4[1] = tournamentFields.get("qfPlayer2BlueCommand4");
        qfFieldsRedGroup4[0] = tournamentFields.get("qfPlayer1RedCommand4");
        qfFieldsRedGroup4[1] = tournamentFields.get("qfPlayer2RedCommand4");
    }

    // Статическая загрузка активация для коректной перехода в следующий этап.
    static {
        // QUARTET-FINAL
        tournamentButton.get("qfBlueGroup1").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsBlueGroup1[0].getText();
                String player2 = qfFieldsBlueGroup1[1].getText();
                pfFieldsBlueGroup1[0].setText(player1);
                pfFieldsBlueGroup1[1].setText(player2);
            }
        });
        tournamentButton.get("qfRedGroup1").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsRedGroup1[0].getText();
                String player2 = qfFieldsRedGroup1[1].getText();
                pfFieldsBlueGroup1[0].setText(player1);
                pfFieldsBlueGroup1[1].setText(player2);
            }
        });
        tournamentButton.get("qfBlueGroup2").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsBlueGroup2[0].getText();
                String player2 = qfFieldsBlueGroup2[1].getText();
                pfFieldsRedGroup1[0].setText(player1);
                pfFieldsRedGroup1[1].setText(player2);
            }
        });
        tournamentButton.get("qfRedGroup2").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsRedGroup2[0].getText();
                String player2 = qfFieldsRedGroup2[1].getText();
                pfFieldsRedGroup1[0].setText(player1);
                pfFieldsRedGroup1[1].setText(player2);
            }
        });
        tournamentButton.get("qfBlueGroup3").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsBlueGroup3[0].getText();
                String player2 = qfFieldsBlueGroup3[1].getText();
                pfFieldsBlueGroup2[0].setText(player1);
                pfFieldsBlueGroup2[1].setText(player2);
            }
        });
        tournamentButton.get("qfRedGroup3").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsRedGroup3[0].getText();
                String player2 = qfFieldsRedGroup3[1].getText();
                pfFieldsBlueGroup2[0].setText(player1);
                pfFieldsBlueGroup2[1].setText(player2);
            }
        });
        tournamentButton.get("qfBlueGroup4").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsBlueGroup4[0].getText();
                String player2 = qfFieldsBlueGroup4[1].getText();
                pfFieldsRedGroup2[0].setText(player1);
                pfFieldsRedGroup2[1].setText(player2);
            }
        });
        tournamentButton.get("qfRedGroup4").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = qfFieldsRedGroup4[0].getText();
                String player2 = qfFieldsRedGroup4[1].getText();
                pfFieldsRedGroup2[0].setText(player1);
                pfFieldsRedGroup2[1].setText(player2);
            }
        });
        // PRE-FINAL
      /*tournamentButton.put("pfBlueGroup1",pfBlueGroup1);
        tournamentButton.put("pfRedGroup1",pfRedGroup1);
        tournamentButton.put("pfBlueGroup2",pfBlueGroup2);
        tournamentButton.put("pfRedGroup2",pfRedGroup2);*/
        tournamentButton.get("pfBlueGroup1").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = pfFieldsBlueGroup1[0].getText();
                String player2 = pfFieldsBlueGroup1[1].getText();
                fFieldsBlueGroup[0].setText(player1);
                fFieldsBlueGroup[1].setText(player2);
            }
        });
        tournamentButton.get("pfRedGroup1").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = pfFieldsRedGroup1[0].getText();
                String player2 = pfFieldsRedGroup1[1].getText();
                fFieldsBlueGroup[0].setText(player1);
                fFieldsBlueGroup[1].setText(player2);
            }
        });
        tournamentButton.get("pfBlueGroup2").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = pfFieldsBlueGroup2[0].getText();
                String player2 = pfFieldsBlueGroup2[1].getText();
                fFieldsRedGroup[0].setText(player1);
                fFieldsRedGroup[1].setText(player2);
            }
        });
        tournamentButton.get("pfRedGroup2").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = pfFieldsRedGroup2[0].getText();
                String player2 = pfFieldsRedGroup2[1].getText();
                fFieldsRedGroup[0].setText(player1);
                fFieldsRedGroup[1].setText(player2);
            }
        });
        //FINAL

        /*tournamentButton.put("fBlueGroup",fBlueGroup);
        tournamentButton.put("fRedGroup",fRedGroup);*/
        tournamentButton.get("fBlueGroup").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = fFieldsBlueGroup[0].getText();
                String player2 = fFieldsBlueGroup[1].getText();
                fieldsWinnerGroup[0].setText(player1);
                fieldsWinnerGroup[1].setText(player2);
            }
        });
        tournamentButton.get("fRedGroup").setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String player1 = fFieldsRedGroup[0].getText();
                String player2 = fFieldsRedGroup[1].getText();
                fieldsWinnerGroup[0].setText(player1);
                fieldsWinnerGroup[1].setText(player2);
            }
        });
    }

    protected static void load() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("nicknames.txt")));
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.isEmpty()) {
                    break;
                }
                players[sizePlayers] = line;
                sizePlayers++;
                if (sizePlayers == 16) { // Если играков 16 то выполняем ниже действия
                    nickFlied.setEditable(false); // Выключаем Текстовое поле для ввода
                    nickFlied.setDisable(true);
                    redMark.setVisible(false); // Выключаем красный маркер
                    greenMark.setVisible(true); // Включаем зеленый маркер который обозначает что все игроки набраны.
                    isFull = true; // Ставим переменной isFull true
                    mixButton.setDisable(false); // Включаем кнопку
                    for (String s : players) { // Выводим всех игроков в консоль.
                        System.out.println(s);
                    }
                    for (Button changeButton : changeButtons) {
                        changeButton.setDisable(false);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static boolean isFull() { // Возращает boolean isFull
        return isFull;
    }
    protected static void addPlayer(String player) {
        if (sizePlayers < 16) { // Если количество играков не меньше 16 то TRUE
            players[sizePlayers] = player; // Ставим на самое первое свободное место ник игрока.
            sizePlayers++; // Увеличиваем количество игроков.
            if (sizePlayers == 16) { // Если играков 16 то выполняем ниже действия
                nickFlied.setEditable(false); // Выключаем Текстовое поле для ввода
                nickFlied.setDisable(true);
                redMark.setVisible(false); // Выключаем красный маркер
                greenMark.setVisible(true); // Включаем зеленый маркер который обозначает что все игроки набраны.
                isFull = true; // Ставим переменной isFull true
                mixButton.setDisable(false); // Включаем кнопку
                for (String s : players) { // Выводим всех игроков в консоль.
                    System.out.println(s);
                }
                for (Button changeButton : changeButtons) {
                    changeButton.setDisable(false);
                }
            }
        }
    }
    protected static void mixPlayers() {
        Random random = new Random();
        int[] dropNum = new int[15];
        Arrays.fill(dropNum, -1);
        int sizeDropNum = 0;
        while (true) {
            int r = random.nextInt(16);


            if (!isHave(dropNum,r)) {
                dropNum[sizeDropNum] = r;
                commands[sizeDropNum].setText(players[r]);
                sizeDropNum++;
                if (sizeDropNum == 15) {
                    commands[15].setText(players[notHave(dropNum)]);
                    break;
                }
            }

        }
    }

    protected static boolean isHavePlayer(String player) {
        if (sizePlayers ==0) {
            return false;
        }
        for (String s : players) {
            if (s != null) {
                if (s.equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected synchronized static void playError() {
        Media media = new Media(new File("media/error.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }

    private static boolean isHave(int[] numbers, int rNumber) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == rNumber) {
                return true;
            }
        }
        return false;
    }
    private static int notHave(int[] numbers) {
        for (int i = 0; i < 16; i++) {
            if (!isHave(numbers,i)) {
                return i;
            }
        }
        return -1;
    }
}

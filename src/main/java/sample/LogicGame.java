package sample;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Arrays;
import java.util.Random;

public class LogicGame {

    private static ImageView[][] imgX; // Сетка 3на3 Х
    private static ImageView[][] imgO; // Сетка 3на3 О
    private static int clicks = 0;
    private static AnchorPane pWin;
    private static AnchorPane pLose;
    private static AnchorPane pDraw;

    private static Button[][] buttons;

    private static int[][] ticTacToe = new int[3][3];

    protected static void setpDraw(AnchorPane pDraw) {
        LogicGame.pDraw = pDraw;
    }

    protected static void setpWin(AnchorPane pWin) {
        LogicGame.pWin = pWin;
    }

    protected static void setpLose(AnchorPane pLose) {
        LogicGame.pLose = pLose;
    }

    protected static void setButtons(Button[][] buttons) {
        LogicGame.buttons = buttons;
    }

    protected static void setImgX(ImageView[][] imgX) {
        LogicGame.imgX = imgX;
    }

    protected static void setImgO(ImageView[][] imgO) {
        LogicGame.imgO = imgO;
    }

    static {
        for (int[] ints : ticTacToe) {
            Arrays.fill(ints, -1);
        }
    }

    protected static void resetGame() {
        for (int[] array : ticTacToe) {
            Arrays.fill(array,-1);
        }
        enablingButtons();
        disableIMG();
        clicks = 0;
    }

    protected static void click(int x, int y) {
        x--;
        y--;
        ticTacToe[y][x] = 0;
        if (checkWin(0) || checkWinO(0)) { // Победил ли игрок?
            disablingButtons();
            pWin.setVisible(true);
        } else {
            Random random = new Random();
            if (emptyDraw()) {
                disablingButtons();
                pDraw.setVisible(true);
            } else {
                if (clicks < 1) { // Если кликов меньше 1 то идем сюда
                    boolean b = false;
                    do { // Проходим один раз
                        int tmpX = random.nextInt(3); // Берем случайны числа не выше 2
                        int tmpY = random.nextInt(3);
                        if (havePlace(tmpX, tmpY)) { // Проверям можно свободное ли место?
                            ticTacToe[tmpY][tmpX] = 1; // Ставил нолик
                            buttons[tmpY][tmpX].setDisable(true); // Отключаем кнопку
                            b = true;
                        }
                    } while (!b); // Если b = false крутим цикл
                    clicks++; // Увеличиваем клики.
                } else { // Если кликов больше 1 то идем сюда
                    int[] winPC = needPlace(1,0);
                    if (winPC[0] != -1) {
                        ticTacToe[winPC[0]][winPC[1]] = 1; // Ставил нолик для выиграша.
                    } else {
                        flipTicTacToe();
                        int[] winPC1 = needPlace(1,0);
                        if (winPC1[0] != -1) {
                            ticTacToe[winPC1[0]][winPC1[1]] = 1; // Ставим нолик.
                            flipTicTacToe();
                            flipTicTacToe();
                            flipTicTacToe();
                        } else {
                            flipTicTacToe();
                            flipTicTacToe();
                            flipTicTacToe();
                            int[] pos = needPlace(0,1); // Ищем есть куда лучше поставить нолик что бы игрок не выиграл. Если нету такого места то в массив придет {-1,-1};
                            if (pos[0] != -1) { // Нашли место куда лучше всего ставить.
                                ticTacToe[pos[0]][pos[1]] = 1; // Ставим нолик
                                buttons[pos[0]][pos[1]].setDisable(true); // Отключаем кнопку
                            } else { // Если не нашли место куда лучше ставить, то переходим сюда
                                flipTicTacToe(); // Переварачиваем и ищем по горизонтале где игрок может выиграть.
                                int[] pos1 = needPlace(0,1);
                                if (pos1[0] != -1) {
                                    ticTacToe[pos1[0]][pos1[1]] = 9; // Ставим нолик
                                } else { // Если нету оптимального места то идем дальше.
                                    int[] unoPos = unoNeedPlace();
                                    if (unoPos[0] != -1) { // Если нашли где поставить нолик заходим в блок.
                                        ticTacToe[unoPos[0]][unoPos[1]] = 9;
                                    } else {
                                        boolean b = false;
                                        do { // Ставим в случайное место нолик.
                                            int tmpX = random.nextInt(3);
                                            int tmpY = random.nextInt(3);
                                            if (havePlace(tmpX,tmpY)) {
                                                ticTacToe[tmpY][tmpX] = 9; // Ставим рандомный нолик
                                                b = true;
                                            }
                                        } while (!b);
                                    }
                                }
                                flipTicTacToe(); // Переворачиваем массив в свое нормальное состояние.
                                flipTicTacToe();
                                flipTicTacToe();
                                // Если поставлен был нолик в перевернутом состоянии
                                for (int i = 0; i < ticTacToe.length; i++) {
                                    for (int j = 0; j < ticTacToe[i].length; j++) {
                                        if (ticTacToe[i][j] == 9) { // Ищем 9
                                            ticTacToe[i][j] = 1; // Ставим 1 та как это индификатор нолика.
                                            buttons[i][j].setDisable(true); // Так как это точные координаты нолика выключаем кнопку.
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (checkWin(1) || checkWinO(1)) {
                    disablingButtons();
                    pLose.setVisible(true);
                }
            }
        }
        showScene();
    }

    private static boolean emptyDraw() {
        for (int[] array: ticTacToe) {
            for (int i: array) {
                if (i == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean emptyPlace() {
        int a = 0;
        for (int[] array: ticTacToe) {
            for (int ints: array) {
                if (ints == -1) {
                    a++;
                }
            }
        }
        return a > 1;
    }

    private static void flipTicTacToe() { // Переворачиваем массив против часовой стрелке.
        int[][] tmpTicTacToe = copyOriginalArray();

        for(int i = 0; i < tmpTicTacToe.length; ++i) {
            for(int j = 0; j < tmpTicTacToe[i].length; ++j) {
                ticTacToe[i][j] = tmpTicTacToe[tmpTicTacToe.length - (1 + j)][i];
            }
        }
    }

    private static void disableIMG() { // Выключить изображение ноликов и крестиков
        for (ImageView[] imgA: imgO) {
            for (ImageView img: imgA) {
                img.setVisible(false);
            }
        }
        for (ImageView[] imgA: imgX) {
            for (ImageView img: imgA) {
                img.setVisible(false);
            }
        }
    }


    private static int[] unoNeedPlace() {
        int balls = 0;
        int[] cord = new int[2];
        if (ticTacToe[0][0] == 0) {
            balls++;
        } else {
            if (ticTacToe[0][0] != 1) {
                Arrays.fill(cord,0);
            } else {
                balls--;
            }
        }
        if (ticTacToe[1][1] == 0) {
            balls++;
        } else {
            if (ticTacToe[1][1] != 1) {
                Arrays.fill(cord,1);
            } else {
                balls--;
            }
        }
        if (ticTacToe[2][2] == 0) {
            balls++;
        } else {
            if (ticTacToe[2][2] != 1) {
                Arrays.fill(cord,2);
            } else { balls--; }
        }
        if (balls == 2) {
            return cord;
        } else {
            balls = 0;
            if (ticTacToe[2][0] == 0) {
                balls++;
            } else {
                if (ticTacToe[2][0] != 1) {
                    cord[0] = 2;
                    cord[1] = 0;
                } else {
                    balls--;
                }
            }
            if (ticTacToe[1][1] == 0) {
                balls++;
            } else {
                Arrays.fill(cord,1);
            }
            if (ticTacToe[0][2] == 0) {
                balls++;
            } else {
                if (ticTacToe[0][2] != 1) {
                    cord[0] = 0;
                    cord[1] = 2;
                } else {
                    balls--;
                }
            }
            if (balls == 2) {
                return cord;
            }
        }

        return new int[]{-1,-1};
    }
                                   // idx что для какого типа ищем, nIDX при встрече этого типа означает что путь заблокирован.
    private static int[] needPlace(int idx, int nIDX) { // Ищем куда поставить нолик для предовращения победы.
        for (int j = 0; j < ticTacToe.length; j++) {
            int ball = 0;
            for (int e : ticTacToe[j]) {
                if (e == idx) {
                    ball++;
                } else if (e == nIDX) { ball --; }
            }
            if (ball == 2) {
                for (int i = 0; i < ticTacToe[j].length; i++) {
                    if (ticTacToe[j][i] == -1) {
                        return new int[]{j,i};
                    }
                }
            }
        }
        return new int[]{-1,-1};
    }

    private static boolean checkWinO(int ind) {
        int balls = 0;
        if (ticTacToe[0][0] == ind) {
            balls++;
        }
        if (ticTacToe[1][1] == ind) {
            balls++;
        }
        if (ticTacToe[2][2] == ind) {
            balls++;
        }
        if (balls == 3) {
            return true;
        } else {
            balls = 0;
            if (ticTacToe[0][2] == ind) {
                balls++;
            }
            if (ticTacToe[1][1] == ind) {
                balls++;
            }
            if (ticTacToe[2][0] == ind) {
                balls++;
            }
            return balls == 3;
        }
    }

    private static boolean checkWin(int ind) {
        int ball = 0;
        for (int[] array: ticTacToe) {
            for (int ints: array) {
                if (ints==ind) {
                    ball++;
                }
            }
            if (ball == 3) {
                return true;
            }
            ball = 0;
        }
        flipTicTacToe();
        for (int[] array: ticTacToe) {
            for (int ints: array) {
                if (ints==ind) {
                    ball++;
                }
            }
            if (ball == 3) {
                flipTicTacToe();
                flipTicTacToe();
                flipTicTacToe();
                return true;
            }
            ball = 0;
        }
        flipTicTacToe();
        flipTicTacToe();
        flipTicTacToe();
        return false;
    }

    private static void disablingButtons() { // Выключаем кнопки
        for (Button[] button: buttons) {
            for (Button button1: button) {
                button1.setDisable(true);
            }
        }
    }

    private static void enablingButtons() { // Включаем кнопки.
        for (Button[] button: buttons) {
            for (Button button1: button) {
                button1.setDisable(false);
            }
        }
    }

    private static boolean havePlace(int x, int y) { // Занято ли место куда пытаемся положить нолик.
        return ticTacToe[y][x] == -1;
    }

    private static int[][] copyOriginalArray() { // Скопировать массив ТИК-ТАК-ТОЕ
        int[][] copy = new int[ticTacToe.length][ticTacToe[0].length];
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[i].length; j++) {
                copy[i][j] = ticTacToe[i][j];
            }
        }
        return copy;
    }
    private static void showScene() { // Отобразить сцену
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[i].length; j++) {
                switch (ticTacToe[i][j]) {
                    case -1:
                        break;
                    case 0:
                        imgX[i][j].setVisible(true);
                        break;
                    case 1:
                        imgO[i][j].setVisible(true);
                        break;
                }
            }
        }
    }
}

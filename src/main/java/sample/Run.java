package sample;

import java.io.*;

public class Run {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            Main.main(args); // Запускам поток Main;
        }, "fx"
        ).start();
    }
}
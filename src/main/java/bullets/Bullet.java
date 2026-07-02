package bullets;

import java.io.IOException;

public interface Bullet {
    String getName();
    String getDescription();
    void shot() throws IOException;
}

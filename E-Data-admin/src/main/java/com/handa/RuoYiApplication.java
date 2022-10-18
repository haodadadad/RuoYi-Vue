package com.handa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +

                " ____              ____              __               \n" +
                "/\\  _`\\           /\\  _`\\           /\\ \\__            \n" +
                "\\ \\ \\L\\_\\         \\ \\ \\/\\ \\     __  \\ \\ ,_\\    __     \n" +
                " \\ \\  _\\L   _______\\ \\ \\ \\ \\  /'__`\\ \\ \\ \\/  /'__`\\   \n" +
                "  \\ \\ \\L\\ \\/\\______\\\\ \\ \\_\\ \\/\\ \\L\\.\\_\\ \\ \\_/\\ \\L\\.\\_ \n" +
                "   \\ \\____/\\/______/ \\ \\____/\\ \\__/.\\_\\\\ \\__\\ \\__/.\\_\\\n" +
                "    \\/___/            \\/___/  \\/__/\\/_/ \\/__/\\/__/\\/_/"
        );
    }
}

package github.javahengdi.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @program: hengdi-rpc
 * @description: 读取配置文件
 * @author: Jiaty
 * @create: 2021-02-27 01:48
 **/

@Slf4j
public final class PropertiesFileUtil {

    private PropertiesFileUtil() {

    }

    public static Properties readPropertiesFile(String filePath) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        String rpcConfigPath = "";
        if (url != null) {
            rpcConfigPath = url.getPath() + filePath;
        }
        Properties properties = null;
        try (InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(rpcConfigPath), StandardCharsets.UTF_8)) {
            properties = new Properties();
            properties.load(inputStreamReader);
        } catch (IOException e) {
            log.error("occur exception when read properties file:{}", filePath);
        }
        return properties;
    }


}
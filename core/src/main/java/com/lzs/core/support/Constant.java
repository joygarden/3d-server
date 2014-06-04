package com.lzs.core.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 16:33 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
public class Constant {
    private static Logger logger = LoggerFactory.getLogger(Constant.class);
    private static final String FILE = "config.properties";

    private static String savePath;

    private static String prefix;

    static {
        Properties prop = new Properties();
        InputStream in;
        try {
            in = new ClassPathResource(FILE).getInputStream();
            prop.load(in);
            in.close();
        } catch (IOException e) {
            logger.error("read file error for properties:" + FILE, e);
        }
        savePath = prop.getProperty("SAVE_PATH");
        prefix = prop.getProperty("PREFIX");
    }

    public static String getSavePath() {
        return savePath;
    }

    public static String getPrefix() {
        return prefix;
    }
}

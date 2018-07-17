package com.neuedu.tools;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;

/**
 * 自定义级别日志定义log方法
 */
public class LogUtil {

    // 自定义等级
    private static final Level CUSTOM_LEVEL = new CustomLevel(25000, "CUSTOM",
            SyslogAppender.LOG_LOCAL0);

    // 单例模式
    private static LogUtil logUtil = new LogUtil();

    private LogUtil() {
    }

    private static Logger loggerCustom = null;

    public static LogUtil getLogUtil(Object message) {
        loggerCustom = Logger.getLogger(message.toString().substring(6));
        return logUtil;
    }

    public void customLog(Object message) {
        loggerCustom.log(CUSTOM_LEVEL, message);
    }
}

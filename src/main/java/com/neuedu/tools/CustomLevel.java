package com.neuedu.tools;


import org.apache.log4j.Level;

/**
 *
 * 自定义Custom级别
 *
 */
public class CustomLevel extends Level {
    private static final long serialVersionUID = 1L;

    public CustomLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
}
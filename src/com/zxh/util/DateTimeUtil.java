package com.zxh.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("【yyyy年MM日dd日 hh点mm分ss秒】"));
    }
}

package com.open.library.log;

import android.util.Log;

import androidx.annotation.NonNull;


public class ConsolePrinter implements LogPrinter {

    @Override
    public void print(@NonNull LogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        int countOfSub = len / LogConfig.MAX_LEN;
        if (countOfSub > 0) {
            StringBuilder log = new StringBuilder();
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                log.append(printString.substring(index, index + LogConfig.MAX_LEN));
                index += LogConfig.MAX_LEN;
            }
            if (index != len) {
                log.append(printString.substring(index, len));
            }
            Log.println(level, tag, log.toString());
        } else {
            Log.println(level, tag, printString);
        }
    }
}

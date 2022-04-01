package com.open.library.log;

public class ThreadFormatter implements LogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}

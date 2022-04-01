package com.open.library.log;

public abstract class LogConfig {
    static int MAX_LEN = 512;
    static ThreadFormatter HI_THREAD_FORMATTER = new ThreadFormatter();
    static StackTraceFormatter HI_STACK_TRACE_FORMATTER = new StackTraceFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "HiLog";
    }

    public boolean enable() {
        return true;
    }

    public boolean includeThread() {
        return false;
    }

    public int stackTraceDepth() {
        return 5;
    }

    public LogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }
}

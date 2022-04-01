package com.open.library.log;

public interface LogFormatter<T> {

    String format(T data);
}
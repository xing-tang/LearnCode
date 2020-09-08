package com.open.learncode.java.泛型.java.类;


public final class TestClass<K extends String, V> {
    private K key;
    private V value;

    public TestClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

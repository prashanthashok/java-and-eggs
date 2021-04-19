package com.github.prashanthashok.spring.common.toolings.json;

public interface JsonWrapper {

    String toJson(final Object o);
    <T> T toObject(final String json, final Class<T> type);
}

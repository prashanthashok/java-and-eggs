package com.github.prashanthashok.spring.common.bootutils;

public class BaseKafkaException extends RuntimeException {
    protected BaseKafkaException(String message) {super(message);}
    protected BaseKafkaException(String message, Throwable cause) {super(message, cause);}
    protected BaseKafkaException(Throwable cause) {super(cause);}
}

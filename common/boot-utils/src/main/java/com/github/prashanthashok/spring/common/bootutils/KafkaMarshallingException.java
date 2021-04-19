package com.github.prashanthashok.spring.common.bootutils;

public class KafkaMarshallingException extends BaseKafkaException {
    KafkaMarshallingException(Exception ex) {super(ex);}
    KafkaMarshallingException(String message, Throwable cause){super(message, cause);}
}

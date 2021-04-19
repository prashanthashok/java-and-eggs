package com.github.prashanthashok.spring.common.bootutils;

public class KafkaSendingFailedException extends BaseKafkaException {
    public KafkaSendingFailedException(Exception ex) {super(ex);}
}

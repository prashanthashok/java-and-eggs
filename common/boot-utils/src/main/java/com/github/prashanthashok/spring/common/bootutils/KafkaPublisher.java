package com.github.prashanthashok.spring.common.bootutils;

import lombok.NonNull;

public interface KafkaPublisher {
    void send(@NonNull final Object msg);
}

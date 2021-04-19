package com.github.prashanthashok.spring.common.bootutils;

import com.github.prashanthashok.spring.common.toolings.json.JsonWrapper;
import com.github.prashanthashok.spring.common.toolings.json.JsonWrapperException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

import static org.apache.commons.lang.StringUtils.isBlank;

@RequiredArgsConstructor
@Slf4j
public class DefaultKafkaPublisher implements KafkaPublisher {

    @Getter
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Getter
    private final String topicName;

    @Getter
    private final JsonWrapper jsonWrapper;

    public DefaultKafkaPublisher(@NonNull final ApplicationContext applicationContext,
                                 final String topicName) {
        this.kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
        this.topicName = topicName;
        this.jsonWrapper = applicationContext.getBean(JsonWrapper.class);
    }

    @Override
    public void send(@NonNull Object msg) {
        try {
            String msgKey = "";

            String json = msg instanceof String ? (String) msg : jsonWrapper.toJson(msg);

            SendResult<String, String> result = sendMsg(msgKey, json);

            //use slf4j logger
        } catch(KafkaException ex) {
            throw new KafkaSendingFailedException(ex);
        } catch(JsonWrapperException ex) {
            throw new KafkaMarshallingException(ex);
        }
    }

    private SendResult<String, String> sendMsg(String msgKey, String json) {
        try{
            if(isBlank(topicName)) {
                ListenableFuture<SendResult<String, String>> future = msgKey != null
                        ? kafkaTemplate.sendDefault(msgKey, json)
                        : kafkaTemplate.sendDefault(json);

                return future.get();
            } else {
                ListenableFuture<SendResult<String, String>> future = msgKey != null
                        ? kafkaTemplate.send(topicName, msgKey, json)
                        : kafkaTemplate.send(topicName, json);

                return future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new KafkaSendingFailedException(e);
        }
    }
}

package ru.gxfin.common.kafka;

import lombok.Getter;
import org.apache.kafka.clients.consumer.Consumer;
import ru.gxfin.common.data.AbstractMemoryRepository;

/**
 * Описатель обработчика одной очереди.
 */
public class IncomeTopic2MemRepo {
    /**
     * Имя топика очереди.
     */
    @Getter
    private final String topic;

    /**
     * Приоритет, с которым надо обрабтавать очередь.
     * 0 - высший.
     * > 0 - менее приоритетный.
     */
    @Getter
    private final int priority;

    /**
     * Объект-получатель сообщений.
     */
    @SuppressWarnings("rawtypes")
    @Getter
    private final Consumer consumer;

    /**
     * Репозиторий, в который будут загружены входящие объекты.
     */
    @SuppressWarnings("rawtypes")
    @Getter
    private final AbstractMemoryRepository memRepo;

    /**
     * Режим данных в очереди: Пообъектно и пакетно.
     */
    @Getter
    private final TopicMessageMode messageMode;

    @SuppressWarnings("rawtypes")
    public IncomeTopic2MemRepo(String topic, int priority, Consumer consumer, AbstractMemoryRepository memRepo, TopicMessageMode messageMode) {
        this.topic = topic;
        this.priority = priority;
        this.consumer = consumer;
        this.memRepo = memRepo;
        this.messageMode = messageMode;
    }
}

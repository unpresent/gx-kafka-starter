package ru.gx.kafka.events;

import org.jetbrains.annotations.NotNull;
import ru.gx.data.DataObject;
import ru.gx.data.DataPackage;
import ru.gx.kafka.load.IncomeTopicsLoaderContinueMode;
import ru.gx.kafka.load.StandardIncomeTopicLoadingDescriptor;

import java.util.Collection;

/**
 * Интерфейс объектов-событий, которые бросаются в процессе загрузки объектов.
 * Если в загрузке участвует репозиторий, то перед сохранением в репозиторий.
 * @param <O>   Класс загружаемых объектов.
 * @param <P>   Класс пакетов загружаемых объектов.
 */
@SuppressWarnings("unused")
public interface OnObjectsLoadingFromIncomeTopicEvent<O extends DataObject, P extends DataPackage<O>> {

    /**
     * @return Получение описателя загрузки из Топика.
     */
    @NotNull
    StandardIncomeTopicLoadingDescriptor<O, P> getLoadingDescriptor();

    /**
     * @return Список объектов, которые были загружены.
     */
    @NotNull
    Collection<NewOldDataObjectsPair<O>> getChanges();

    /**
     * @return Режим продолжения обработки других Топиков.
     */
    @NotNull
    IncomeTopicsLoaderContinueMode getContinueMode();

    /**
     * Установка начальных значений перед "бросанием" события.
     * @param source                Источник события.
     * @param loadingDescriptor     Описатель загрузки из Топика.
     * @param changes               Список изменений.
     * @return                      this.
     */
    @SuppressWarnings("UnusedReturnValue")
    @NotNull
    OnObjectsLoadingFromIncomeTopicEvent<O, P> reset(@NotNull final Object source, @NotNull final StandardIncomeTopicLoadingDescriptor<O, P> loadingDescriptor, @NotNull final Collection<NewOldDataObjectsPair<O>> changes);
}

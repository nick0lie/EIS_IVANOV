package Lab3_Event.Service;

import Lab3_Event.Annotation.AddedFreightTripApplication;
import Lab3_Event.Annotation.SuspendedDriver;
import Lab3_Event.Model.*;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class DispatcherService {

    // Событие, связанное с добавлением заявки на рейс
    @Inject
    @AddedFreightTripApplication
    private Event<FreightTripApplication> tripAddedEvent;

    // Событие, связанное с отстранением водителя
    @Inject
    @SuspendedDriver
    private Event<Driver> driverSuspendedEvent;

    /**
     * Назначить рейс для водителя и автомобиля.
     *
     * @param driver     водитель, который будет выполнять рейс.
     * @param automobile автомобиль, который будет использоваться в рейсе.
     * @return объект FreightTripApplication, представляющий рейс.
     * @throws IllegalStateException если водитель отстранен от работы.
     */
    public FreightTripApplication assignTrip(Driver driver, Automobile automobile) {
        if (driver.isSuspendedFromWork()) {
            throw new IllegalStateException("Водитель отстранен от работы!");
        }
        // Создание новой заявки на рейс со статусом "CREATED"
        FreightTripApplication trip = new FreightTripApplication(driver, automobile, FreightTripStatus.CREATED);
        // Генерация события о добавлении рейса
        tripAddedEvent.fire(trip);
        return trip;
    }

    /**
     * Отстранить водителя от работы.
     *
     * @param driver водитель, который будет отстранен.
     */
    public void suspendDriver(Driver driver) {
        // Установка флага "отстранен от работы"
        driver.setSuspendedFromWork(true);
        // Генерация события об отстранении водителя
        driverSuspendedEvent.fire(driver);
    }
}

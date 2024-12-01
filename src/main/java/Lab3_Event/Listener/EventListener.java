package Lab3_Event.Listener;

import Lab3_Event.Annotation.*;
import Lab3_Event.Model.*;

import javax.enterprise.event.Observes;

public class EventListener {

    /**
     * Обработчик события добавления заявки на рейс.
     *
     * @param trip объект FreightTripApplication, связанный с добавленным рейсом.
     */
    public void onFreightTripAdded(@Observes @AddedFreightTripApplication FreightTripApplication trip) {
        System.out.println("Событие: Добавлена заявка на рейс.");
        System.out.println("Водитель: " + trip.getDriver().getName() + " " + trip.getDriver().getSurname());
        System.out.println("Автомобиль: " + trip.getAutomobile().getMark() + " " + trip.getAutomobile().getModel());
        System.out.println("Статус рейса: " + trip.getStatus());
    }

    /**
     * Обработчик события отстранения водителя.
     *
     * @param driver объект Driver, связанный с отстраненным водителем.
     */
    public void onDriverSuspended(@Observes @SuspendedDriver Driver driver) {
        System.out.println("Событие: Водитель отстранен от работы.");
        System.out.println("Водитель: " + driver.getName() + " " + driver.getSurname());
        System.out.println("Состояние: " + (driver.isSuspendedFromWork() ? "Отстранен" : "Активен"));
    }

    /**
     * Обработчик события добавления заявки на ремонт.
     *
     * @param repairApplication объект RepairApplication, связанный с заявкой на ремонт.
     */
    public void onRepairApplicationAdded(@Observes @AddedRepairApplication RepairApplication repairApplication) {
        System.out.println("Событие: Подана заявка на ремонт.");
        System.out.println("Водитель: " + repairApplication.getDriver().getName() + " " + repairApplication.getDriver().getSurname());
        System.out.println("Автомобиль: " + repairApplication.getAutomobile().getMark() + " " + repairApplication.getAutomobile().getModel());
    }

    /**
     * Обработчик события изменения статуса рейса.
     *
     * @param trip объект FreightTripApplication, связанный с измененным рейсом.
     */
    public void onFreightTripStatusEdited(@Observes @EditedFreightTripApplication FreightTripApplication trip) {
        System.out.println("Событие: Статус рейса обновлен.");
        System.out.println("Водитель: " + trip.getDriver().getName() + " " + trip.getDriver().getSurname());
        System.out.println("Автомобиль: " + trip.getAutomobile().getMark() + " " + trip.getAutomobile().getModel());
        System.out.println("Новый статус рейса: " + trip.getStatus());
    }

    /**
     * Обработчик события изменения состояния автомобиля.
     *
     * @param automobile объект Automobile, связанный с обновленным состоянием.
     */
    public void onAutomobileStatusEdited(@Observes @EditedFreightTripApplication Automobile automobile) {
        System.out.println("Событие: Состояние автомобиля обновлено.");
        System.out.println("Автомобиль: " + automobile.getMark() + " " + automobile.getModel());
        System.out.println("Новое состояние: " + automobile.getStatus());
    }
}

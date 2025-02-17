package Lab3_Event.Service;

import Lab3_Event.Annotation.AddedRepairApplication;
import Lab3_Event.Annotation.EditedAutomobileStatus;
import Lab3_Event.Annotation.EditedFreightTripApplication;
import Lab3_Event.Model.*;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class DriverService {

    @Inject
    @AddedRepairApplication
    private Event<RepairApplication> addedRepairApplicationEvent;

    @Inject
    @EditedFreightTripApplication
    private Event<FreightTripApplication> editedFreightTripApplicationEvent;

    @Inject
    @EditedAutomobileStatus
    private Event<Automobile> editedAutomobileStatusEvent;

    /**
     * Отправить заявку на ремонт.
     * @param automobile автомобиль, нуждающийся в ремонте.
     * @param driver водитель, подающий заявку.
     */
    public void submitRepairApplication(Automobile automobile, Driver driver) {
        RepairApplication repairApplication = new RepairApplication(driver, automobile);
        addedRepairApplicationEvent.fire(repairApplication); // Генерация события о создании заявки на ремонт
    }

    /**
     * Обновить статус рейса.
     * @param trip рейс, который нужно обновить.
     * @param newStatus новый статус рейса.
     */
    public void updateFreightTripStatus(FreightTripApplication trip, FreightTripStatus newStatus) {
        trip.setStatus(newStatus);
        editedFreightTripApplicationEvent.fire(trip); // Генерация события об обновлении статуса рейса
    }

    /**
     * Завершить рейс.
     * @param trip завершенный рейс.
     * @param automobile автомобиль, участвовавший в рейсе.
     * @param automobileStatus состояние автомобиля после рейса.
     */
    public void completeFreightTrip(FreightTripApplication trip, Automobile automobile, AutomobileStatus automobileStatus) {
        trip.setStatus(FreightTripStatus.FINISHED);
        editedFreightTripApplicationEvent.fire(trip); // Генерация события об обновлении рейса
        System.out.println("Рейс завершен. Состояние автомобиля: " + automobileStatus);
        // Обновляем состояние автомобиля
        automobile.setStatus(automobileStatus);
        editedAutomobileStatusEvent.fire(automobile); // Генерация события об изменении состояния автомобиля
    }
}

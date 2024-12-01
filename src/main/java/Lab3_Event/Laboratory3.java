package Lab3_Event;

import Lab3_Event.Model.*;
import Lab3_Event.Service.DispatcherService;
import Lab3_Event.Service.DriverService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory3 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) throws Exception {
        weld = new Weld();
        container = weld.initialize();

        try {
            // Получение экземпляров служб через контейнер Weld
            DispatcherService dispatcherService = container.select(DispatcherService.class).get();
            DriverService driverService = container.select(DriverService.class).get();

            // Создание тестовых данных
            Driver driver = new Driver(1, "Иван", "Иванов", false);
            Automobile automobile = new Automobile(1, "Toyota", "Corolla", AutomobileStatus.OPERATIVE);

            // 1. Добавление заявки на рейс
            FreightTripApplication trip = dispatcherService.assignTrip(driver, automobile);
            System.out.println("--------------------------------------------------------");

            // 2. Изменение статуса рейса
            driverService.updateFreightTripStatus(trip, FreightTripStatus.IN_PROGRESS);
            System.out.println("--------------------------------------------------------");

            // 3. Завершение рейса
            driverService.completeFreightTrip(trip, automobile, AutomobileStatus.INOPERATIVE);
            System.out.println("--------------------------------------------------------");

            // 4. Подача заявки на ремонт
            driverService.submitRepairApplication(automobile, driver);
            System.out.println("--------------------------------------------------------");

            // 5. Отстранение водителя
            dispatcherService.suspendDriver(driver);
            System.out.println("--------------------------------------------------------");

        } finally {
            weld.shutdown();
        }
    }
}

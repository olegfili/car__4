import transport.*;
import transport.category.DriverB;
import transport.category.DriverC;
import transport.category.DriverD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws CategoryException {
        DriverB driverB = new DriverB("Катунов Артем Викторович", true, 7, "B");
        DriverC driverC = new DriverC("Петров Виктор Юрьевич", true, 8, "C");
        DriverD driverD = new DriverD("Петров Владимир Юрьевич", true, 10, "D");

        Mechanic <Transport> mechanic1 = new Mechanic<>("Василий Крюков", "Движок");
        Mechanic <Transport> mechanic2 = new Mechanic<>("Сергей Орлов", "Авто Профи");

        Car car1 = new Car("BMW", "Х5", 3.0, TypeOfBody.SEDAN);
        System.out.println(car1);
        Car car2 = new Car("Mercedes", "E-class", 3.5, TypeOfBody.SEDAN);
        System.out.println(car2);
        Car car3 = new Car("Audi", "A4", 2.0, TypeOfBody.SEDAN);
        System.out.println(car3);
        Car car4 = new Car("Toyota", "Camry", 2.5, TypeOfBody.SEDAN);
        System.out.println(car4);

        Trucks truck1 = new Trucks("Volvo", "FH16", 12.8, Weight.N3);
        System.out.println(truck1);
        Trucks truck2 = new Trucks("Scania", "R730", 11.8, Weight.N1);
        System.out.println(truck2);
        Trucks truck3 = new Trucks("MAN", "TGH", 12.5, Weight.N2);
        System.out.println(truck3);
        Trucks truck4 = new Trucks("Iveco", "Stralis", 2.8, Weight.N1);
        System.out.println(truck4);

        Bus bus1 = new Bus("Volvo", "9700", 9.4, Capacity.MEDIUM);
        System.out.println(bus1);
        Bus bus2 = new Bus("Mercedes", "Strinter", 2.4, Capacity.SMALL);
        System.out.println(bus2);
        Bus bus3 = new Bus("MAN", "Lion's Coach", 12.4, Capacity.LARGE);
        System.out.println(bus3);
        Bus bus4 = new Bus("Iveco", "Crossway", 6.4, Capacity.EXTRA_LARGE);
        System.out.println(bus4);

        car1.printType();
        bus2.printType();
        truck4.printType();
        car3.service();
        truck4.service();
        bus1.service();
        car1.service();

        car1.setDriver(driverB);
        car2.setDriver(driverB);
        bus3.setDriver(driverD);
        printInfo(bus3);
        driverB.infoDriver();
        driverC.infoDriver();
        driverD.infoDriver();
        category(driverB, driverC, driverD);


        mechanic1.infoMechanic();



        List<Transport> raceTransport = new ArrayList<>();
        raceTransport.add(car1);
        raceTransport.add(car2);
        raceTransport.add(car3);
        raceTransport.add(car4);
        raceTransport.add(truck1);
        raceTransport.add(truck2);
        raceTransport.add(truck3);
        raceTransport.add(truck4);
        raceTransport.add(bus1);
        raceTransport.add(bus2);
        raceTransport.add(bus3);
        raceTransport.add(bus4);
        System.out.println("Участники автогонки:");
        for (Transport transport : raceTransport){
            System.out.println(transport);
        }

        mechanic1.addTransport(car1);
        mechanic1.addTransport(car2);
        mechanic1.addTransport(truck1);
        mechanic1.addTransport(bus2);
        mechanic2.addTransport(bus1);
        mechanic2.addTransport(bus3);

        mechanic1.carryOutMaintenance(car1);
        mechanic1.carryOutMaintenance(truck1);
        mechanic1.carryOutMaintenance(bus2);
        mechanic2.carryOutMaintenance(bus3);

        mechanic1.fixTheCar(car1);
        mechanic1.fixTheCar(truck1);
        mechanic1.fixTheCar(bus2);
        mechanic2.fixTheCar(bus3);

        ServiceStation <Car> carServiceStation = new ServiceStation<>();
        ServiceStation <Bus> busServiceStation = new ServiceStation<>();
        ServiceStation <Trucks> trucksServiceStation = new ServiceStation<>();
        carServiceStation.addCar(car1);
        carServiceStation.addCar(car2);
        trucksServiceStation.addCar(truck1);
        busServiceStation.addCar(bus1);
        carServiceStation.technicalInspection();
        trucksServiceStation.technicalInspection();

        car1.transportInfo();
        bus3.transportInfo();



        Set<Driver> driverSet = new HashSet<>();
        driverSet.add(driverB);
        driverSet.add(driverC);
        driverSet.add(driverD);
        driverSet.add(driverB);
        System.out.println("Список водителей:");
        for (Driver driver : driverSet){
            System.out.println(driver.getName());
        }

        System.out.println();

        System.out.println(Mechanic.getMechanicTransport());

    }

    public static void category(Driver... drivers) {
        for (Driver driver : drivers) {
            try {
                driver.setCategory("B");
            } catch (CategoryException e) {
                System.err.println("Произошла ошибка у водителя " + e.getDriver().getName());
//                System.err.println(e.getMessage());
            }
        }
    }

    public static void printInfo(Transport<?> transport) {
        if (transport.getDriver() != null) {
            System.out.println("Водитель: " + transport.getDriver().getName() + " управляет автомобилем " + transport.getBrand() + " " + transport.getModel() + " и будет участовать в заезде");
        } else {
            System.out.println("Водитель не назначен!");
        }
    }

}
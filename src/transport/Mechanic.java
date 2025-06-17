package transport;

import java.util.ArrayList;
import java.util.List;

public  class Mechanic <T extends Transport>  {

    private final String companyName;
    private final String name;
    private final List <Transport> assignedTransports;

    public Mechanic (String name, String companyName) {
        this.name = name;
        this.companyName = companyName;
        this.assignedTransports = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getName() {
        return name;
    }

    public void carryOutMaintenance (T transport) {
        if (assignedTransports.contains(transport)){
            System.out.println(getName() + " проводит тех обслуживание " + transport.getBrand()+ " " + transport.getModel());
        } else {
            System.out.println("Машина " + transport.getBrand()+ " " + transport.getModel() + " не закреплена за механиком " + getName());
        }
    }

    public void fixTheCar (T transport) {
        if (assignedTransports.contains(transport)){
            System.out.println(getName() + " необходимо починить транспорт: " + transport.getBrand()+ " " + transport.getModel());
        } else {
            System.out.println("Машина " + transport.getBrand()+ " " + transport.getModel() + " не закреплена за механиком " + getName());
        }
    }
    public void addTransport (T transport){
        assignedTransports.add(transport);
        transport.addMechanic(this);
    }

    public void infoMechanic () {
        System.out.println("Механик - " + getName() + ", работает в компании " + getCompanyName());
    }
}


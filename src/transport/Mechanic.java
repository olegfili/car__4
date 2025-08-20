package transport;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public  class Mechanic <T extends Transport>  {

    private final String companyName;
    private final String name;
    private final List <Transport> assignedTransports;

    private static Map <Transport, Set<Mechanic>> mechanicTransport = new HashMap<>();

    public static String getMechanicTransport() {
        StringBuilder builder = new StringBuilder();
        for (Entry <Transport,Set<Mechanic>> entry : mechanicTransport.entrySet()) {
            builder.append(entry.getKey().getBrand()).append(" ").append(entry.getKey().getModel()).append(" --> ");
            for (Mechanic transport : entry.getValue()){
                builder.append(transport.getName()).append(",");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(companyName, mechanic.companyName) && Objects.equals(name, mechanic.name) && Objects.equals(assignedTransports, mechanic.assignedTransports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, name, assignedTransports);
    }


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
        Set <Mechanic> mechanic = mechanicTransport.getOrDefault(transport, new HashSet<>());
        mechanic.add(this);
        mechanicTransport.put(transport,mechanic);
    }

    public void fixTheCar (T transport) {
        if (assignedTransports.contains(transport)){
            System.out.println(getName() + " необходимо починить транспорт: " + transport.getBrand()+ " " + transport.getModel());
        } else {
            System.out.println("Машина " + transport.getBrand()+ " " + transport.getModel() + " не закреплена за механиком " + getName());
        }
        Set <Mechanic> mechanic = mechanicTransport.getOrDefault(transport, new HashSet<>());
        mechanic.add(this);
        mechanicTransport.put(transport,mechanic);
    }
    public void addTransport (T transport){
        assignedTransports.add(transport);
        transport.addMechanic(this);
    }

    public void infoMechanic () {
        System.out.println("Механик - " + getName() + ", работает в компании " + getCompanyName());
    }
}


package transport;

import transport.category.DriverC;

public class Trucks extends Transport  <DriverC> {
    private Weight weight;

    public Trucks(String brand, String model, double engineVolume,  Weight weight) {
        super(brand, model, engineVolume);
        this.weight = weight;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    @Override
    public void start() {
        System.out.println("Грузовик марки " + getBrand() + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Грузовик марки " + getBrand() + " начал движение");
    }

    @Override
    public void printType() {
        if(weight== null){
            System.out.println("Данных по авто не достаточно");
        } else {
            String from = weight.getFrom()==null?"":"от " + weight.getFrom() + " ";
            String to = weight.getTo()==null?"":"от " + weight.getTo();
            System.out.println("Грузоподьемность авто:  " + from + to);
        }
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у грузовика");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 90;
        int maxBound = 140;
        int theBestTimeMin = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Лучшее время круга для грузовика в минутах " + theBestTimeMin);
    }

    @Override
    public void maxSpeed() {
        int minBound = 90;
        int maxBound = 130;
        int maxSpeed = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Максимальная скорость для грузовика " + maxSpeed);
    }

    @Override
    public void service() {
        System.out.println("Грузовой автомобиль должен пройти диагностику!");
    }
}


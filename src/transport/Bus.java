package transport;

import transport.category.DriverD;

public class Bus extends Transport<DriverD>{
    private Capacity capacity;
    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Автобус марки " + getBrand() + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Автобус марки " + getBrand() + " начал движение");
    }

    @Override
    public void printType() {
        if(capacity== null){
            System.out.println("Данных по авто не достаточно");
        } else {
            System.out.println("Вместимость автобуса: от " + capacity.getFrom() + " до " + capacity.getTo());
        }
    }


    @Override
    public void pitStop() {
        System.out.println("Пит-стоп у автобуса");
    }

    @Override
    public void theBestCircleTime() {
        int minBound = 100;
        int maxBound = 150;
        int theBestTimeMin = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Лучшее время круга для автобуса в минутах " + theBestTimeMin);
    }

    @Override
    public void maxSpeed() {
        int minBound = 80;
        int maxBound = 120;
        int maxSpeed = (int) (minBound + (maxBound - minBound) * Math.random());
        System.out.println("Максимальная скорость для автобуса " + maxSpeed);
    }

    @Override
    public void service() {
        System.out.println("Автобус " + getBrand() + getModel()  +" не требуется в диагностике!");
    }
}

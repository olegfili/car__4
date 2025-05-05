package transport;

public abstract class Transport <T extends Driver> implements Competing {
    private String brand;
    private String model;
    private double engineVolume;
    private T driver;

    public Transport(String brand, String model, double engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
        setDriver(driver);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public abstract void start();

    public abstract void stop();

    public abstract void printType();

    public abstract void service();

    public String toString() {
        return "Марка: " + brand + ", " +
                "модель: " + model + ", " +
                "объем двигателя: " + engineVolume;
    }

}

package transport;

public class CategoryException extends Exception{
    private final Driver driver;
    public CategoryException(String message, Driver driver) {
        super(message);
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}

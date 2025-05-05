package transport.category;
import transport.CategoryException;
import transport.Driver;

public class DriverD extends Driver {
    public DriverD(String name, boolean hasDriverLicense, int experienceInYear, String category) throws CategoryException {
        super(name, hasDriverLicense, experienceInYear, category);
    }

    @Override
    public void startMove() {
        System.out.println("Водитель категории D " + getName() + " начал движение");
    }

    @Override
    public void finishMove() {
        System.out.println("Водитель категории D " + getName() + " закончил движение");
    }

    @Override
    public void refill() {
        System.out.println("Водитель категории D " + getName() + " заправляет авто");
    }

}

package transport;

import java.util.Objects;

public  abstract class Driver {
    private String name;
    private boolean hasDriverLicense;
    private int experienceInYear;
    private String category;

    public Driver(String name, boolean hasDriverLicense, int experienceInYear, String category) throws CategoryException {
        setName(name);
        setHasDriverLicense(hasDriverLicense);
        setExperienceInYear(experienceInYear);
        setCategory(category);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDriverLicense() {
        return hasDriverLicense;
    }

    public void setHasDriverLicense(boolean hasDriverLicense) {
        this.hasDriverLicense = hasDriverLicense;
    }

    public int getExperienceInYear() {
        return experienceInYear;
    }

    public void setExperienceInYear(int experienceInYear) {
        this.experienceInYear = experienceInYear;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws CategoryException {
        if (category == null || category.isBlank()) {
            throw new CategoryException("Категория водителя должна быть заполнена!", this);
        }
        if (!category.equals("B") && !category.equals("C") && !category.equals("D")) {
            throw new CategoryException("Не допустимая категория!" + category, this);
        } else {
            this.category = category;
        }
    }


    public abstract void startMove();
    public abstract void finishMove();
    public abstract void refill();
    public void infoDriver () {
        System.out.println("Водитель - " + getName() + ", лицензия - " + isHasDriverLicense() + ", стаж вождения " + getExperienceInYear() + ", категория прав - " + getCategory());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return hasDriverLicense == driver.hasDriverLicense &&
                experienceInYear == driver.experienceInYear &&
                Objects.equals(name, driver.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasDriverLicense, experienceInYear);
    }
}

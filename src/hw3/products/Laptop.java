package hw3.products;

import hw3.datastructures.BinaryTreeNode;

import java.lang.Comparable;

/**
 * TODO: The 'Laptop' object should be comparable.
 *
 * @author Ritwik Banerjee
 */
public class Laptop implements Comparable<Laptop> {

    private String brand;
    private double processorSpeed;
    private int    ram;
    private int    price;
    private double screenSize;

    private Laptop(LaptopBuilder laptopBuilder) {
        this.brand = laptopBuilder.brand;
        this.processorSpeed = laptopBuilder.processorSpeed;
        this.ram = laptopBuilder.ram;
        this.price = laptopBuilder.price;
        this.screenSize = laptopBuilder.screenSize;
    }

    /**
     * Compares the current laptop object with another laptop object by their price, in which a cheaper laptop is "greater".
     *
     * @param otherLaptop   The other laptop to be compared with
     * @return              A positive value if the current laptop is cheaper,
     *                      A negative value if the current laptop is more expensive,
     *                      0 if both laptops are equal in price.
     */
    @Override
    public int compareTo(Laptop otherLaptop) {
        // Because we want cheaper laptops to be "greater"/positive, reverse the signs.
        return -1 * (this.getPrice() - otherLaptop.getPrice());
    }

    /**
     * Checks equality between two objects, and if they are of the Laptop type, check the equality
     * of their laptop's specifications.
     *
     * @param obj The object to be checked for equality
     * @return  Whether the specified object is equal to the current object, and if they are of the Laptop type, check the equality
     *          of their laptop's specifications.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // check addresses are the same first
        Laptop that;
        if (obj instanceof Laptop) that = (Laptop) obj;
        else return false; // not even the right type so return false

        return brand.equals(that.getBrand()) &&
                processorSpeed == that.getProcessorSpeed() &&
                ram == that.getRam() &&
                price == that.getPrice() &&
                screenSize == that.getScreenSize();
    }

    public String getBrand()          { return brand; }

    public double getProcessorSpeed() { return processorSpeed; }

    public int getRam()               { return ram; }

    public int getPrice()             { return price; }

    public double getScreenSize()     { return screenSize; }

    private static class LaptopBuilder {
        private String brand;
        private double processorSpeed;
        private int    ram;
        private int    price;
        private double screenSize;

        LaptopBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        LaptopBuilder withProcessorSpeed(double processorSpeed) {
            this.processorSpeed = processorSpeed;
            return this;
        }

        LaptopBuilder withMemory(int ram) {
            this.ram = ram;
            return this;
        }

        LaptopBuilder withPrice(int price) {
            this.price = price;
            return this;
        }

        LaptopBuilder withScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        Laptop build() {
            return new Laptop(this);
        }
    }

    public static Laptop fromString(String s) {
        if (s.isEmpty())
            return null;
        String[]      aspects = s.split(",");
        LaptopBuilder builder = new LaptopBuilder();

        try {
            builder.withBrand(aspects[0].toLowerCase());
            builder.withProcessorSpeed(Double.parseDouble(aspects[1]));
            builder.withMemory(Integer.parseInt(aspects[2]));
            builder.withPrice(Integer.parseInt(aspects[3]));
            builder.withScreenSize(Double.parseDouble(aspects[4]));
        } catch (Exception e) {
            System.out.println("Invalid input line.");
        }

        return builder.build();
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override
    public String toString() {
        return "products.Laptop{" + "brand='" + brand + '\'' +
                ", processorSpeed=" + processorSpeed +
                ", ram=" + ram +
                ", price=" + price +
                ", screenSize=" + screenSize +
                '}';
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override public int hashCode() {
        int  result;
        long temp;
        result = brand.hashCode();
        temp = Double.doubleToLongBits(processorSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ram;
        result = 31 * result + price;
        temp = Double.doubleToLongBits(screenSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

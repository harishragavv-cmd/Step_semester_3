package week_7.class_problems;

public class ToyBoxDemo {
    public static void main(String[] args) {
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");

        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println(car.getToyId());
        System.out.println(robot.getToyId());

        // Toy is abstract, so "new Toy()" cannot compile.
    }
}
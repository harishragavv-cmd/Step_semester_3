package week_7.class_problems;

public class KitchenDemo {
    public static void main(String[] args) {
        Blender blender = new Blender();
        blender.setSpeedLevel(3);
        System.out.println(blender.getSpeedLevel());

        try {
            blender.setSpeedLevel(9);
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid speed rejected");
        }

        // The invalid value was rejected, so the previous speed remains 3.
        System.out.println(blender.getSpeedLevel());
        System.out.println(blender.prepare());
        System.out.println(blender.clean());
    }
}
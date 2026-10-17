package week_7.class_problems;

public class OrchestraDemo {
    public static void main(String[] args) {
        StringInstrument strings = new StringInstrument();
        Violin violin = new Violin();

        System.out.println(strings.play());
        System.out.println(violin.play());
    }
}
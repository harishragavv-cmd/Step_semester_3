package week_7.class_problems;

public class StringInstrument extends Instrument {
    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return super.baseRoutine() + "Strumming the strings";
    }
}
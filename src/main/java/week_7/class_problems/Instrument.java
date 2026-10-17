package week_7.class_problems;

public abstract class Instrument {
    public abstract String play();

    // Shared concrete behavior, since an abstract play() cannot be called via super.play().
    protected String baseRoutine() {
        return "";
    }
}
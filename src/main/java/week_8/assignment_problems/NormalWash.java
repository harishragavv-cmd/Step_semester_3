package week_8.assignment_problems;

public class NormalWash implements WashType {
    public String getName() { return "Normal"; }
    public int getDurationMinutes() { return 45; }
    public double getCharge() { return 30.0; }
}
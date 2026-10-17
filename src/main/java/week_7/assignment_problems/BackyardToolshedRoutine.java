package week_7.assignment_problems;

public class BackyardToolshedRoutine {
    public static void main(String[] args) {
        CuttingTool cuttingTool = new CuttingTool();
        Pruner pruner = new Pruner();

        System.out.println(cuttingTool.use());
        System.out.println(pruner.use());
    }
}
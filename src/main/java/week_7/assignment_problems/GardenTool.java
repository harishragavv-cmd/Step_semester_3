package week_7.assignment_problems;

/*
 * The worksheet asks use() to be abstract and also asks CuttingTool.use()
 * to call super.use(). Java does not allow invoking an abstract superclass
 * method with super.use(). This concrete base implementation keeps the
 * required three-level design compilable and supplies the common routine.
 */
public abstract class GardenTool {
    public GardenTool() {
        super();
    }

    public String use() {
        return "Using the tool in the garden";
    }
}
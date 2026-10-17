package week_7.class_problems;

public class LabelPrinter {
    public static void printAll(Printable[] items) {
        if (items == null) {
            return;
        }

        for (Printable item : items) {
            if (item != null) {
                System.out.println(item.printLabel());
            }
        }
    }

    public static void main(String[] args) {
        PackageBox box = new PackageBox("TRK-88");
        Invoice invoice = new Invoice("INV-42");

        System.out.println(box.printLabel());
        System.out.println(invoice.printLabel());
        printAll(new Printable[]{box, invoice});
    }
}
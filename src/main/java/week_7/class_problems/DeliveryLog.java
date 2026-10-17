package week_7.class_problems;

public class DeliveryLog {
    public static void logAll(DeliveryNote[] notes) {
        if (notes == null) {
            return;
        }

        for (DeliveryNote note : notes) {
            if (note != null) {
                System.out.println(note.confirmDelivery());
            }
        }
    }

    public static void main(String[] args) {
        ParcelNote parcel = new ParcelNote("TRK-1");
        LetterNote letter = new LetterNote("TRK-2");

        System.out.println(parcel.confirmDelivery());
        System.out.println(parcel.confirmDelivery("J. Smith"));

        DeliveryNote reference = parcel; // Upcasting.
        logAll(new DeliveryNote[]{reference, letter});
    }
}
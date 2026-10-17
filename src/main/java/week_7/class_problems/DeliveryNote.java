package week_7.class_problems;

public abstract class DeliveryNote {
    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        String message = confirmDelivery();

        if (signature == null || signature.trim().isEmpty()) {
            return message;
        }

        return message + ", signed by " + signature;
    }
}
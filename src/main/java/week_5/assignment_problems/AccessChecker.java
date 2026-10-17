package week_5.assignment_problems;

public class AccessChecker {

    private static boolean isKnownContext(String context) {
        return "SAME_CLASS".equals(context)
                || "SAME_PACKAGE".equals(context)
                || "DIFFERENT_PACKAGE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(context);
    }

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || !isKnownContext(accessorContext)) {
            return "DENIED";
        }

        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }

        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }

        if ("default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext)
                    || "SAME_PACKAGE".equals(accessorContext))
                    ? "ALLOWED" : "DENIED";
        }

        if ("protected".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext)
                    || "SAME_PACKAGE".equals(accessorContext)
                    || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext))
                    ? "ALLOWED" : "DENIED";
        }

        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2
                        && "ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed++;
                } else {
                    denied++;
                }
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(attempts));
        System.out.println(classifyAccess("protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
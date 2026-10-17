package week_5.assignment_problems;

public class AccessChecker {
    private static final String[] MODIFIERS = {
        "private", "default", "protected", "public"
    };

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (!isKnownContext(accessorContext)) {
            return "DENIED";
        }

        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }

        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }

        if ("default".equals(fieldModifier)) {
            return isSameClassOrPackage(accessorContext) ? "ALLOWED" : "DENIED";
        }

        if ("protected".equals(fieldModifier)) {
            boolean allowed = isSameClassOrPackage(accessorContext)
                    || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext);
            return allowed ? "ALLOWED" : "DENIED";
        }

        return "DENIED";
    }

    private static boolean isSameClassOrPackage(String context) {
        return "SAME_CLASS".equals(context) || "SAME_PACKAGE".equals(context);
    }

    private static boolean isKnownContext(String context) {
        return "SAME_CLASS".equals(context)
                || "SAME_PACKAGE".equals(context)
                || "DIFFERENT_PACKAGE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(context);
    }

    public static String summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[MODIFIERS.length];
        int[] denied = new int[MODIFIERS.length];

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) {
                    continue;
                }

                int modifierIndex = getModifierIndex(attempt[0]);
                if (modifierIndex == -1) {
                    continue;
                }

                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed[modifierIndex]++;
                } else {
                    denied[modifierIndex]++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(MODIFIERS[i])
                  .append(": ")
                  .append(allowed[i])
                  .append(" allowed / ")
                  .append(denied[i])
                  .append(" denied");
        }
        return result.toString();
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            String[] attempt = attempts[i];
            if (attempt == null || attempt.length < 2) {
                continue;
            }

            if ("DENIED".equals(classifyAccess(attempt[0], attempt[1]))) {
                return attempt[0] + " via " + attempt[1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    private static int getModifierIndex(String modifier) {
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (MODIFIERS[i].equals(modifier)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[][] summaryAttempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(summaryAttempts));

        String[][] orderedAttempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(orderedAttempts));
    }
}
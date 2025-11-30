
package org.example;

import java.util.function.Supplier;

public final class Assert {
    private Assert() {}

    public static void assertEventually(String message, Supplier<Boolean> condition, int retries, long sleepMs) {
        AssertionError last = null;
        for (int i = 0; i < retries; i++) {
            try {
                if (Boolean.TRUE.equals(condition.get())) return;
                Thread.sleep(sleepMs);
            } catch (AssertionError e) {
                last = e;
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
        if (last != null) throw last;
        throw new AssertionError(message);
    }
}

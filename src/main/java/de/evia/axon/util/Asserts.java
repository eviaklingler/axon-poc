package de.evia.axon.util;

public final class Asserts {

    private Asserts() {

    }

    public static void isNotNull(Object object, String objectName) {
        if (object == null) {
            throw new IllegalArgumentException("'" + objectName + "'" + "must not be null!");
        }
    }

}

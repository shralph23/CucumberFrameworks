package com.freddiemac.datamanager.ws.srs.enums;

public enum FMIndicator {

    /**
     * False
     * 
     */
    FALSE("false"),

    /**
     * No
     * 
     */
    N("N"),

    /**
     * True
     * 
     */
    TRUE("true"),

    /**
     * Yes
     * 
     */
    Y("Y");
    private final String value;

    FMIndicator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FMIndicator fromValue(String v) {
        for (FMIndicator c: FMIndicator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

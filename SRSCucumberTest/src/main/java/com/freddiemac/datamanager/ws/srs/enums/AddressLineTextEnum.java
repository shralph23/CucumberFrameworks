package com.freddiemac.datamanager.ws.srs.enums;


public enum AddressLineTextEnum {
    
    PREAPPROVALST_0000("0000 PREAPPROVAL ST"),
    PREAPPROVALSTREET_0000("0000 PREAPPROVAL STREET"),
    TBD_1("1 TBD"),
    TO_BE_DETERMINED1("1 TO BE DETERMINED"),
    MAIN_ST_123("123 MAIN ST"),
    E_MAIN_ST_123("123 E MAIN ST"),
    MAIN_123_("123 MAIN"),
    MAIN_STREET_123("123 MAIN STREET"),
    N_MAIN_ST("123 N MAIN ST"),
    PRE_APPROVAL_123("123 PRE-APPROVAL"),
    S_MAIN_ST_123("123 S MAIN ST"),
    STREET_123("123 STREET"),
    TBD_123("123 TBD"),
    TBD_ST_123("123 TBD ST"),
    TBD_STREET_123("123 TBD STREET"),
    UNKNOWN_123("123 UNKNOWN"),
    W_MAIN_ST_123("123 W MAIN ST"),
    MAIN_ST_1234("1234 MAIN ST"),
    TBD_1234("1234 TBD"),
    TBD_555("555 TBD"),
    N_PROPERTY("N PROPERTY"),
    N_PROPERTY_ADDRESS("N PROPERTY ADDRESS"),
    N_A("N/A"),
    NO_PROPERTY("NO PROPERTY"),
    NO_PROPERTY_ADDRESS("NO PROPERTY ADDRESS"),
    PRE_APPROVAL("PRE APPROVAL"),
    PREAPPROVAL("PREAPPROVAL"),
    PRE_APPROVAL2("PRE-APPROVAL"),
    PREQUAL("PREQUAL"),
    PRE_QUAL("PRE-QUAL"),
    PREQUAL_ONLY("PREQUAL ONLY"),
    PREQUALIFICATION("PREQUALIFICATION"),
    SEE_ATTACHED_EXHIBIT_A("SEE ATTACHED EXHIBIT A"),
    TBA("TBA"),
    TBD("TBD"),
    TBD_STREET("TBD STREET"),
    TBD_TBD("TBD TBD"),
    TO_BE_DETERMINED("TO BE DETERMINED"),
    UNKNOWN("UNKNOWN") ;

    private final String addressLineText;

    /**
     * @param text
     */
    private AddressLineTextEnum(final String addressLineText) {
        this.addressLineText = addressLineText;
    }

    /**
     * Gets the string representation of the element
     *
     * @return {@link String} Name of the browser type
     */
    @Override
    public String toString() {
        return addressLineText;
    }

    public static boolean contains(String addressLineText) {
        for (AddressLineTextEnum c : AddressLineTextEnum.values()) {
            if (c.toString().equals(addressLineText)) {
                return true;
            }
        }
        return false;
    }
}

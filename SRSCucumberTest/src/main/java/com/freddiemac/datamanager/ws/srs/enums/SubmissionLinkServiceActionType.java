package com.freddiemac.datamanager.ws.srs.enums;

public enum SubmissionLinkServiceActionType {

    NEW,
    EXIST_NO_CHANGE,
    EXIST_AND_UPDATE,
    FOUND,
    NOT_FOUND,
    ERROR;

    public String value() {
        return name();
    }

    public static SubmissionLinkServiceActionType fromValue(String v) {
        return valueOf(v);
    }

}

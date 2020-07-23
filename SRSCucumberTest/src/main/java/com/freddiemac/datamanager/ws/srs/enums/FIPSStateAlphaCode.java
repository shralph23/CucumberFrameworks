package com.freddiemac.datamanager.ws.srs.enums;

public enum FIPSStateAlphaCode {

    /**
     * ALASKA
     * 
     */
    AK,

    /**
     * ALABAMA
     * 
     */
    AL,

    /**
     * ARKANSAS
     * 
     */
    AR,

    /**
     * AMERICAN SAMOA
     * 
     */
    AS,

    /**
     * ARIZONA
     * 
     */
    AZ,

    /**
     * CALIFORNIA
     * 
     */
    CA,

    /**
     * COLORADO
     * 
     */
    CO,

    /**
     * CONNECTICUT
     * 
     */
    CT,

    /**
     * DISTRICT OF COLUMBIA
     * 
     */
    DC,

    /**
     * DELAWARE
     * 
     */
    DE,

    /**
     * FLORIDA
     * 
     */
    FL,

    /**
     * GEORGIA
     * 
     */
    GA,

    /**
     * GUAM
     * 
     */
    GU,

    /**
     * HAWAII
     * 
     */
    HI,

    /**
     * IOWA
     * 
     */
    IA,

    /**
     * IDAHO
     * 
     */
    ID,

    /**
     * ILLINOIS
     * 
     */
    IL,

    /**
     * INDIANA
     * 
     */
    IN,

    /**
     * KANSAS
     * 
     */
    KS,

    /**
     * KENTUCKY
     * 
     */
    KY,

    /**
     * LOUISIANA
     * 
     */
    LA,

    /**
     * MASSACHUSETTS
     * 
     */
    MA,

    /**
     * MARYLAND
     * 
     */
    MD,

    /**
     * MAINE
     * 
     */
    ME,

    /**
     * MICHIGAN
     * 
     */
    MI,

    /**
     * MINNESOTA
     * 
     */
    MN,

    /**
     * MISSOURI
     * 
     */
    MO,

    /**
     * MISSISSIPPI
     * 
     */
    MS,

    /**
     * MONTANA
     * 
     */
    MT,

    /**
     * NORTH CAROLINA
     * 
     */
    NC,

    /**
     * NORTH DAKOTA
     * 
     */
    ND,

    /**
     * NEBRASKA
     * 
     */
    NE,

    /**
     * NEW HAMPSHIRE
     * 
     */
    NH,

    /**
     * NEW JERSEY
     * 
     */
    NJ,

    /**
     * NEW MEXICO
     * 
     */
    NM,

    /**
     * NEVADA
     * 
     */
    NV,

    /**
     * NEW YORK
     * 
     */
    NY,

    /**
     * OHIO
     * 
     */
    OH,

    /**
     * OKLAHOMA
     * 
     */
    OK,

    /**
     * OREGON
     * 
     */
    OR,

    /**
     * PENNSYLVANIA
     * 
     */
    PA,

    /**
     * PUERTO RICO
     * 
     */
    PR,

    /**
     * RHODE ISLAND
     * 
     */
    RI,

    /**
     * SOUTH CAROLINA
     * 
     */
    SC,

    /**
     * SOUTH DAKOTA
     * 
     */
    SD,

    /**
     * TENNESSEE
     * 
     */
    TN,

    /**
     * TEXAS
     * 
     */
    TX,

    /**
     * UTAH
     * 
     */
    UT,

    /**
     * VIRGINIA
     * 
     */
    VA,

    /**
     * VIRGIN ISLANDS
     * 
     */
    VI,

    /**
     * VERMONT
     * 
     */
    VT,

    /**
     * WASHINGTON
     * 
     */
    WA,

    /**
     * WISCONSIN
     * 
     */
    WI,

    /**
     * WEST VIRGINIA
     * 
     */
    WV,

    /**
     * WYOMING
     * 
     */
    WY,

    /**
     * Federated States of Micronesia
     * 
     */
    FM,

    /**
     * Marshall Islands
     * 
     */
    MH,

    /**
     * Northern Mariana Islands
     * 
     */
    MP,

    /**
     * Palau 
     * 
     */
    PW,

    /**
     * US Minor Outlying Islands 
     * 
     */
    UM,

    /**
     * Armed Forces Americas
     * 
     */
    AA,

    /**
     * Armed Forces Canada, Armed Forces Africa, Armed
     * 						Forces Europe, Armed Forces Middle East
     * 
     */
    AE,

    /**
     * Armed Forces Pacific
     * 
     */
    AP,

    /**
     * Alberta
     * 
     */
    AB,

    /**
     * British Columbia
     * 
     */
    BC,

    /**
     * Manitoba
     * 
     */
    MB,

    /**
     * New Brunswick
     * 
     */
    NB,

    /**
     * Newfoundland and Labrador
     * 
     */
    NL,

    /**
     * Northwest Territories
     * 
     */
    NT,

    /**
     * Nova Scotia
     * 
     */
    NS,

    /**
     * Nunavut
     * 
     */
    NU,

    /**
     * Ontario
     * 
     */
    ON,

    /**
     * Prince Edward Island
     * 
     */
    PE,

    /**
     * Quebec
     * 
     */
    QC,

    /**
     * Saskatchewan
     * 
     */
    SK,

    /**
     * Yukon
     * 
     */
    YT;

    public String value() {
        return name();
    }

    public static FIPSStateAlphaCode fromValue(String v) {
        return valueOf(v);
    }

}

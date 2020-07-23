package com.freddiemac.datamanager.ws.srs.enums;

public enum LoanIdentifierType {


    /**
     * An identifier assigned by a government agency (for example FHA Case Number, VA Case Number). The identifier is used by the agency to identify a loan.
     * 
     */
    AGENCY_CASE("AgencyCase"),

    /**
     * A unique identifier assigned to a document file associated with the loan.
     * 
     */
    DOCUMENT_FILE("DocumentFile"),

    /**
     * A unique identifier assigned by the Freddie Mac Legacy Midas System to the loan.
     * 
     */
    FREDDIE_MAC_LOAN("FreddieMacLoan"),

    /**
     * A unique identifier assigned by the Greater Purchase Certainty to the loan.
     * 
     */
    GREATER_PURCHASE_CERTAINTY("GreaterPurchaseCertainty"),

    /**
     * The 9 digit transaction identifier that is used in CDW and other external processing of the HP data.
     * 
     */
    HEWLETT_PACKARD_GENERATED_TRANSACTION("HewlettPackardGeneratedTransaction"),

    /**
     * The 8-digit generated HP Transaction Number used for Loan Prospector internal processing.
     * 
     */
    HEWLETT_PACKARD_LOAN_PROSPECTOR_TRANSACTION("HewlettPackardLoanProspectorTransaction"),

    /**
     * The unique identifier of the commitment that states the terms under which a loan seller and an investor agree to exchange loans for funds, securities, or other assets.
     * 
     */
    INVESTOR_COMMITMENT("InvestorCommitment"),

    /**
     * A unique identifier for a group of loans identified as part of a cash pool or a security pool.
     * 
     */
    INVESTOR_CONTRACT("InvestorContract"),

    /**
     * Account number assigned by the investor used for tracking on the investors systems.
     * 
     */
    INVESTOR_LOAN("InvestorLoan"),

    /**
     * A unique identifier of a workout assigned by the investor associated with a loan that has been evaluated for a workout.
     * 
     */
    INVESTOR_WORKOUT_CASE("InvestorWorkoutCase"),

    /**
     * Number used by the Lender to identify a loan.
     * 
     */
    LENDER_CASE("LenderCase"),

    /**
     * The identifier assigned by the originating Lender to be referenced as the Loan ID/Number on all settlement documents, notes, riders, etc.
     * 
     */
    LENDER_LOAN("LenderLoan"),

    /**
     * A unique identifier assigned by the Loan Closing Advisor to the loan.
     * 
     */
    LOAN_CLOSING_ADVISOR("LoanClosingAdvisor"),

    /**
     * The identifier assigned by the Loan Collateral Advisor application to identify a Loan.
     * 
     */
    LOAN_COLLATERAL_ADVISOR("LoanCollateralAdvisor"),

    /**
     * The identifier assigned by the Loan Coverage Advisor application to identify a Loan.
     * 
     */
    LOAN_COVERAGE_ADVISOR("LoanCoverageAdvisor"),

    /**
     * A unique identifier assigned by the Loan Identity Service to the loan.
     * 
     */
    LOAN_IDENTITY_SERVICE("LoanIdentityService"),

    /**
     * A unique identifier assigned to a loan by a Loan Origination System (LOS).
     * 
     */
    LOAN_ORIGINATION_SYSTEM_LOAN("LoanOriginationSystemLoan"),

    /**
     * A unique identifier for a loan price quote, assigned by the party that makes the price quote for tracking purposes.
     * 
     */
    LOAN_PRICE_QUOTE("LoanPriceQuote"),

    /**
     * The number used by Freddie Macs Loan Prospector (AUS) to track the loan throughout its LP life.  Assigned by Freddie Mac the first time a loan is successfully evaluated by LP and returned in the LP Response file as part of the Full Feedback Certificate.  This can also be returned with a successful credit preview request.
     * 
     */
    LOAN_PROSPECTOR_KEY("LoanProspectorKey"),

    /**
     * A unique number assigned to a loan by LP each time the loan is submitted for assessment. Use this number to identify the transaction when you contact Freddie Mac Customer Service.  The identifier is assigned by the Online New Account Control System (OLNACS), the Loan Prospector credit engine, to uniquely identify a Loan Prospector Transaction submitting loan data for evaluation.
     * 
     */
    LOAN_PROSPECTOR_TRANSACTION("LoanProspectorTransaction"),

    /**
     * The unique identifier used for the loan throughout its duration in LP. It is available the first time a loan is imported or manually entered into LP.  The identifier will be returned in the LP Response file.
     * 
     */
    LOAN_PROSPECTOR_UNIQUE_LOAN("LoanProspectorUniqueLoan"),

    /**
     * The identifier assigned by the Loan Quality Advisor application to identify a Loan.
     * 
     */
    LOAN_QUALITY_ADVISOR("LoanQualityAdvisor"),

    /**
     * A unique system assigned number that is used to identify the Loan.
     * 
     */
    LOAN_SYSTEM_GENERATED("LoanSystemGenerated"),

    /**
     * A unique identifier assigned by the Loan Underwriting Case to the loan.
     * 
     */
    LOAN_UNDERWRITING_CASE("LoanUnderwritingCase"),

    /**
     * Number used by MERS to identify loans. Referred to as the MIN, Mortgage Identification Number.
     * 
     */
    MERS_MIN("MERS_MIN"),

    /**
     * A unique identifier for a MI rate quote, assigned by the party that makes the rate quote, used to track or refer to the rate quote.
     * 
     */
    MI_RATE_QUOTE("MIRateQuote"),

    /**
     * Account number assigned by the servicer used for tracking on the servicer systems. For servicing transfer purposes the servicer would be the Transferee.
     * 
     */
    NEW_SERVICER_LOAN("NewServicerLoan"),

    /**
     * Other
     * 
     */
    OTHER("Other"),

    /**
     * The identifier assigned by the PE Selling System application to identify a Loan.
     * 
     */
    PE_SELLING_SYSTEM_LOAN("PESellingSystemLoan"),

    /**
     * A unique identifier assigned by the Pool Issuer
     * 
     */
    POOL_ISSUER_LOAN("PoolIssuerLoan"),

    /**
     * A unique identifier for a price response, assigned by the responder, used to track or refer to the price response.
     * 
     */
    PRICE_RESPONSE("PriceResponse"),

    /**
     * The number used to uniquely identify a Loan that is assigned by Loan Bureau.
     * 
     */
    PRIMARY_MARKET_LOAN("PrimaryMarketLoan"),

    /**
     * A unique identifier assigned by the seller to the loan.
     * 
     */
    SELLER_LOAN("SellerLoan"),

    /**
     * A unique identifier assigned by the servicer to identify the loan. For servicing transfer purposes the servicer would be the Transferor.
     * 
     */
    SERVICER_LOAN("ServicerLoan"),

    /**
     * A unique identifier of a workout assigned by the servicer associated with a loan that has been evaluated for a workout.
     * 
     */
    SERVICER_WORKOUT_CASE("ServicerWorkoutCase"),

    /**
     * Submission Link Service (Formerly known as Loan Identity Service)
     * 
     */
    SUBMISSION_LINK_SERVICE("SubmissionLinkService"),

    /**
     * A unique identifier assigned by the Subservicer to the loan.
     * 
     */
    SUBSERVICER_LOAN("SubservicerLoan"),

    /**
     * A unique identifier associated with the loan throughout the life of the loan transaction starting at submission of the loan application (aka Universal Loan Identifier).
     * 
     */
    UNIVERSAL_LOAN("UniversalLoan"),

    /**
     * A tracking number assigned by the wholesale lender to identify the loan for pipeline management.
     * 
     */
    WHOLESALE_LENDER_LOAN("WholesaleLenderLoan");
    private final String value;

    LoanIdentifierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LoanIdentifierType fromValue(String v) {
        for (LoanIdentifierType c: LoanIdentifierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

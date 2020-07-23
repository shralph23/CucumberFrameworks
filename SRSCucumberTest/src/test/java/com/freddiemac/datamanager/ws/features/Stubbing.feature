@local @dev @dev2 @sitint
Feature: SRS stubbing.

  Scenario Outline: Send request to SRS webservice to validate Stubbing
    Given a request for srs webservice for scenario <scenarioid> and testID <id>
    And RequestSourceSystem as <rqstsrcsyst> for SRS
    And SubmittingSourceSystem as <submsrcsyst> for SRS
    And AppraisalIdentifier as <docfileid> for SRS
    And AutomatedUnderwritingSystemType as <austype> for SRS
    And LoanUnderwritingCaseIdentifier as <ausid> for SRS
    And MersminIdentifier as <mersminid> for SRS
    And PartyIdentifier as <partyid> for SRS
    And PartyRoleType as <partyRoleType> for SRS
    And LenderLoanIdentifier as <lenderlnid> for SRS
    And TaxpayerIdentificationNumbers as <ssn> for SRS
    And AddressLineText as <addressLineText> for SRS
    And StreetPrimaryNumberText as <streetPrimaryNumberText> for SRS
    And StreetName as <streetName> for SRS
    And CityName as <cityName> for SRS
    And FipsStateAlphaCode as <FipsStateAlphaCode> for SRS
    And PostalCode as <postalcode> for SRS
    And ZipPlusFourCode as <zipplusFourCode> for SRS
    Then the request is sent and the response is received from SRS webservice
    Then validate the SRS decision as <srsAction>
    Then validate the stubbed slid from SRS response

    Examples: 
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid | austype          | ausid | mersminid     | partyid  | partyRoleType         | lenderlnid | ssn          | addressLineText   | streetPrimaryNumberText | streetName | cityName   | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction |
      |  1 |          1 | "LPA"       | "Selling"   | "391"     | "LoanProspector" | "q"   | "38110123985" | "000601" | "CorrespondentLender" | "Ln381104" | "3333381194" | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"   |

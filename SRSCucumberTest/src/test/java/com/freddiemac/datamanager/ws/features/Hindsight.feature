@local @dev @dev2 @sitint
Feature: SRS webservice - Hindsight Test

  Scenario Outline: Send request to sls webservice and trigger Hindsight
    Given a request for sls webservice for scenarioID <scenarioid> and testID <id>
    And set correlation identifier for SLS
    And source system as <srcsystem> for SLS
    And appraisal identifier as <docfileid> for SLS
    And automated underwriting system type as <austype> for SLS
    And loan underwriting case identifier as <ausid> for SLS
    And MERSMIN identifier as <mersminid> for SLS
    And party identifier as <partyid> for SLS
    And Party Role Type as <partyRoleType> for SLS
    And lender loan identifier as <lenderlnid> for SLS
    And tax payer identification numbers as <ssn> for SLS
    And address line text as <addressLineText> for SLS
    And street name as <streetName> for SLS
    And city name as <cityName> for SLS
    And state code as <statecode> for SLS
    And postal code as <postalcode> for SLS
    Then the request is sent and response is received from SLS
    Then validate the SLS decision as <slsAction>

    Examples: 
      | id | scenarioid | srcsystem | docfileid | austype          | ausid | mersminid | partyid | partyRoleType | lenderlnid | ssn          | addressLineText   | streetName | cityName   | statecode | postalcode | slsAction         |
      |  1 |          1 | "LPA"     | ""        | "LoanProspector" | "q"   | ""        | ""      | ""            | ""         | "3333381194" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"             |
      |  2 |          1 | "LPA"     | "267"     | ""               | ""    | ""        | ""      | ""            | ""         | "3333381194" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"             |
      #HindsightTriggered
      |  1 |          2 | "LPA"     | ""        | "LoanProspector" | "q"   | ""        | ""      | ""            | ""         | "8585874835" | "2405 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"             |
      |  2 |          2 | "LPA"     | "299"     | ""               | ""    | ""        | ""      | ""            | ""         | "8585874835" | "2405 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"             |
      |  3 |          2 | "LPA"     | "299"     | "LoanProspector" | "q"   | ""        | ""      | ""            | ""         | "8585874835" | "2405 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "EXIST_NO_CHANGE" |

  Scenario Outline: Send request to SRS webservice to validate Hindsight is not applied
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
    Then setup request data for SLMS call
    Then the request is sent and response is received from SLMS webservice
    Then validate SRS service decision with SLMS
    Then validate the SRS decision as <srsAction>
    Then validate SRS is fetching the correct SLID from DB

    Examples: 
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid | austype          | ausid | mersminid | partyid | partyRoleType | lenderlnid | ssn          | addressLineText   | streetPrimaryNumberText | streetName | cityName   | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction |
      #HindsightTriggeringScenario
      |  1 |          1 | "LPA"       | "LPA"       | "267"     | "LoanProspector" | "q"   | ""        | ""      | ""            | ""         | "3333381194" | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"   |
      #SRSshouldpickcorrectrecordafterHindsightBySLS
      |  1 |          2 | "LPA"       | "LPA"       | "299"     | "LoanProspector" | "q"   | ""        | ""      | ""            | ""         | "8585874835" | "2405 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"   |

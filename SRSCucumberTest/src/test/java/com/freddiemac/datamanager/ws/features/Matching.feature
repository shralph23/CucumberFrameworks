@local @dev @dev2 @sitint
Feature: SRS webservice - Matching logic

  Scenario Outline: Send request to sls webservice to validate match logic
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
      | id | scenarioid | srcsystem                     | docfileid | austype               | ausid  | mersminid       | partyid | partyRoleType         | lenderlnid | ssn         | addressLineText   | streetName | cityName   | statecode | postalcode | slsAction |
      #1key,4AddressFieldsandSSNMatch->LCLA
      |  1 |          1 | "LoanClosingAdvisor-SOURCING" | "111"     | ""                    | ""     | ""              | ""      | ""                    | ""         | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  2 |          2 | "LoanClosingAdvisor-SOURCING" | ""        | ""                    | ""     | "  12278555582" | ""      | ""                    | ""         | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      #2key,2AddressFieldsandSSNMatch->LCLA
      |  3 |          3 | "LoanClosingAdvisor-SOURCING" | ""        | "LoanProspector"      | "q"    | "13254985582"   | ""      | ""                    | ""         | "845715522" | "4444 38110Pr dr" | "ford"     | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  4 |          4 | "LoanClosingAdvisor-SOURCING" | ""        | ""                    | ""     | "13263585582"   | "00765" | "CorrespondentLender" | "Ln236104" | "845715522" | "4444 38110Pr dr" | "ford"     | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      #1key,2AddressFieldsandSSNMatch->LQA
      |  5 |          5 | "LQA"                         | ""        | "DesktopUnderwriter"  | "thg"  | ""              | ""      | ""                    | ""         | "555524834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      #2key,2AddressFieldsandSSNMatch->LQA
      |  6 |          6 | "LQA"                         | ""        | " DesktopUnderwriter" | " ghf" | "13254985582"   | ""      | ""                    | ""         | "995715522" | "4444 38110Pr dr" | "ford"     | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      #LPkeyandSSNMatch->LPA
      |  7 |          7 | "LPA"                         | ""        | "LoanProspector"      | "f"    | ""              | ""      | ""                    | ""         | "995715522" | ""                | ""         | ""         | "NY"      | ""         | "NEW"     |
      #1key,4AddressFieldsandSSNMatch->Selling
      |  8 |          8 | "Selling"                     | "111"     | ""                    | ""     | ""              | ""      | ""                    | ""         | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |

  Scenario Outline: Send request to SRS webservice to validate matching logic
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

    Examples: 
      | id | scenarioid | rqstsrcsyst                   | submsrcsyst | docfileid | austype                   | ausid    | mersminid     | partyid | partyRoleType         | lenderlnid | ssn              | addressLineText   | streetPrimaryNumberText | streetName | cityName   | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction   |
      #1key,4AddressFieldsandSSNMatch->LCLA
      |  1 |          1 | "LoanClosingAdvisor-SOURCING" | "LPA"       | "111"     | ""                        | ""       | ""            | ""      | ""                    | ""         | "111124834"      | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  2 |          2 | "LoanClosingAdvisor-SOURCING" | "LPA"       | ""        | ""                        | ""       | "12278555582" | ""      | ""                    | ""         | "111124834"      | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #2key,2AddressFieldsandSSNMatch->LCLA
      |  3 |          3 | "LoanClosingAdvisor-SOURCING" | "LPA"       | ""        | "LoanProspector"          | "q"      | "13254985582" | ""      | ""                    | ""         | "845715522"      | "4444 38110Pr dr" | "44"                    | "bedford"  | "Reston"   | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  4 |          4 | "RWAPP"                       | "LPA"       | ""        | ""                        | ""       | "13263585582" | "00765" | "CorrespondentLender" | "Ln236104" | "   845715522  " | "4444 38110Pr dr" | "44"                    | "bedford"  | "Reston"   | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #2key,4AddressFieldsandSSNNotMatch->LCLA
      |  5 |          4 | "RWAPP"                       | "LPA"       | ""        | ""                        | ""       | "13263585582" | "00765" | "CorrespondentLender" | "Ln236104" | "995715522"      | "4444 38110Pr dr" | "44"                    | "ford"     | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #1key,2AddressFieldsandSSNMatch->LQA
      |  6 |          5 | "LQA"                         | "LPA"       | ""        | "   DesktopUnderwriter  " | "   thg" | ""            | ""      | ""                    | ""         | "555524834"      | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "VA"               | "50123"    | "14113"         | "FOUND"     |
      #2key,2AddressFieldsandSSNMatch->LQA
      |  7 |          6 | "LQA"                         | "LPA"       | ""        | "   DesktopUnderwriter  " | "ghf"    | "13254985582" | ""      | ""                    | ""         | "995715522"      | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "63526"         | "FOUND"     |
      #LPkeyandSSNMatch->LPA
      |  8 |          7 | "LPA"                         | "LPA"       | ""        | "LoanProspector"          | "f"      | ""            | ""      | ""                    | ""         | "995715522"      | ""                | ""                      | ""         | ""         | "VA"               | ""         | ""              | "FOUND"     |
      #1key,4AddressFieldsandSSNMatch->LCLA
      |  9 |          8 | "Selling"                     | "LPA"       | "111"     | ""                        | ""       | ""            | ""      | ""                    | ""         | "111124834"      | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |

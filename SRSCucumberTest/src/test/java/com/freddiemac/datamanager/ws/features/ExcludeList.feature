@local @dev @dev2 @sitint
Feature: SRS webservice - Exclude Test

  Scenario Outline: Send request to sls webservice to validate exclude lists
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
      | id | scenarioid | srcsystem | docfileid | austype | ausid | mersminid     | partyid | partyRoleType         | lenderlnid | ssn         | addressLineText   | streetName | cityName   | statecode | postalcode | slsAction |
      |  1 |          1 | "LCLA"    | "123"     | ""      | ""    | ""            | ""      | ""                    | ""         | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  2 |          2 | "LQA"     | ""        | ""      | ""    | "16458164582" | ""      | ""                    | ""         | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  3 |          3 | "LQA"     | ""        | ""      | ""    | ""            | "00765" | "CorrespondentLender" | "Ln236104" | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |

  Scenario Outline: Send request to SRS webservice to validate exclude lists
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
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid     | austype | ausid | mersminid             | partyid | partyRoleType         | lenderlnid      | ssn         | addressLineText            | streetPrimaryNumberText | streetName | cityName   | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction   |
      #HappyPath
      |  1 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  2 |          2 | "LQA"       | "LPA"       | ""            | ""      | ""    | "16458164582"         | ""      | ""                    | ""              | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  3 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "Ln236104"      | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #DocFileID
      |  4 |          1 | "LCLA"      | "LPA"       | "1111111111." | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #AddressLineText
      |  5 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "0000 PREAPPROVAL ST."     | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  6 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "0000 PREAPPROVAL STREET." | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  7 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "1 TBD."                   | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  8 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "1 TO BE DETERMINED."      | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  9 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "123 MAIN ST."             | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 10 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "1234 MAIN ST."            | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 11 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "456 SOMEWHERE AVE."       | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 12 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "NO PROPERTY ADDRESS."     | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 13 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "PRE-APPROVAL."            | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 14 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "SEE ATTACHED EXHIBIT A."  | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 15 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "UNKNOWN."                 | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 16 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""              | "111124834" | "PREQUALIFICATION."        | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #MersminID
      | 17 |          2 | "LQA"       | "LPA"       | ""            | ""      | ""    | "112233445566778899." | ""      | ""                    | ""              | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #LenderLnID
      | 18 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "00000000000."  | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 19 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "111111111111." | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 20 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "VKFPKRFJ."     | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 21 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "12345678."     | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 22 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "O123HGTB9."    | "111124834" | "3403 38110Pr dr"          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |

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
      | id | scenarioid | srcsystem | docfileid     | austype | ausid | mersminid             | partyid | partyRoleType         | lenderlnid     | ssn         | addressLineText   | streetName | cityName   | statecode | postalcode | slsAction |
      #RequestWithExcludeLists
      |  1 |          1 | "LCLA"    | "1111111111." | ""      | ""    | ""                    | ""      | ""                    | ""             | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  2 |          1 | "LCLA"    | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""             | "111124834" | "1 TBD."          | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  3 |          2 | "LQA"     | ""            | ""      | ""    | "112233445566778899." | ""      | ""                    | ""             | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |
      |  4 |          3 | "LQA"     | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "00000000000." | "111124834" | "3403 38110Pr dr" | "bedford"  | "McLean14" | "NJ"      | "14113"    | "NEW"     |

  Scenario Outline: Send request to SRS webservice
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
    Then validate SRS service decision with SLS

    Examples: 
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid     | austype | ausid | mersminid             | partyid | partyRoleType         | lenderlnid     | ssn         | addressLineText   | streetPrimaryNumberText | streetName | cityName   | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction   |
      #RequestWithExcludeLists
      |  1 |          1 | "LCLA"      | "LPA"       | "1111111111." | ""      | ""    | ""                    | ""      | ""                    | ""             | "111124834" | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  2 |          1 | "LCLA"      | "LPA"       | "123"         | ""      | ""    | ""                    | ""      | ""                    | ""             | "111124834" | "1 TBD."          | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  3 |          2 | "LQA"       | "LPA"       | ""            | ""      | ""    | "112233445566778899." | ""      | ""                    | ""             | "111124834" | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  4 |          3 | "LQA"       | "LPA"       | ""            | ""      | ""    | ""                    | "00765" | "CorrespondentLender" | "00000000000." | "111124834" | "3403 38110Pr dr" | "44"                    | "bedford"  | "McLean14" | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |

@local @dev @dev2 @sitint
Feature: SRS webservice - Scrubbing Test

  Scenario Outline: Send request to sls webservice to validate scrubbing logic
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
      #DocFileID
      | id | scenarioid | srcsystem | docfileid     | austype              | ausid          | mersminid              | partyid | partyRoleType | lenderlnid | ssn         | addressLineText     | streetName   | cityName      | statecode | postalcode | slsAction |
      |  1 |          1 | "Selling" | "1234567890." | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  2 |          2 | "Selling" | "2$ "         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  3 |          3 | "Selling" | "333"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  4 |          4 | "Selling" | "444"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  5 |          5 | "Selling" | "555"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  6 |          6 | "Selling" | "666"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  7 |          7 | "Selling" | "777"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  8 |          8 | "Selling" | "888"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      |  9 |          9 | "Selling" | "999"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 10 |         10 | "Selling" | "000"         | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 11 |         11 | "Selling" | "123456789."  | ""                   | ""             | "11134567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      #Mersmin
      | 12 |         12 | "Selling" | ""            | ""                   | ""             | "11234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 13 |         13 | "Selling" | ""            | ""                   | ""             | "113345678901."        | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 14 |         14 | "Selling" | ""            | ""                   | ""             | "21434567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 15 |         15 | "Selling" | ""            | ""                   | ""             | " 1153456789"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 16 |         16 | "Selling" | ""            | ""                   | ""             | "11634567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 17 |         17 | "Selling" | ""            | ""                   | ""             | "11734567890123456 ."  | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 18 |         18 | "Selling" | ""            | ""                   | ""             | "118345678901234567 ." | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 19 |         19 | "Selling" | ""            | ""                   | ""             | " 119345678901234567." | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      #Zipcode
      | 20 |         20 | "Selling" | ""            | ""                   | ""             | "12034567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 21 |         21 | "Selling" | ""            | ""                   | ""             | "12134567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "141131"   | "NEW"     |
      | 22 |         22 | "Selling" | ""            | ""                   | ""             | "12234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "1234"     | "NEW"     |
      | 23 |         23 | "Selling" | ""            | ""                   | ""             | "12334567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | ""         | "NEW"     |
      | 24 |         24 | "Selling" | ""            | ""                   | ""             | "12434567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "a2345"    | "NEW"     |
      #TEXT_STDZD_PPTY_ADDR_LI
      | 25 |         25 | "Selling" | ""            | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | " 3403 38110Pr dr " | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      #Negative scenarios to test that other address fields are not scrubbed
      | 26 |         26 | "Selling" | ""            | ""                   | ""             | "12634567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"   | " bed ford " | " Mc Lean14 " | "NJ"      | "14113"    | "NEW"     |
      #AusType and Key
      | 27 |         27 | "Selling" | ""            | "LoanProspector"     | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 28 |         28 | "Selling" | ""            | "LoanProspector"     | "1234567."     | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 29 |         29 | "Selling" | ""            | "LoanProspector"     | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 30 |         30 | "Selling" | ""            | "LoanProductAdvisor" | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 31 |         31 | "Selling" | ""            | "LoanProductAdvisor" | "1234567."     | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 32 |         32 | "Selling" | ""            | "LoanProductAdvisor" | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 33 |         33 | "Selling" | ""            | "DesktopUnderwriter" | "1234567890."  | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 34 |         34 | "Selling" | ""            | "DesktopUnderwriter" | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |
      | 35 |         35 | "Selling" | ""            | "DesktopUnderwriter" | "12345678901." | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"   | "bedford"    | "McLean14"    | "NJ"      | "14113"    | "NEW"     |

  Scenario Outline: Send request to SRS webservice to validate scrubbing
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
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid       | austype              | ausid          | mersminid              | partyid | partyRoleType | lenderlnid | ssn         | addressLineText             | streetPrimaryNumberText | streetName         | cityName            | FipsStateAlphaCode | postalcode | zipplusFourCode | srsAction   |
      #DocFileID
      |  1 |          1 | "Selling"   | "LPA"       | "1234567890."   | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  2 |          2 | "Selling"   | "LPA"       | "2$ "           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      |  3 |          3 | "Selling"   | "LPA"       | "333"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  4 |          4 | "Selling"   | "LPA"       | "444"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  5 |          5 | "Selling"   | "LPA"       | "555"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  6 |          6 | "Selling"   | "LPA"       | "666"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  7 |          7 | "Selling"   | "LPA"       | "777"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  8 |          8 | "Selling"   | "LPA"       | "888"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      |  9 |          9 | "Selling"   | "LPA"       | "999"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 10 |         10 | "Selling"   | "LPA"       | "000"           | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 11 |         11 | "Selling"   | "LPA"       | "123456789."    | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 12 |         11 | "Selling"   | "LPA"       | "123456789."    | ""                   | ""             | "11134567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 13 |         11 | "Selling"   | "LPA"       | " 123456789."   | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 14 |          1 | "Selling"   | "LPA"       | " 1234567890 ." | ""                   | ""             | ""                     | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #Mersmin
      | 15 |         12 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "11234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #Testing scrubbing rule when mersmin is not 18 digits
      | 16 |         13 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "113345678901."        | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #Testing scrubbing rule when mersmin doesn't start with 1
      | 17 |         14 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "21434567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #Testing scrubbing rule to see if space is srubbed
      | 18 |         15 | "Selling"   | "LPA"       | ""              | ""                   | ""             | " 1153456789"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #Scrubbed as length is not 18
      | 19 |         15 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "1153456789"           | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #To test space is considered
      | 20 |         16 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "11634567890 "         | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 21 |         17 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "11734567890123456 ."  | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 22 |         18 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "118345678901234567 ." | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 23 |         19 | "Selling"   | "LPA"       | ""              | ""                   | ""             | " 119345678901234567." | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      #Zipcode
      | 24 |         20 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12034567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 25 |         20 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12034567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | " 14113"        | "FOUND"     |
      | 26 |         20 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12034567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113 "        | "FOUND"     |
      | 27 |         21 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12134567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "141131"        | "NOT_FOUND" |
      | 28 |         22 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "1234"          | "NOT_FOUND" |
      | 29 |         22 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | " 1234"         | "NOT_FOUND" |
      | 30 |         22 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12234567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "1234 "         | "NOT_FOUND" |
      | 31 |         23 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12334567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | ""              | "NOT_FOUND" |
      | 32 |         24 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12434567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "a2345"         | "NOT_FOUND" |
      #TEXT_STDZD_PPTY_ADDR_LI
      | 33 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | " 3403 38110Pr dr "         | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 34 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | "  3403  38110Pr  dr  "     | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 35 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | "   3403   38110Pr   dr   " | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 36 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | "340338110Prdr"             | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 37 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 38 |         25 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12534567890"          | ""      | ""            | ""         | "111124834" | "34   03 38110Pr dr"        | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #Negative scenarios to test that other address fields are not scrubbed
      | 39 |         26 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12634567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | " bed ford "       | " Mc Lean14 "       | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 40 |         26 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12634567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "  bed  ford  "    | "  Mc  Lean14  "    | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 41 |         26 | "Selling"   | "LPA"       | ""              | ""                   | ""             | "12634567890"          | ""      | ""            | ""         | "111124834" | "3403 38110Pr dr"           | "44"                    | "   bed   ford   " | "   Mc   Lean14   " | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      #AusType and Key
      | 42 |         27 | "Selling"   | "LPA"       | ""              | "LoanProspector"     | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 43 |         27 | "Selling"   | "LPA"       | ""              | " LoanProspector "   | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 44 |         27 | "Selling"   | "LPA"       | ""              | "oanProspector"      | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 45 |         27 | "Selling"   | "LPA"       | ""              | "LoanProspector"     | " 12345678."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 46 |         27 | "Selling"   | "LPA"       | ""              | "LoanProspector"     | "12345678 ."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 47 |         28 | "Selling"   | "LPA"       | ""              | "LoanProspector"     | "1234567."     | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 48 |         29 | "Selling"   | "LPA"       | ""              | "LoanProspector"     | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 49 |         30 | "Selling"   | "LPA"       | ""              | "LoanProductAdvisor" | "12345678."    | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 50 |         30 | "Selling"   | "LPA"       | ""              | "LoanProductAdvisor" | " 12345678."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 51 |         30 | "Selling"   | "LPA"       | ""              | "LoanProductAdvisor" | "12345678 ."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 52 |         31 | "Selling"   | "LPA"       | ""              | "LoanProductAdvisor" | "1234567."     | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 53 |         32 | "Selling"   | "LPA"       | ""              | "LoanProductAdvisor" | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 54 |         33 | "Selling"   | "LPA"       | ""              | "DesktopUnderwriter" | "1234567890."  | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 55 |         33 | "Selling"   | "LPA"       | ""              | "DesktopUnderwriter" | " 1234567890." | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 56 |         33 | "Selling"   | "LPA"       | ""              | "DesktopUnderwriter" | "1234567890 ." | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "FOUND"     |
      | 57 |         34 | "Selling"   | "LPA"       | ""              | "DesktopUnderwriter" | "123456789."   | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
      | 58 |         35 | "Selling"   | "LPA"       | ""              | "DesktopUnderwriter" | "12345678901." | ""                     | ""      | ""            | ""         | "211124834" | "3403 38110Pr dr"           | "44"                    | "bedford"          | "McLean14"          | "NJ"               | "14113"    | "14113"         | "NOT_FOUND" |
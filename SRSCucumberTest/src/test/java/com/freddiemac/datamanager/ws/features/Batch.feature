@local @dev @dev2 @sitint
Feature: SRS webservice - Batch Test

  Scenario Outline: Send request to sls webservice to validate Batch requests
    Given a request for batch sls webservice for scenario <scenarioid> <id>
    And source system for batch as <srcsystem>
    And Submitting source system for batch as <subSrceSystm>
    And appraisal identifier for batch as <docfileid>
    And source system for batch as <srcsystem>
    And appraisal identifier for batch as <docfileid>
    And automated underwriting system type for batch as <austype>
    And loan underwriting case identifier for batch as <ausid>
    And MERSMIN identifier for batch as <mersminid>
    And party identifier for batch as <partyid>
    And Party Role Type for batch as <partyRoleType>
    And lender loan identifier for batch as <lenderlnid>
    And tax payer identification numbers for batch as <ssn>
    And address line text for batch as <addressLineText>
    And city name for batch as <cityName>
    And street name for batch as <streetName>
    And state code for batch as <statecode>
    And postal code for batch as <postalcode>
    Then the batch request is sent and response is received from SLS
    Then validate the SLS decision as <slsActions> from batch requests

    Examples: 
      | id | scenarioid | srcsystem | subSrceSystm | docfileid | austype                             | ausid   | mersminid                 | partyid | partyRoleType                | lenderlnid            | ssn                     | addressLineText  | streetName     | cityName         | statecode | postalcode    | slsActions |
      |  1 | "1,2"      | "LPA"     | "LPAv2"      | "222,333" | "DesktopUnderwriter,LOANPROSPECTOR" | "222,1" | "11146809875,11146809870" | "1,2"   | "CorrespondentLender,Lender" | "Ln5958451,Ln7777777" | "1111248343,1111248598" | "112bed,456ford" | "cross,street" | "Reston,Herndon" | "VA,GA"   | "12000,66466" | "NEW,NEW"  |

  Scenario Outline: Send request to sls webservice to validate Batch requests
    Given a request for srs webservice for scenario <scenarioid> and testID <id>
    And Request source system for batch as <rqstsrcsyst> for SRS
    And Submitting source system for batch as <submsrcsyst> for SRS
    And appraisal identifier for batch as <docfileid> for SRS
    And automated underwriting system type for batch as <austype> for SRS
    And loan underwriting case identifier for batch as <ausid> for SRS
    And MERSMIN identifier for batch as <mersminid> for SRS
    And party identifier for batch as <partyid> for SRS
    And Party Role Type for batch as <partyRoleType> for SRS
    And lender loan identifier for batch as <lenderlnid> for SRS
    And tax payer identification numbers for batch as <ssn> for SRS
    And address line text for batch as <addressLineText> for SRS
    And city name for batch as <cityName> for SRS
    And street name for batch as <streetName> for SRS
    And fipsStateAlphaCode for batch as <fipsStateAlphaCode> for SRS
    And postal code for batch as <postalcode> for SRS
    Then the batch request is sent and response is received from SRS
    Then validate the SRS decision as <srsActions> from batch requests

    Examples: 
      | id | scenarioid | rqstsrcsyst | submsrcsyst | docfileid                                                                                                                                                                                                                              | austype                                                                                                                                                                                                                                               | ausid   | mersminid                 | partyid | partyRoleType                | lenderlnid            | ssn                     | addressLineText  | streetName     | cityName         | fipsStateAlphaCode | postalcode    | srsActions            |
      #HappyPath-Found
      |  1 | "1,2"      | "LPA"       | "LPAv2"     | "222,333"                                                                                                                                                                                                                              | "DesktopUnderwriter,LOANPROSPECTOR"                                                                                                                                                                                                                   | "222,1" | "11146809875,11146809870" | "1,2"   | "CorrespondentLender,Lender" | "Ln5958451,Ln7777777" | "1111248343,1111248598" | "112bed,456ford" | "cross,street" | "Reston,Herndon" | "VA,GA"            | "12000,66466" | "FOUND,FOUND"         |
      #HappyPath-Not_Found
      |  2 | "3,3"      | "LPA"       | "LPAv2"     | "222,333"                                                                                                                                                                                                                              | "DesktopUnderwriter,LOANPROSPECTOR"                                                                                                                                                                                                                   | "222,1" | "11146809875,11146809870" | "1,2"   | "CorrespondentLender,Lender" | "Ln5958451,Ln7777777" | "1111248343,1111248598" | "112bed,456ford" | "cross,street" | "Reston,Herndon" | "VA,GA"            | "12000,66466" | "NOT_FOUND,NOT_FOUND" |
      #Error
      |  3 | "3,3"      | "LPA"       | "LPAv2"     | "be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643,333" | "DesktopUnderwriter,be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643be6a70bc447449c69f9ebc4527754643" | "222,1" | "11146809875,11146809870" | "1,2"   | "CorrespondentLender,Lender" | "Ln5958451,Ln7777777" | "1111248343,1111248598" | "112bed,456ford" | "cross,street" | "Reston,Herndon" | "VA,GA"            | "12000,66466" | "ERROR,ERROR"         |

  Scenario Outline: Send request to sls webservice to validate Batch requests
    Given a request for srs webservice for scenario <scenarioid> and testID <id>
    And RecordCount for batch as <recordCount> for SRS
    And Request source system for batch as <rqstsrcsyst> for SRS
    And Submitting source system for batch as <submsrcsyst> for SRS
    And appraisal identifier for batch as <docfileid> for SRS
    And automated underwriting system type for batch as <austype> for SRS
    And loan underwriting case identifier for batch as <ausid> for SRS
    And MERSMIN identifier for batch as <mersminid> for SRS
    And party identifier for batch as <partyid> for SRS
    And Party Role Type for batch as <partyRoleType> for SRS
    And lender loan identifier for batch as <lenderlnid> for SRS
    And tax payer identification numbers for batch as <ssn> for SRS
    And address line text for batch as <addressLineText> for SRS
    And city name for batch as <cityName> for SRS
    And street name for batch as <streetName> for SRS
    And fipsStateAlphaCode for batch as <fipsStateAlphaCode> for SRS
    And postal code for batch as <postalcode> for SRS
    Then the batch request is sent and response is received from SRS

    Examples: 
      | id | scenarioid | recordCount | rqstsrcsyst | submsrcsyst | docfileid | austype                             | ausid   | mersminid                 | partyid | partyRoleType                | lenderlnid            | ssn                     | addressLineText  | streetName     | cityName         | fipsStateAlphaCode | postalcode    |
      #Exception
      |  1 | "1,2"      |           3 | "LPA"       | "LPAv2"     | "222,333" | "DesktopUnderwriter,LOANPROSPECTOR" | "222,1" | "11146809875,11146809870" | "1,2"   | "CorrespondentLender,Lender" | "Ln5958451,Ln7777777" | "1111248343,1111248598" | "112bed,456ford" | "cross,street" | "Reston,Herndon" | "VA,GA"            | "12000,66466" |

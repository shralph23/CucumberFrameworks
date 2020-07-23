package com.freddiemac.datamanager.ws.util;

import com.freddiemac.datamanager.ws.srs.enums.AddressLineTextEnum;

public class ScrubbingDataUtils {

    public String setScrubAppraisalId(String appraisalId){
        String appraisalIdMtch = "";
        if (appraisalId == null ){
            appraisalIdMtch = "";
        } else{
            if ((appraisalId.trim().startsWith("1") ||appraisalId.trim().startsWith("2")) && appraisalId.trim().length() == 10){
                appraisalIdMtch = appraisalId.trim().toUpperCase();
            }else{
                appraisalIdMtch = appraisalId = "";
            }         
        }
        return appraisalIdMtch;
    }

    public String setScrubMersMinId(String mersminId){
        String mersminMtch = "";
        if ( mersminId == null){
            return mersminMtch;

        } else {
            if (mersminId.trim().startsWith("1")  && mersminId.trim().length() == 18 && isNumeric(mersminId.trim())){
                mersminMtch = mersminId.trim();
            } 
            else {
                mersminMtch = "";
            }
        }
        return mersminMtch;
    }

    public boolean isNumeric(String strNum) {
    	try{
    		Double.parseDouble(strNum);
    	}catch (NumberFormatException | NullPointerException nfe){
    		return false;
    	}
		return true;
	}

	public String setScrubLndrLnId(String lendrLnId){
        String lenderLnIdMtch = "";
        if (lendrLnId != null){
            lenderLnIdMtch = lendrLnId.trim().toUpperCase();
        }
        return lenderLnIdMtch;
    }


    public String setScrubZipCode(String zipCode){
        if(zipCode.trim().length()==5 && isNumeric(zipCode.trim())){
            return zipCode.trim();
        } 
        else {
            zipCode = "";
        }
        return zipCode ;        
    }

    public String setScrubAddressLineText(String addressLineText){
        String addressLineTextMtch = "";
        if (addressLineText != null && addressLineText != ""){
          addressLineTextMtch = removeExtraSpaces(addressLineText.trim().toUpperCase());
          if(isAdressInEnumValue(addressLineTextMtch)){
              addressLineTextMtch = "";
          }
        }
        return addressLineTextMtch;
    }
    
    private boolean isAdressInEnumValue(String addressLineTextMtch){
        if(AddressLineTextEnum.contains(addressLineTextMtch)){
            return true;
        }
        return false;
    }

    public String setAddressAndZipCode(String addressLineText, String zipCode){
        if ((addressLineText!=null && !addressLineText.isEmpty()) && (zipCode!= null && !zipCode.isEmpty()) 
                && zipCode.trim().length()==5 && isNumeric(zipCode.trim())){ 
            if(!setScrubAddressLineText(addressLineText.trim().toUpperCase()).equals("")){
                return setScrubAddressLineText(addressLineText.trim().toUpperCase()) + " " + setScrubZipCode(zipCode.trim());
            }
        }
         return "";
    }

    private String removeExtraSpaces(String value){
        String newValue;
        newValue = value.replaceAll(" +", " ");
        return newValue;
    }


    public String setScrubAusId(String ausType, String ausId){
        String ausIdMtch = "";
        if (ausType == null || ausType.equalsIgnoreCase("") || ausId == null || ausId.equalsIgnoreCase("")){
            ausIdMtch = "";
            return ausIdMtch.trim();
        }

        if (ausType.trim().equals("LoanProspector") || ausType.trim().equals("LoanProductAdvisor") 
        		|| ausType.trim().equals("DesktopUnderwriter") ){

            if(ausType.trim().equals("DesktopUnderwriter")) {
                if (ausId.trim().length()==10) {                
                    ausIdMtch = ausId.trim().toUpperCase();
                }else{
                    ausIdMtch = "";
                }
            }else{
                ausIdMtch = "";
            }

            if(ausType.trim().equals("LoanProspector") || ausType.trim().equals("LoanProductAdvisor")){
                if(ausId.trim().length()==8){
                    ausIdMtch = ausId.trim().toUpperCase();
                }
                else{
                    ausIdMtch = "";
                }
            }

        } else {
            ausIdMtch = ausId.trim().toUpperCase();
        }
        return ausIdMtch.trim();
    }



    public String setScrubAusType(String ausType, String ausId){
        if(ausId=="" || ausId == null || ausType=="" || ausType == null ){
            return "";
        }
        else{
            return ausType.toUpperCase().trim();
        }       	
    }     
    
    public String convertToUpperCaseAndTrim(String attributeToBeConverted){
       if(attributeToBeConverted != null){
          attributeToBeConverted = attributeToBeConverted.trim().toUpperCase();
       }
       return attributeToBeConverted;
    }
    
}

package utils.data.extractioncontainers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.freddiemac.datamanager.jaxb.Address;

import featuredefinition.GlobalHooks;
import utils.generic.TestConstants;

public class AddressContainer implements ResultSetExtractor<List<AddressContainer>> {
    private String addressIdentifier;
    private String addressLineText;
    private String addressSourceType;
    private String cityName;
    private String stateCode;
    private String postalCode;
    private String zIPPlusFourCode;
    private String addressUnitIdentifier;
    private int eventId;

    public AddressContainer() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String fIPSStateAlphaCode) {
        this.stateCode = fIPSStateAlphaCode;
    }

    public String getZIPPlusFourCode() {
        return zIPPlusFourCode;
    }

    public void setZIPPlusFourCode(String zIPPlusFourCode) {
        this.zIPPlusFourCode = zIPPlusFourCode;
    }

    public String getAddressIdentifier() {
        return addressIdentifier;
    }

    public void setAddressIdentifier(String addressIdentifier) {
        this.addressIdentifier = addressIdentifier;
    }

    public String getAddressLineText() {
        return addressLineText;
    }

    public void setAddressLineText(String addressLineText) {
        this.addressLineText = addressLineText;
    }

    public String getAddressSourceType() {
        return addressSourceType;
    }

    public void setAddressSourceType(String addressSourceType) {
        this.addressSourceType = addressSourceType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressUnitIdentifier() {
        return addressUnitIdentifier;
    }

    public void setAddressUnitIdentifier(String addressUnitIdentifier) {
        this.addressUnitIdentifier = addressUnitIdentifier;
    }

    @Override
    public boolean equals(Object xmlAddrContainersObj) {
        AddressContainer dbAddrContainers = this;
        Address xmlAddrContainers = (Address) xmlAddrContainersObj;
        if (xmlAddrContainers == null) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            int recordsCounter = 0;
            sb.append("Event= " + dbAddrContainers.getEventId() + "\n");
            if (dbAddrContainers.getAddressSourceType() != null && xmlAddrContainers.getAddressSourceType() != null) {
                if (!dbAddrContainers.getAddressSourceType().equals(xmlAddrContainers.getAddressSourceType())) {
                    GlobalHooks.getScenario().write(
                            "AddressSourceType mismatch. Expected Value is " + dbAddrContainers.getAddressSourceType()
                                    + " but actual value is " + xmlAddrContainers.getAddressSourceType());
                    return false;
                } else {
                    sb.append("AddressSourceType in DB: " + dbAddrContainers.getAddressSourceType()
                            + " AddressSourceType in XML: " + xmlAddrContainers.getAddressSourceType() + "\n");
                    recordsCounter++;
                }
            }

            if (dbAddrContainers.getStateCode() != null && xmlAddrContainers.getStateCode() != null) {
                if (!dbAddrContainers.getStateCode().equals(xmlAddrContainers.getStateCode())) {
                    GlobalHooks.getScenario()
                            .write("StateCode mismatch. Expected Value is " + dbAddrContainers.getStateCode()
                                    + " but actual value is " + xmlAddrContainers.getStateCode());
                    return false;
                } else {
                    sb.append("StateCode in DB: " + dbAddrContainers.getStateCode() + " StateCode in XML: "
                            + xmlAddrContainers.getStateCode() + "\n");
                    recordsCounter++;
                }
            }

            if (dbAddrContainers.getPostalCode() != null && xmlAddrContainers.getPostalCode() != null) {
                if (!dbAddrContainers.getPostalCode().equals(xmlAddrContainers.getPostalCode())) {
                    GlobalHooks.getScenario()
                            .write("PostalCode mismatch. Expected Value is " + dbAddrContainers.getPostalCode()
                                    + " but actual value is " + xmlAddrContainers.getPostalCode());
                    return false;
                } else {
                    sb.append("PostalCode in DB: " + dbAddrContainers.getPostalCode() + " PostalCode in XML: "
                            + xmlAddrContainers.getPostalCode() + "\n");
                    recordsCounter++;
                }
            }

            if (dbAddrContainers.getZIPPlusFourCode() != null && xmlAddrContainers.getZIPPlusFourCode() != null) {
                if (!dbAddrContainers.getZIPPlusFourCode().equals(xmlAddrContainers.getZIPPlusFourCode())) {
                    GlobalHooks.getScenario().write(
                            "ZIPPlusFourCode mismatch. Expected Value is " + dbAddrContainers.getZIPPlusFourCode()
                                    + " but actual value is " + xmlAddrContainers.getZIPPlusFourCode());
                    return false;
                } else {
                    sb.append("ZIPPlusFourCode in DB: " + dbAddrContainers.getZIPPlusFourCode()
                            + " ZIPPlusFourCode in XML: " + xmlAddrContainers.getZIPPlusFourCode() + "\n");
                    recordsCounter++;
                }
            }
            if (dbAddrContainers.getCityName() != null && xmlAddrContainers.getCityName() != null) {
                if (!dbAddrContainers.getCityName().equals(xmlAddrContainers.getCityName())) {
                    GlobalHooks.getScenario().write("CityName mismatch. Expected Value is " + dbAddrContainers.getCityName()
                            + " but actual value is " + xmlAddrContainers.getCityName());
                    return false;
                } else {
                    sb.append("CityName in DB: " + dbAddrContainers.getCityName() + " CityName in XML: "
                            + xmlAddrContainers.getCityName() + "\n");
                    recordsCounter++;
                }
            }
            if (dbAddrContainers.getAddressLineText() != null && xmlAddrContainers.getAddressLineText() != null) {
                if (!dbAddrContainers.getAddressLineText().equals(xmlAddrContainers.getAddressLineText())) {
                    GlobalHooks.getScenario().write(
                            "AddressLineText mismatch. Expected Value is " + dbAddrContainers.getAddressLineText()
                                    + " but actual value is " + xmlAddrContainers.getAddressLineText());
                    return false;
                } else {
                    sb.append("AddressLineText in DB: " + dbAddrContainers.getAddressLineText()
                            + " AddressLineText in XML: " + xmlAddrContainers.getAddressLineText() + "\n");
                    recordsCounter++;
                }
            }
            if (dbAddrContainers.getAddressUnitIdentifier() != null
                    && xmlAddrContainers.getAddressUnitIdentifier() != null) {
                if (!dbAddrContainers.getAddressUnitIdentifier().equals(xmlAddrContainers.getAddressUnitIdentifier())) {
                    GlobalHooks.getScenario().write("AddressUnitIdentifier mismatch. Expected Value is "
                            + dbAddrContainers.getAddressUnitIdentifier() + " but actual value is "
                            + xmlAddrContainers.getAddressUnitIdentifier());
                    return false;
                } else {
                    sb.append("AddressUnitIdentifier in DB: " + dbAddrContainers.getAddressUnitIdentifier()
                            + " AddressUnitIdentifier in XML: " + xmlAddrContainers.getAddressUnitIdentifier() + "\n");
                    recordsCounter++;
                }
            }
            sb.append(TestConstants.REPORT_SEPERATOR);
            GlobalHooks.getScenario().write(sb + "Address Match. Records validated in the section " + recordsCounter);
            return true;
        }
    }

    @Override
    public List<AddressContainer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<AddressContainer> results = new ArrayList<>();
        while (rs.next()) {
            AddressContainer address = new AddressContainer();
            address.setAddressSourceType(rs.getString("NAME_ADDR_SRCE_TYPE"));
            address.setStateCode(rs.getString("CD_FIPS_ST_ALPHA"));
            address.setPostalCode(rs.getString("CD_PSTL"));
            address.setZIPPlusFourCode(rs.getString("CD_ZIP_PLUS_4"));
            address.setCityName(rs.getString("NAME_CITY"));
            address.setAddressLineText(rs.getString("TEXT_ADDR_LI"));
            address.setAddressUnitIdentifier(rs.getString("ID_ADDR_UNIT"));
            address.setEventId(rs.getInt("ID_EVNT"));
            results.add(address);
        }
        return results;
    }

    @Override
    public String toString() {
        return "AddressContainer [addressIdentifier=" + addressIdentifier + ", addressLineText=" + addressLineText
                + ", addressSourceType=" + addressSourceType + ", cityName=" + cityName + ", stateCode=" + stateCode
                + ", postalCode=" + postalCode + ", zIPPlusFourCode=" + zIPPlusFourCode + ", addressUnitIdentifier="
                + addressUnitIdentifier + ", eventId=" + eventId + "]";
    }
}

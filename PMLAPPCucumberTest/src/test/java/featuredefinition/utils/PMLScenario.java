package featuredefinition.utils;

import com.freddiemac.service.event.model.Events;
import com.freddiemac.sls.SLSRequestType;

import datageneration.generic.DataGeneratorUtils;

public class PMLScenario {

    private String sourceSystem, eventStatus, slsID, messageId;
    private Events payload;
    private SLSRequestType slsRequestType;

    public PMLScenario(String slsID, SLSRequestType slsRequestType) {
        this.slsID = slsID;
        this.slsRequestType = slsRequestType;
        this.messageId = DataGeneratorUtils.generateUniqueId();
    }

    public String getSlsID() {
        return slsID;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getMessageId() {
        return messageId;
    }

    public Events getPayload() {
        return payload;
    }

    public void setPayload(Events payload) {
        this.payload = payload;
    }

    public SLSRequestType getSlsRequestType() {
        return slsRequestType;
    }

}
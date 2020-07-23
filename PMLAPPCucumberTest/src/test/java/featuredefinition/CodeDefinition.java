package featuredefinition;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.freddiemac.service.event.model.Events;
import com.freddiemac.sls.SLSRequestType;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import featuredefinition.utils.PMLScenario;
import featuredefinition.utils.StepsUtils;
import utils.db.PmlTestDao;

@ContextConfiguration(classes = { TestApplicationContext.class })
@Transactional
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class CodeDefinition {

    private static final Logger LOG = Logger.getLogger(CodeDefinition.class);

    @Autowired
    @Qualifier("PmlTestDao")
    private PmlTestDao dao;
    PMLScenario currentScenario;
    StepsUtils stepsUtils = new StepsUtils();
    private static Map<Integer, PMLScenario> pmlScenarioTotalMap = new HashMap<>();

    @Given("^a request for sls webservice for id \"([^\"]*)\"$")
    public void aRequestForSlsWebservice(String scenarioId) throws DatatypeConfigurationException, JAXBException,
            ParserConfigurationException, SOAPException, IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, ClassCastException, SAXException, URISyntaxException {

        if (pmlScenarioTotalMap.containsKey(Integer.parseInt(scenarioId))) {
            LOG.debug("Retrieve the SLSID if scenarioId exists");
            currentScenario = pmlScenarioTotalMap.get(Integer.parseInt(scenarioId));
        } else {
            LOG.debug("Create a SLSID by sending a SOAP request");
            Map.Entry<String, SLSRequestType> slsData = stepsUtils.sendRequestToSLSService();
            // String slsId ="886a384a-4e9c-474a-a0a0-9a851fe19140";
            currentScenario = new PMLScenario(slsData.getKey(), slsData.getValue());
            pmlScenarioTotalMap.put(Integer.parseInt(scenarioId), currentScenario);
        }
    }

    @Then("^setup the Payload with unique values for \"([^\"]*)\"$")
    public void requestSetForPmlApp(String sourceSystem) throws Exception {
        currentScenario.setSourceSystem(sourceSystem);
        LOG.debug("Create payload by passing unique values to the xsds based on Source Systems" + sourceSystem);
        stepsUtils.setPmlAppRequest(currentScenario.getSourceSystem(), currentScenario.getSlsID(),
                currentScenario.getMessageId(), currentScenario.getSlsRequestType());
    }

    @Then("^modify \"([^\"]*)\" to create a payload with \"([^\"]*)\"$")
    public void modifyPayload(String attributeTag, String attributeValue) throws Exception {
        LOG.debug("To modify the properties file so as to create Payload based on the feature file");
        stepsUtils.modifyPropertiesFile(currentScenario.getMessageId(), attributeTag, attributeValue);
    }

    @Then("^remove the \"([^\"]*)\"$")
    public void removeContainer(String container) {
        LOG.debug("To restrict the container " + container + "from being created");
        stepsUtils.removeContainerFromPayload(currentScenario.getMessageId(), container);
    }

    @When("^the request is sent to the PMLAPP Client$")
    public void theRequestIsSentToThePmlappClient() throws Exception {
        LOG.debug(
                "Send request to PMLAPP Client based on the configuration information mentioned in the properties file");
        Events xmlPayloadEvent = stepsUtils.sendRequestToPmlApp(currentScenario.getMessageId());
        currentScenario.setPayload(xmlPayloadEvent);
    }

    @Then("^validate that the DB received the payload correctly with EventProcessStatus as \"([^\"]*)\"$")
    public void validateThatTheDbReceivedThePayloadCorrectly(String status)
            throws SQLException, ReflectiveOperationException {
        currentScenario.setEventStatus(status);
        LOG.debug("Validating Payload is being processed and verify the event Status in the DB is same as that of "
                + status);
        stepsUtils.validatePmlWithDb(currentScenario.getSlsID(), currentScenario.getEventStatus(),
                currentScenario.getMessageId());
    }

    @Given("^DDL is deployed for scenario with id (\\d+) for table \"([^\"]*)\" is deployed for schema \"([^\"]*)\"$")
    public void tableDeployedForSchema(int scenario, String tableName, String currentSchema) throws Exception {
        LOG.debug("Validating whether the DDL is deployed for Schema : " + currentSchema + "with table name :"
                + tableName + "and scenerio :" + scenario);
        stepsUtils.setDDLInfo(tableName, currentSchema);

    }

    @Then("^validate that DataType is \"([^\"]*)\" and Nullable is \"([^\"]*)\" for column \"([^\"]*)\" with constraints \"([^\"]*)\"$")
    public void validateData(String dataType, String nullable, String columnName, List<String> constraints)
            throws SQLException, ReflectiveOperationException {
        LOG.debug("Validating whether the DDL deployed has correct DataType" + dataType + "with column Name :"
                + columnName + "and constraints :" + constraints);
        stepsUtils.validateDDLInfo(dataType, nullable, columnName, constraints);
    }

    @And("^validate that information has been stored correctly in the DB$")
    public void validateDBData()
            throws SQLException, ReflectiveOperationException, XPathExpressionException, JAXBException {
        LOG.debug("Validating DB has got the exact information as that of Payload");
        stepsUtils.validateDBInfo(currentScenario.getSlsID(), currentScenario.getEventStatus(),
                currentScenario.getSourceSystem(), dao, currentScenario.getPayload());
    }
}

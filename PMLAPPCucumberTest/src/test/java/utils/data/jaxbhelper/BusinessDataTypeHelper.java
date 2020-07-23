package utils.data.jaxbhelper;

import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.freddiemac.datamanager.jaxb.PrimaryMarketLoanSubmissionBatchContainer;
import com.freddiemac.service.event.model.BusinessDataType;

public class BusinessDataTypeHelper {

    public static BusinessDataType getBusinessDataType(Properties properties)
            throws JAXBException, ParserConfigurationException {
        BusinessDataType businessDataType = new BusinessDataType();
        businessDataType.getAny().add(getPrimaryMarketLoanSubmissionTransactionContainer(properties));
        return businessDataType;
    }

    private static Element getPrimaryMarketLoanSubmissionTransactionContainer(Properties properties)
            throws JAXBException, ParserConfigurationException {
        PrimaryMarketLoanSubmissionBatchContainer p = PrimaryMarketLoanSubmissionBatchContainerHelper
                .getPrimaryMarketLoanSubmissionBatchContainer(properties);

        com.freddiemac.datamanager.jaxb.ObjectFactory factory = new com.freddiemac.datamanager.jaxb.ObjectFactory();
        JAXBContext jc = JAXBContext.newInstance(com.freddiemac.datamanager.jaxb.ObjectFactory.class);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(factory.createPrimaryMarketLoanSubmissionBatchContainer(p), document);
        return document.getDocumentElement();

    }
}

package utils.data.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.jdbc.core.ResultSetExtractor;

import utils.data.extractioncontainers.MetaData;
import utils.db.DatabaseQueries;
import utils.db.PmlTestDao;

public class ContainerValidation {

    @SuppressWarnings("rawtypes")
    public static boolean validateMetaDataContainer(String slsId, PmlTestDao dao) {
        String sql = DatabaseQueries.PRIMARY_MARKET_LOAN_SUBMISSION_TRANSACTION_QUERY + DatabaseQueries.QUERY_TO_APPEND;
        List<ResultSetExtractor> tempArray = dao.getResultsFrmDB(sql, slsId, new MetaData());
        MetaData[] dbMetaDataContainer = tempArray.toArray(new MetaData[tempArray.size()]);
        return MetaData.validateMetaData(dbMetaDataContainer);
    }

    @SuppressWarnings("rawtypes")
    public static <T> boolean validateContainers(String slsId, PmlTestDao dao, ResultSetExtractor resObj, String query,
            Object xmlObject) {
        List<Object> payloadObjects = new ArrayList<Object>();
        payloadObjects.add(0, xmlObject);
        return validateContainers(slsId, dao, resObj, query, payloadObjects);
    }

    @SuppressWarnings("rawtypes")
    public static <T> boolean validateContainers(String slsId, PmlTestDao dao, ResultSetExtractor resObj, String query,
            List<?> payloadObjects) {

        String sql = query + DatabaseQueries.QUERY_TO_APPEND;
        List<ResultSetExtractor> dbValues = dao.getResultsFrmDB(sql, slsId, resObj);

        String className = !payloadObjects.isEmpty() && payloadObjects.get(0) != null
                ? payloadObjects.get(0).getClass().toString() : "";
        Assert.assertEquals(
                "Number of elements for container: " + className + " did not match the record founds in the database",
                dbValues.size(), payloadObjects.size());
        boolean isEqual = true;
        for (int index = 0; index < dbValues.size() && isEqual; index++) {
            isEqual = dbValues.get(index).equals(payloadObjects.get(index));
        }
        return isEqual;
    }
}

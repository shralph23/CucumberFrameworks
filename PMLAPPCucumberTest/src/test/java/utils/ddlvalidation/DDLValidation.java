package utils.ddlvalidation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import db.DatabaseHandler;
import featuredefinition.GlobalHooks;
import generic.GeneralUtils;

public class DDLValidation {
    private String tableName, currentSchema;
    private Map<String, String> dbDetails;

    public DDLValidation() {
        dbDetails = GeneralUtils.loadDbDetails(GlobalHooks.getProperties());
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setCurrentSchema(String currentSchema) {
        this.currentSchema = currentSchema;
    }

    public boolean validateDDLInfo(String dataType, String nullable, String columnName, List<String> constraints)
            throws SQLException, ReflectiveOperationException {
        boolean fkValidated = false;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        dbDetails.replace("currentSchema", "SYSIBM");
        Connection dbConnection = databaseHandler.getDBConnection(dbDetails);

        PreparedStatement statement = dbConnection.prepareStatement(
                "SELECT NAME, COLTYPE, NULLS, LENGTH, SCALE, KEYSEQ FROM SYSCOLUMNS where tbname = ? and tbcreator = ? and name = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.setString(1, tableName);
        statement.setString(2, currentSchema);
        statement.setString(3, columnName);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        String[] dataTypeSeparated = dataType.split("\\(");
        dataType = dataTypeSeparated[0];
        Assert.assertTrue("DataType mismatch for column: " + columnName + " actual: " + dataType + " expected: "
                + resultSet.getString(2), dataType.trim().equals(resultSet.getString(2).trim()));
        if (dataType.equals("DECIMAL")) {
            dataTypeSeparated = dataTypeSeparated[1].split(",");
            String length = dataTypeSeparated[0];
            String scale = dataTypeSeparated[1].split("\\)")[0];
            Assert.assertTrue("Length mismatch for column: " + columnName + " actual: " + length + " expected: "
                    + resultSet.getString(4), length.trim().equals(resultSet.getString(4).trim()));
            Assert.assertTrue("Scale mismatch for column: " + columnName + " actual: " + scale + " expected: "
                    + resultSet.getString(5), scale.trim().equals(resultSet.getString(5).trim()));
        }
        Assert.assertTrue("Nullable mismatch for column: " + columnName + " actual: " + nullable + " expected: "
                + resultSet.getString(3), nullable.trim().equals(resultSet.getString(3).trim()));

        for (int a = 0; a < constraints.size(); a++) {
            if (!constraints.get(a).equals("No")) {
                if (constraints.get(a).equals("PK")) {
                    Assert.assertTrue("Constraint mismatch, not primary key.", resultSet.getString(6) != null);
                }

                if (constraints.get(a).equals("FK")) {
                    statement = dbConnection.prepareStatement("select FKCOLNAMES from SYSRELS where TBNAME = ?",
                            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    statement.setString(1, tableName);
                    resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        String foreignKeys = resultSet.getString(1);
                        String[] words = foreignKeys.split("\\s+");
                        for (int i = 0; i < words.length; i++) {
                            if (columnName.trim().equals(words[i].trim())) {
                                fkValidated = true;
                                break;
                            }
                        }
                        Assert.assertTrue("Constraint mismatch, not foreign key.", fkValidated);
                    }
                }
            }
        }

        GlobalHooks.getScenario().write("DDL Information match");
        return true;
    }

}

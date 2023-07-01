package repository;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.util.LinkedList;

public class JDBCConnection {

    public static Connection getJBDCConnection() {
        SQLServerDataSource sds = new SQLServerDataSource();
        sds.setServerName("HOANG-DUNG");
        sds.setDatabaseName("ASIGNMENTJAVA3");
        sds.setUser("sa");
        sds.setPassword("06122004");
        sds.setPortNumber(1433);
        sds.setEncrypt(false);
        try {
            Connection conn = sds.getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

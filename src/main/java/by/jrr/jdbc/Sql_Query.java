package by.jrr.jdbc;

public class Sql_Query {

    public static final String CREATE_TABLE = "CREATE TABLE jis6.developers (\n" +
            "                                                id INT NOT NULL AUTO_INCREMENT,\n" +
            "                                                name VARCHAR(50) NOT NULL,\n" +
            "                                                specialty VARCHAR(50) NOT NULL,\n" +
            "                                                salary INT NOT NULL,\n" +
            "                                                PRIMARY KEY (id));";

    public static final String INSERT_DEVELOPER_1 = "INSERT INTO jis6.developers (name, specialty, salary) VALUES ('Sascha', 'Java', '3000')";
    public static final String INSERT_DEVELOPER_2 = "INSERT INTO jis6.developers (name, specialty, salary) VALUES ('Anton', 'Java', '5000')";
    public static final String INSERT_DEVELOPER_3 = "INSERT INTO jis6.developers (name, specialty, salary) VALUES ('Semen', 'Java', '4000')";

    public static final String INSERT_DEV = "INSERT INTO jis6.developers(name, specialty, salary) values(?,?,?)";
    public static final String SELECT_DEVELOPERS = "SElect * from developers";
    public static final String DELETE_DEVELOPERS_BY_ID = "DELETE FROM developers where id = ?";
    public static final String UPDATE_SALARY_BY_ID = "update developers set salary = ? where id = ?";

    public static final String SELECT_BY_ID = "select * FROM developers where id = ?";
}

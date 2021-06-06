package by.jrr.jdbc;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

public class DeveloperJdbcDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/jis6";

    static final String USER = "anton";
    static final String PASSWORD = "1239087154aA!";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        int choise = 10;

        while(choise != 0) {
            System.out.println("\n");
            System.out.println("1 - Добавить пользователя");
            System.out.println("2 - Показать всех пользователей");
            System.out.println("3 - Удалить пользователя");
            System.out.println("4 - Обновить зарплату");
            System.out.println("5 - Показать определенного пользователей");
            System.out.println("0 - Выйти");
            choise = scannerInt.nextInt();
            switch (choise){
                case 1: {
                    System.out.println("enter name");
                    String name = scannerString.nextLine();
                    System.out.println("enter spec");
                    String spec = scannerString.nextLine();
                    System.out.println("enter salary");
                    int salary = scannerInt.nextInt();
                    insetDev(name, spec, salary);
                    break;
                }
                case 2: {
                    selectAll();
                    break;
                }
                case 3: {
                    System.out.println("Enter id");
                    int id = scannerInt.nextInt();
                    deleteDeveloper(id);
                    break;
                }
                case 4: {
                    System.out.println("enter id");
                    int id = scannerInt.nextInt();
                    System.out.println("enter new salary");
                    int salary = scannerInt.nextInt();
                    selectOne(id);
                    System.out.println("you sure?" +
                            "\n 1- yes" +
                            "\n 2 - no");
                    int sw = scannerInt.nextInt();
                    if(sw == 1) {
                        createStatementForUpdateSalary(Sql_Query.UPDATE_SALARY_BY_ID, id, salary, createConnection());
                    }
                    break;
                }
                case 5: {
                    System.out.println("enter id");
                    int sw = scannerInt.nextInt();
                    selectOne(sw);
                    break;
                }
                case 0: choise = 0;
            }

        }
    }

    @SneakyThrows
    public static void deleteDeveloper(int id){
        createStatementForDelete(Sql_Query.DELETE_DEVELOPERS_BY_ID, id, createConnection());
    }

    @SneakyThrows
    public static void selectOne(int id){
        ResultSet resultSet = createStatementForShowDeveloper(Sql_Query.SELECT_BY_ID, id, createConnection()).executeQuery();
        while(resultSet.next()){
            int id1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String spec = resultSet.getString(3);
            int salary = resultSet.getInt(4);
            System.out.printf("%d. %s - %s - %d$ \n", id1, name, spec, salary);
        }
    }

    @SneakyThrows
    public static void selectAll(){
        ResultSet resultSet = createStatement(createConnection()).executeQuery(Sql_Query.SELECT_DEVELOPERS);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String spec = resultSet.getString(3);
            int salary = resultSet.getInt(4);
            System.out.printf("%d. %s - %s - %d$ \n", id, name, spec, salary);
        }
    }

    @SneakyThrows
    public static void insetDev(String name, String spec, int salary){
        createStatementForInsert(Sql_Query.INSERT_DEV, name, spec, salary, createConnection());
    }

    @SneakyThrows
    public static void insertDeveloper(){
            execute(Sql_Query.INSERT_DEVELOPER_1, createStatement(createConnection()));
            execute(Sql_Query.INSERT_DEVELOPER_2, createStatement(createConnection()));
            execute(Sql_Query.INSERT_DEVELOPER_3, createStatement(createConnection()));
    }

    @SneakyThrows
    public static void createTableDevelopers() {
        execute(Sql_Query.CREATE_TABLE, createStatement(createConnection()));
    }

    @SneakyThrows
    public static Connection createConnection(){
        Connection connection = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        return connection;
    }

    @SneakyThrows
    public static PreparedStatement createStatementForShowDeveloper(String sql ,int id,Connection connection){
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement;
    }

    @SneakyThrows
    public static void createStatementForUpdateSalary(String sql ,int id , int salary,Connection connection){
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, salary);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public static void createStatementForDelete(String sql ,int id,Connection connection){
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public static void createStatementForInsert(String sql ,String name, String spec, int salary,Connection connection){
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, spec);
        preparedStatement.setInt(3, salary);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public static Statement createStatement(Connection connection){
        Statement statement = null;
        statement = connection.createStatement();
        return statement;
    }

    @SneakyThrows
    public static void execute(String sql, Statement statement){
        statement.executeUpdate(sql);
    }


}




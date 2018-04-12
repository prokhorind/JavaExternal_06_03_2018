package com.hometask9.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kleba on 10.04.2018.
 */
public class DB {
    private  String driverName;
    private  String connectionString;
    private  String login;
    private  String password;

    public DB(DBConfigBuilder dbConfigBuilder){
        this.driverName=dbConfigBuilder.getDriverName();
        this.connectionString=dbConfigBuilder.getConnectionString();
        this.login=dbConfigBuilder.getLogin();
        this.password=dbConfigBuilder.getPassword();
    }

    public String getDriverName() {
        return driverName;
    }

    public String getConnectionString() {
        return connectionString;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

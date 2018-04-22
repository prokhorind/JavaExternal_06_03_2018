package com.hometask9.jdbc.config;

/**
 * Created by kleba on 10.04.2018.
 */
public class DBConfigBuilder {
    private  String driverName;
    private  String connectionString;
    private  String login;
    private  String password;

    public  DBConfigBuilder(){}

    public String getDriverName() {
        return driverName;
    }

    public DBConfigBuilder setDriverName(String driverName) {
        this.driverName = driverName;
        return  this;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public DBConfigBuilder setConnectionString(String connectionString) {
        this.connectionString = connectionString;
        return  this;
    }

    public String getLogin() {
        return login;
    }

    public DBConfigBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DBConfigBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    public DB build(){
        return  new DB(this);
    }
}

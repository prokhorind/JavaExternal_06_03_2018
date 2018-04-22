package com.hometask9.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by kleba on 17.04.2018.
 */
public class ConnectionPool {
    private LinkedList<Connection> availableConns = new LinkedList<>();
    private LinkedList<Connection> usedConns = new LinkedList<Connection>();
    private DB db;

    public ConnectionPool(DB db,int initConnCnt) {
        this.db=db;
        try {
            Class.forName(this.db.getDriverName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.add(getConnection());
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db.getConnectionString(),db.getLogin(),db.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.getLast();
            availableConns.remove(newConn);
        }
        usedConns.add(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.remove(c)) {
                availableConns.add(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}

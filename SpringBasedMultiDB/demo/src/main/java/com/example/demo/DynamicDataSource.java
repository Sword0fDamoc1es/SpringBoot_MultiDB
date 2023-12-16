package com.example.demo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DynamicDataSource implements DataSource,InitializingBean{
    // InitializingBean is used to initialize. override afterPropertiesSet() method.

    // current datasource tags:
    public static ThreadLocal<String> currentDataSource = new ThreadLocal<String>();


    // for exmaple: use condition is "w" : write
    @Autowired
    DataSource dataSource1;

    // for exmaple: use condition is "r" : read
    @Autowired
    DataSource dataSource2;



    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParentLogger'");
    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isWrapperFor'");
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unwrap'");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // By default, we do w.
        currentDataSource.set("w");

    }

    @Override
    public Connection getConnection() throws SQLException {
        // do check what source we need:
        if(currentDataSource.get().equals("w")){
            return dataSource1.getConnection();
        }else{
            return dataSource2.getConnection();
        }


    }

    @Override
    public Connection getConnection(String arg0, String arg1) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLogWriter'");
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoginTimeout'");
    }

    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLogWriter'");
    }

    @Override
    public void setLoginTimeout(int arg0) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLoginTimeout'");
    }
    
}

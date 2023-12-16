package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DynamicDataSource2 extends AbstractRoutingDataSource{
    // we don;t even need to implement initializeBean, because we are using AbstractRoutingDataSource which already implements InitializingBean
    public static ThreadLocal<String> currentDataSource = new ThreadLocal<String>();
    @Autowired
    DataSource ds1;
    @Autowired
    DataSource ds2;


    // TODO, the only method we need to implement
    @Override
    @Nullable
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }

    @Override
    public void afterPropertiesSet() {
        // assign targetDS.
        // set default to defualtDS.
        Map<Object,Object> targetDS = new HashMap<>();
        targetDS.put("w",ds1);
        targetDS.put("r",ds2);
        super.setTargetDataSources(targetDS);

        super.setDefaultTargetDataSource(ds1);
        super.afterPropertiesSet();
    }

}

# SpringBoot_MultiDB
demo of multiDB using SpringBoot

### framework:
1. SpringBoot (2)
2. how to, 3?

### DB:
virtual db.

-----------------------
## idea and workflow for Self-defined Dynamic Datasource:
##### workflow:
1. request of DB operation.  
2. goes to ORM framework. Need a JDBC, need a connection.  
3. spring jdbc will call a bean, which is Datasource.  
4. datasource.getConnection when get the datasource.  
5. Do CRUD operation.  
##### expand and idex:
    on Datasource. Datasource if defined by myself, it can do dynamic connection.  

#### what will we do:
    create different beans. 
    each is a different datasource.
    for the dynamic datasource bean, we autowire different bean correspondingly.
    the dynamicDataSource is more like a switch, the static threadlocal tells what DB to use. REMEMBER!!! set is as a primary datasource, so that spring goes to it directly.
    by setting that threadlocal during you create a request, we change the DB.

------------------------
## idea and workflow for abstractRoutingDatasource
##### workflow:
0. the lack of above: self-override method is a huge workload, and quite challenging.
1. the lack of above: coupling. in controller, we have lots of currentDatasource.set("r/w"). This increase coupling.
2. We use AbstrctRoutingDataSource
3. DynamicDataSource2 implements abstractRoutingDataSource(ARDS).
4. ARDS: contains targetDataSource, defualtDataSource and resolvedDataSource
5. we focus on targetDS and defaultDS.
6. ARDS implements DS and contains a getConnection method.
##### what will be do:
    subclass implements ARDS, and implements a determineCurrentLookupKey method for getConnection method.
    and in afterPropertiesSet method, we set targetDataSources and defaultDataSource.
    the determineCurrentLookupKey is just get the ThreadLocal "currentDS", that is a key.

------------
## myBatis plugin, used for seperated R/W system.
------------------
## AOP for service based multi-DB switching.



# SpringBoot_MultiDB
demo of multiDB using SpringBoot

### framework:
1. SpringBoot

### DB:


## idea and workflow:
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
    the dynamicDataSource is more like a switch, the static threadlocal tells what DB to use.
    by setting that threadlocal during you create a request, we change the DB.
    


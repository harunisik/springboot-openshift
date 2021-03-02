package com.learn.springbootkubernetes;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    @Value("${name}")
    private String name;


    @RequestMapping("/")
    public String index() {
        logger.info("index method method has been called !");
        List<String> tableNames = new ArrayList<>();
        try {
            tableNames = showTables();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return "Hello " + name + ", Spring-Boot app successfully deployed....."
            + "Sys tables: " + tableNames;
    }

    @Autowired
    protected DataSource dataSource;

    public List<String> showTables() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
        List<String> tableNames = new ArrayList<>();
        while (tables.next()) {
            String tableName = tables.getString("TABLE_NAME");
            tableNames.add(tableName);
        }
        logger.info("Table List: " + tableNames.toString());
        return tableNames;
    }
}

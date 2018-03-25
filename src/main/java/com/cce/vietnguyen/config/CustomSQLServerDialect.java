package com.cce.vietnguyen.config;

import java.sql.Types;

/* 
 * author:vietnguyen
 * Lop nay thua ke lop SQlServerDialect
 * Khai bao them 1 kieu Nvarchar, vì lớp mặc định không hiểu kiểu Nvarchar trong SQLSERVER
 */
public class CustomSQLServerDialect extends org.hibernate.dialect.SQLServerDialect {

    public CustomSQLServerDialect() {
        registerHibernateType(Types.NVARCHAR, 4000, "string");
        registerHibernateType(Types.LONGNVARCHAR, "string");
        registerHibernateType(Types.NCLOB, "string");
        //registerHibernateType(Types.NUMERIC, "long");
    }

}
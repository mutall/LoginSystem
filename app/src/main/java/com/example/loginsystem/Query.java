package com.example.loginsystem;

public class Query {
    public static final String TABLE_NAME = "address";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +" (\n" +
            "\taddressId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\tname TEXT(50) NOT NULL,\n" +
            "\t\"number\" TEXT(15) NOT NULL\n" +
            ")";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public static final String INSERT_CONTACT = "INSERT INTO "+TABLE_NAME +"(name, number) VALUES(?, ?)";

    public static final String GET_ADDRESSES = "SELECT * FROM "+TABLE_NAME;

}

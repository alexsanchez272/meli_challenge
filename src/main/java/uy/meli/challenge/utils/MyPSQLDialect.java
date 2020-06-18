package uy.meli.challenge.utils;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL10Dialect;

public class MyPSQLDialect extends PostgreSQL10Dialect{
	
	public MyPSQLDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}

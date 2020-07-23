package com.freddiemac.datamanager.ws.featuredefinition;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import core.BaseTestContext;


@Configuration
@ComponentScan( basePackages =
{ "com.freddiemac.datamanager.ws.dao" } )
public class TestApplicationContext
{

   public static Properties properties;

   public TestApplicationContext() throws IOException
   {
      properties = BaseTestContext.initTestContextWithSLS();
   }

   @Bean( name = "SLSDataSource" )
   public DataSource getDataSourceSLS()
   {
      return BaseTestContext.getSLSDataSourceTestInfo( properties );
   }

   @Bean( name = "SLSJDBCTemplate" )
   public NamedParameterJdbcTemplate secondaryJdbcTemplate( @Qualifier( "SLSDataSource" ) DataSource datasource )
   {
      return new NamedParameterJdbcTemplate( datasource );
   }
}

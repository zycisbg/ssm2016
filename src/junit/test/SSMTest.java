package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SSMTest {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private DataSource dataSource = null;
	{
		dataSource = ioc.getBean(DataSource.class);
	}
	
	@Test
	public void testConnection() throws SQLException{
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		
	}
}

package cass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Sample REST + Cassandra application based on https://dzone.com/articles/spring-data-support-for-cassandra-3
 * 
 * Using MultiNode Cassandra setup
 * https://github.com/bcantoni/vagrant-cassandra
 * 
 * To create the tables use
 * https://dzone.com/articles/spring-data-support-for-cassandra-3
 * @author SHANELynch
 *
 */
@SpringBootApplication
public class SampleCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCassandraApplication.class, args);
	}

}

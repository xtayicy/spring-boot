package harry.spring.boot.neo4j.config;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Harry
 *
 */
//@Configuration
//@EnableNeo4jRepositories(basePackages = "harry.spring.boot.neo4j.repository")
//@EnableTransactionManagement
//@ConfigurationProperties(prefix="jdbc")
public class Neo4jConfig{
	/*private String driver;
	private String url;
	private String username;
	private String password;*/
	
	/*@Bean
	@Qualifier("dataSource")
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}*/
	
	/*@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException{
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("Mybatis-config.xml"));
		
		return sqlSessionFactory;
	}*/
	
	/*@Bean(name = "transactionManager")
    public DataSourceTransactionManager testTransactionManager(DataSource dataSource) {
        
		return new DataSourceTransactionManager(dataSource);
	}*/

	/*@Override
	@Bean
	protected DatabaseSelectionProvider databaseSelectionProvider() {
		return DatabaseSelectionProvider.createStaticDatabaseSelectionProvider("mysql");
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
}

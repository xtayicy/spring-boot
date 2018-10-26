package harry.spring.boot.actuator;

import harry.spring.boot.acutator.Application;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 
 * @author harry
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ActuatorApplicationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testHomeIsSecure() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.getForEntity("/",
				Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		@SuppressWarnings("unchecked")
		Map<String, Object> body = entity.getBody();
		assertThat(body.get("error")).isEqualTo("Unauthorized");
		assertThat(entity.getHeaders()).doesNotContainKey("Set-Cookie");
	}

	@Test
	public void testMetricsIsSecure() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.getForEntity(
				"/actuator/metrics", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		entity = this.restTemplate
				.getForEntity("/actuator/metrics/", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		entity = this.restTemplate.getForEntity("/actuator/metrics/foo",
				Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
		entity = this.restTemplate.getForEntity("/actuator/metrics.json",
				Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}

	@Test
	public void testHome() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.withBasicAuth("user",
				getPassword()).getForEntity("/", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		@SuppressWarnings("unchecked")
		Map<String, Object> body = entity.getBody();
		assertThat(body.get("message")).isEqualTo("Hello harry");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMetrics() {
		testHome(); // makes sure some requests have been made
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.withBasicAuth("user",
				getPassword()).getForEntity("/actuator/metrics", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Map<String, Object> body = entity.getBody();
		assertThat(body).containsKey("names");
		assertThat((List<String>) body.get("names")).contains(
				"jvm.buffer.count");

	}

	@Test
	public void testEnv() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate.withBasicAuth("user",
				getPassword()).getForEntity("/actuator/env", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		@SuppressWarnings("unchecked")
		Map<String, Object> body = entity.getBody();
		assertThat(body).containsKey("propertySources");
	}

	@Test
	public void healthInsecureByDefault() {
		ResponseEntity<String> entity = this.restTemplate.withBasicAuth("user",
				getPassword()).getForEntity("/actuator/health", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("\"status\":\"UP\"");
		assertThat(entity.getBody()).doesNotContain("\"hello\":\"1\"");
	}
	
	@Test
	public void infoInsecureByDefault() {
		ResponseEntity<String> entity = this.restTemplate.withBasicAuth("user",
				getPassword()).getForEntity("/actuator/info",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("\"someKey\":\"someValue\"");
	}
	
	@Test
	public void testErrorPage() {
		ResponseEntity<String> entity = this.restTemplate
				.withBasicAuth("user", getPassword()).getForEntity("/foo", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
		String body = entity.getBody();
		assertThat(body).contains("\"error\":");
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testBeans() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate
				.withBasicAuth("user", getPassword())
				.getForEntity("/actuator/beans", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).containsOnlyKeys("contexts");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testConfigProps() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.restTemplate
				.withBasicAuth("user", getPassword())
				.getForEntity("/actuator/configprops", Map.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Map<String, Object> body = entity.getBody();
		Map<String, Object> contexts = (Map<String, Object>) body.get("contexts");
		System.out.println(applicationContext.getId());
		System.out.println(DataSourceProperties.class.getName());
		Map<String, Object> context = (Map<String, Object>) contexts
				.get(this.applicationContext.getId());
		Map<String, Object> beans = (Map<String, Object>) context.get("beans");
		assertThat(beans)
				.containsKey("spring.datasource-" + DataSourceProperties.class.getName());
	}

	private String getPassword() {
		return "password";
	}
}

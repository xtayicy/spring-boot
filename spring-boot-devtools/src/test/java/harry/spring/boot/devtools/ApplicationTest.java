package harry.spring.boot.devtools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 
 * @author harry
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testStaticResource() {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("/css/application.css", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("color: green;");
	}
	
	@Test
	public void testPublicResource() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/public.txt",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("public file");
	}
	
	@Test
	public void testClassResource() {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("/application.properties", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}

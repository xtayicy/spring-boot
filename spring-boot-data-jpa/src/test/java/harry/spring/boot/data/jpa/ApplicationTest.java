package harry.spring.boot.data.jpa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author harry
 *
 */
@RunWith(SpringRunner.class)
// Enable JMX so we can test the MBeans (you can't do this in a properties file)
@SpringBootTest(properties = { "spring.jmx.enabled:true",
"spring.datasource.jmx-enabled:true" })
public class ApplicationTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testHome() throws Exception {
		this.mvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().string("Bath"));
	}
}

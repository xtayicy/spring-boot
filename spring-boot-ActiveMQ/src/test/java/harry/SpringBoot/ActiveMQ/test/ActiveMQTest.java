package harry.SpringBoot.ActiveMQ.test;
import static org.assertj.core.api.Assertions.assertThat;
import harry.SpringBoot.ActiveMQ.component.Producer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Autowired
	private Producer producer;
	
	@Test
	public void sendSimpleMessage() throws InterruptedException {
		this.producer.send("message");
		Thread.sleep(1000L);
		assertThat(this.outputCapture.toString().contains("message")).isTrue();
	}
}

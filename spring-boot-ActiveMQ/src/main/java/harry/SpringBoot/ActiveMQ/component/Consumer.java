package harry.SpringBoot.ActiveMQ.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author harry
 *
 */
@Component
public class Consumer {
	@JmsListener(destination = "queue")
	public void receiveQueue(String text) {
		System.out.println("consumer " + text);
	}
}

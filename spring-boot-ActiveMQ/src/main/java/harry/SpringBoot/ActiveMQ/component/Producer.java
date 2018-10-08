package harry.SpringBoot.ActiveMQ.component;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author harry
 *
 */
@Component
public class Producer implements CommandLineRunner{
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;

	@Override
	public void run(String... args) throws Exception {
		/*send("message");
		System.out.println("Message was sent to the Queue");*/
	}
	
	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}

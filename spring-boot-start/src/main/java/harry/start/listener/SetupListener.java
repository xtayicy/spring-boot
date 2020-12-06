package harry.start.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @author Harry
 *
 */
public class SetupListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof ApplicationStartingEvent){
			System.out.println("ApplicationStartingEvent......");
		}else if(event instanceof ApplicationEnvironmentPreparedEvent){
			System.out.println("ApplicationEnvironmentPreparedEvent....");
		}else if(event instanceof ApplicationPreparedEvent){
			System.out.println("ApplicationPreparedEvent.....");
		}else if(event instanceof ApplicationStartedEvent){
			System.out.println("ApplicationStartedEvent.....");
		}else if(event instanceof ApplicationReadyEvent){
			System.out.println("ApplicationReadyEvent....");
		}else if(event instanceof ApplicationFailedEvent){
			System.out.println("ApplicationFailedEvent....");
		}
	}
}

package harry.spring.boot.ant.test;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 
 * @author harry
 *
 */
public class AntTest {
	@Test
	public void test(){
		File target = new File("target");
		File[] jarFiles = target.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".jar");
			}
		});
		
		assertThat(jarFiles).hasSize(1);
	}
}

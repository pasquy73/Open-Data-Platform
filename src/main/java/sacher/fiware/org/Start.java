package sacher.fiware.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Start {
	
	private static Logger logger = LoggerFactory.getLogger(Start.class);
	
	public static void main(String[] args) {
		

		if (args.length >= 1) {
			String path = args[0];
			Sacher sacher = new Sacher();
			sacher.execute(path);
		} else {
			logger.info("Please use path file name in input [java -jar unibo.jar filename]");
		}

	}

}

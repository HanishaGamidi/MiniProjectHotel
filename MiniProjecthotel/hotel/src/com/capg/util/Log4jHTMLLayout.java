package com.capg.util;

import java.util.logging.Logger;

public class Log4jHTMLLayout {
	
	public Logger getlogger(){
		Logger logger = Logger.getLogger(Log4jHTMLLayout.class);
		
		PropertyConfigurator.configure("log4j.properties");
		
		return logger;
	}
	
	

}

package fr.fo.ud.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ITConfig {

	@Autowired
	private Environment env;
	
//	@Bean
//	public WebDriver webDriver() throws MalformedURLException {
//        return new RemoteWebDriver(getRemoteUrl(), getDesiredCapabilities());
//	}
//	
//	private DesiredCapabilities getDesiredCapabilities() {
//        return DesiredCapabilities.firefox();
//    }
//
//    private URL getRemoteUrl() throws MalformedURLException {
//        return new URL("http://localhost:8880/");
//    }
	
//	@Bean
//	public WebDriver webDriver() {
//	    return new FirefoxDriver();
//	}
}

package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionsManager {

	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	private Properties prop;
	private WebDriver driver;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {

		co = new ChromeOptions();

		if (Boolean.valueOf(prop.getProperty("headless"))) {
			co.setHeadless(true);
		}
		if (Boolean.valueOf(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {

		fo = new FirefoxOptions();

		if (Boolean.valueOf(prop.getProperty("headless"))) {
			fo.setHeadless(true);
		}
		if (Boolean.valueOf(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {

		eo = new EdgeOptions();

		if (Boolean.valueOf(prop.getProperty("headless"))) {
			eo.setHeadless(true);
		}
		if (Boolean.valueOf(prop.getProperty("incognito"))) {
			eo.addArguments("--incognito");
		}
		return eo;
	}
}

package com.qf.androidautomation.start;

import org.testng.TestNG;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws URISyntaxException {
		TestNG testNG = new TestNG();
		List<String> suites = new ArrayList<>();
		String directory = System.getProperty("user.dir");

		String filePath = directory + "/classes/testng.xml";
		System.out.println(filePath);
		URI resource = MainClass.class.getClassLoader().getResource("testng.xml").toURI();

		setTestSuites(testNG, resource);

		suites.add(filePath);
		testNG.setTestSuites(suites);
		testNG.run();
	}

	private static void setTestSuites(TestNG driver, URI ets) {
		if (ets.getScheme().equalsIgnoreCase("jar")) {
			// jar:{url}!/{entry}
			String[] jarPath = ets.getSchemeSpecificPart().split("!");
			File jarFile = new File(URI.create(jarPath[0]));
			driver.setTestJar(jarFile.getAbsolutePath());
			driver.setXmlPathInJar(jarPath[1].substring(1));
		} else {
			List<String> testSuites = new ArrayList<String>();
			File tngFile = new File(ets);
			if (tngFile.exists()) {
				System.out.printf("Using TestNG config file %s", tngFile.getAbsolutePath());
				testSuites.add(tngFile.getAbsolutePath());
			} else {
				throw new IllegalArgumentException("A valid TestNG config file reference is required.");
			}
			driver.setTestSuites(testSuites);
		}
	}
}

package com.qf.androidautomation.utils;

import java.io.IOException;

/**
 * The Class AVDStarter.
 */
public class AVDEmulatorStarter {

	/**
	 * Start AVD.
	 *
	 * @param avdName the name of the AVD
	 * @param emulatorPath the full path to the emulator executable
	 */
	public static void main(String[] args) {
		Config config = new Config();
		String deviceName = config.getProperty("android.devicename");
		try {
			String directory = System.getProperty("user.dir");
			String emulatorPath = "/Users/ejohn/Library/Android/sdk/emulator";
			System.out.print(directory);
			String command = emulatorPath + "/emulator -avd " + deviceName ;
			ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
			Process process = processBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

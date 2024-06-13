package com.qf.androidautomation.utils;

import java.io.IOException;

/**
 * The Class PortKiller.
 */
public class PortKiller {

	/**
	 * Kill port.
	 *
	 * @param port the port
	 */
	public static void killPort(String port) {
		try {
			String command = "npx.cmd kill-port " + port;
			ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
			Process process = processBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
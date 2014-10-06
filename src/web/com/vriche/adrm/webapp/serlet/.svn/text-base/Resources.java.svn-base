package com.vriche.adrm.webapp.serlet;

import java.io.DataInputStream;

public class Resources {
	
	private static ClassLoader loader = Resources.class.getClassLoader();
	 
	public static DataInputStream getResource(String fileName) {
		DataInputStream dis = new DataInputStream(loader.getResourceAsStream(fileName));
		return dis;
	}
}

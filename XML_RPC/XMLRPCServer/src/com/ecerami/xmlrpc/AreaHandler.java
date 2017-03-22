package com.ecerami.xmlrpc;

/**
 * Author: Tu Zhiying
 * XML-RPC Server Handler, whose function is calculating circular area
 */

public class AreaHandler {
	
	public double circleArea(double radius){
		System.out.println("Client's input parameter is " + radius);
		System.out.println("Server is Calculating Circle Area...");
		double value = (radius*radius*Math.PI);
		System.out.println("result is " + value);
		return value;
	}
}

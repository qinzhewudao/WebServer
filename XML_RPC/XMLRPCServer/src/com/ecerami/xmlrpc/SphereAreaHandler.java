package com.ecerami.xmlrpc;

/**
 * Author: Tu Zhiying
 * XML-RPC Server Handler, whose function is calculating sphere surface area
 */

public class SphereAreaHandler {
	
	public double sphereArea(double radius){
		System.out.println("Client's input parameter is " + radius);
		System.out.println("Server is Calculating Sphere Surface Area...");
		double value = (4*radius*radius*Math.PI);
		System.out.println("result is " + value);
		return value;
	}
	
	public double sphereAreaOfNums(double radius, int num){
		System.out.println("Client's input parameter is " + radius);
		System.out.println("Server is Calculating Sphere Surface Area...");
		double value = (4*radius*radius*Math.PI)*num;
		System.out.println("2result is " + value);
		return value;
	}
}

package test;

import loudnut_namer.Replacer;

public class MainTest {
	public static void main(String args[]){
		Replacer r = new Replacer("D:/James_Horner-The_Amazing_Spider_Man_OST-WEB-2012-FRAY", "_", " ");
		r.stringReplacementAll();
	}
}

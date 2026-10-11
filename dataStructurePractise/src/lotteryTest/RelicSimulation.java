package lotteryTest;

import java.util.ArrayList;
import java.util.Random;

public class RelicSimulation {
        public  static void main(String[] args) {
        	String[] types = {"DEF","ATK","Element-master","HP"};   //圣遗物非双爆词条
        	int[] initialValue = {13,18,23,28};
        	double[] AmountProbability = {0.8, 0.2};
        	double[] CRT_Arr = {2.7,3.0,3.3,3.6,3.9};     //双爆词条以及初始值
        	double[] CRT_DMG_Arr = {5.4,6.0,6.6,7.2,7.8};
        	ArrayList<String> RelicArr = new ArrayList<>();
        	Random typeRandom = new Random();       	
        	int num1 = typeRandom.nextInt(5);
        		RelicArr.add("CRT-RATE + " + CRT_Arr[num1] + "%");       	
        	int num2 = typeRandom.nextInt(5);
        		RelicArr.add("CRT-DMG + " + CRT_DMG_Arr[num2] + "%");  
        		
        	double number = typeRandom.nextDouble();
        	if(number <= AmountProbability[0]) {
        		int num3 = typeRandom.nextInt(4);
        		int num4 = typeRandom.nextInt(4);
        		RelicArr.add(types[num3] + " + " + initialValue[num4]);       		
        	}else {       	
        		
        		int num3 = typeRandom.nextInt(4);
        		int num4 = typeRandom.nextInt(4);
        		RelicArr.add(types[num3] + " + " + initialValue[num4]);  
        		int num5 = 0;
        		do {
        		 num5 = typeRandom.nextInt(4);
        		}while(num5 == num3);
        		int num6 = typeRandom.nextInt(4);
        		RelicArr.add(types[num5] + " + " + initialValue[num6]);     		
        	}
        	for(String Arr: RelicArr) {
        		System.out.println(Arr);       		       		
        	}  	
        }	
}

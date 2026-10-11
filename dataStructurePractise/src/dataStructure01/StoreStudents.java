package dataStructure01;

import java.util.*;

public class StoreStudents {
     public static void main(String[] args) {
    	 HashMap<String, Student> studentMap1 = new HashMap<>();
    	 HashMap<String, Student> studentMap2 = new HashMap<>();
    	 HashMap<String, Student> studentMap3 = new HashMap<>();
    	 HashMap<String, Student> studentMap4 = new HashMap<>();
    	 ArrayList<HashMap<String, Student>> studentList = new ArrayList<>();
    	 studentMap1.put("A123", new Student("Howard","ZheJiang"));
    	 studentMap2.put("A124", new Student("John","ShangHai"));
    	 studentMap3.put("A125", new Student("Doe","ZhuHai"));
    	 studentMap4.put("A126", new Student("ZhangSan","GuangZhou"));
    	 studentList.add(studentMap1);
    	 studentList.add(studentMap2);
    	 studentList.add(studentMap3);
    	 studentList.add(studentMap4);
    	 for(HashMap<String, Student> list:studentList) {
    		 
    	 System.out.println(list);
    	 
    	 }
     }
	
	
	
	
}

package javaPractice;
import java.util.*;
public class Test01 {
	PanpanDoor panpan;	
	  MeixinDoor meixin;
	public static void main(String[] args) {				
	    Door meixin = new MeixinDoor(300, 200, "meixinDoor", 534.2);	
	    List<Door> doorList = new ArrayList<>();
	    doorList.add(new PanpanDoor(300, 150, "panpanDoor", 200.5));
	    doorList.add(new MeixinDoor(300, 200, "meixinDoor", 250.0));
	    doorList.add(new Door1(350, 150, "door1", 745.9));	    
	    for(Door list:doorList) {
	    	list.open(list);
	    	list.close(list);	    	
	    	if(list.getName().equals("panpanDoor")) {
	    		PanpanDoor panpanDoor = (PanpanDoor) list;
	    		panpanDoor.alarm();	    		
	    	}
	    	list.printPrice(list);
	    }
	}	
}
   











     




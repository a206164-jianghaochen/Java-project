package driver;

public class Test004 {
      public static void main(String[] args) {
    	     
    	  VeryExcellentPeople yuanShen = new VeryExcellentPeople("YuanShen", "studyingHard", 10000000);
   System.out.println(yuanShen.getName() + " is a very excellent person, " +  "he has a great skill called " + yuanShen.getSkill() + " .The damage is also pretty hight which is " + yuanShen.getDamage());
       ITProfessional itprofessional = new ITProfessional("javaGiant" , 200000000.99, "superYuanShen");
       
       System.out.println(itprofessional);
      }
}
       class VeryExcellentPeople{
      String name;
      String skill;
      int damage;
      public VeryExcellentPeople(String name, String skill, int damage) {
    	  this.name = name;
    	  this.skill = skill;
    	  this.damage = damage;
      }
      public String getName() {
    	  return name;
      }
      public VeryExcellentPeople(String name) {
    	   System.out.println("ITProfessional" + name + " is my permanent model.");
    	  
    	  
    	  
      }
    	  public String getSkill() {
    		  return skill;
    	  }
    	  public int getDamage() {
    		  return damage;
	  
    	  }  
}
       class ITProfessional extends VeryExcellentPeople{
    	   String name;
    	   String expertise;
    	   String skill;
    	   double salary;
    	   public ITProfessional(String expertise, double salary, String name) {
    	   super(name);
    	   this.expertise = expertise;
    	   this.salary = salary;
    	   this.name = name;
       }
    	   public String getExpertise() {
    		   return expertise;
    		   
    	   }
    	   public double getSalary() {
    		   return salary;
    		   
    		   
    		   
    	   }
    	   public String toString() {
    		   return "ITProfessional " + name + " is one of the most prominent " + expertise + " in the world." + " His salary is " + salary;
    		   
    	   }
    	    
       
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       

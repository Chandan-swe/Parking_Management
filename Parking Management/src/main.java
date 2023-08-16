//This is Parking Management Project
//There are two area available for parking(Car & Bike)
//Parking Management is the super class which is inherited car and bkie class
//Parent class variable are used in child class by super using
//child class implements customer info and calculate bill
//In calculateBill() method use calender for showing check-in & check-out


import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;


abstract class Vehicles {
     public String name;
    public String model;
    public String color;
    public String license;
    
    
    String getLicense(){
        return license;
    }
    
    
    
    public abstract void calculateBill();
    
    
}

//child class Car inherited and implementing methods in interfaces
class Car extends Vehicles  implements ICustomerInfo{  //Inheritance
    public Car(String name, String model, String color, String license) {   //using super
        this.name=name;
        this.model=model;
        this.color=color;
        this.license=license;
        
    }
    Scanner CarScan=new Scanner(System.in);

    
    

    @Override
    public void showInfo() {                                //implementing customer's info
        System.out.println("\tCar Area");
       System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~  ");
       System.out.println("   Information & Billing      ");
       System.out.println("..............................");
     System.out.println("Car Name:" +name);
     
     System.out.println("Car Model:" +model);
 
     System.out.println("Car Color:" +color);
     
     System.out.println("License no:"+getLicense());
     
     
     
     System.out.println("Owner");
     String owner=CarScan.nextLine();
     
     System.out.println("Mobile No");
     String mobile=CarScan.nextLine();
     
     System.out.println("Driving License");
     String D_license=CarScan.nextLine();
     
     
     
    
    }

    @Override
    public void calculateBill() {              //Calculate parking time & make bill and also show check-in & out time
                                               //Car parking per hour 30tk and 0.5tk per min
        double parkHour;
        double receive;
        
        
        Calendar now = Calendar.getInstance();   //using time
   
    System.out.println("Check-In-Time: " + now.get(Calendar.HOUR_OF_DAY) //show check-in-time
                      + ":"
                      + now.get(Calendar.MINUTE)
                      );
    System.out.println("Enter Duration(count in minutes-at least 30 minutes)");
         parkHour=CarScan.nextDouble(); 
           //parking time should 30 minutes at least
      if(parkHour<30){
          System.out.println("Parking Hour at least 30 minutes");
      }
      else{
          
         now.add(Calendar.MINUTE, (int) parkHour);
 
    System.out.println("Check-Out-Time : "             //show check-out-time
                      + now.get(Calendar.HOUR_OF_DAY)
                      + ":"
                      + now.get(Calendar.MINUTE)
                      );
    if(parkHour<60){
        System.out.println("Parking Time: "+parkHour+ " min");
    }
    else{
        
        double time = parkHour/60;
        DecimalFormat df = new DecimalFormat("#.##");      
        time = Double.valueOf(df.format(time));
        System.out.println("Parking Time: "+time+ " h");
    }
    
    System.out.println("\tPayment");
    System.out.println("----------------------");
    System.out.println("Total payble: "+parkHour*.5+" tk");//bill
    System.out.println("Received");
    receive=CarScan.nextDouble();
    double change=receive-parkHour*.5;
    System.out.println("Received Amount: "+receive+" tk");
    System.out.println("Changed amount: "+change+" tk");
    System.out.println("\n");
      }
        
    }

  
    
    
    
}

//child class Bike inherited and implementing methods in interfaces
class Bike extends Vehicles implements ICustomerInfo{     //Inheritance
    Scanner BikeScan=new Scanner(System.in);
    public Bike(String name, String model, String color, String license) {   //using super
        this.name=name;
        this.model=model;
        this.color=color;
        this.license=license;
        
    }

    
    @Override
    public void showInfo() {                                   //implementing customer's info
        System.out.println("\tBike Area");
        System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~  ");
        System.out.println("   Information & Billing      ");
        System.out.println("..............................");
       System.out.println("Bike Name:" +name);
     
     System.out.println("Bike Model:" +model);
 
     System.out.println("Bike Color:" +color);
     
     System.out.println("License no:"+getLicense());
     
      
     System.out.println("Owner");
     String owner=BikeScan.nextLine();
     
     System.out.println("Mobile No");
     String mobile=BikeScan.nextLine();
     
     System.out.println("Driving License");
     String D_license=BikeScan.nextLine();
     
    }

    @Override
    public void calculateBill() {                //Calculate parking time &make bill
                                                 //Bike parking per hour 15tk and 0.25tk per min 
         double parkHour; 
        
         double receive;
        
        Calendar now = Calendar.getInstance();
   
    System.out.println("Check-In-Time: " + now.get(Calendar.HOUR_OF_DAY)  //show check-in-time
                      + ":"
                      + now.get(Calendar.MINUTE)
                      );
    
             //parking time should 30 minutes at least
              System.out.println("Enter Duration(count in minutes-at least 30 minutes)");
         parkHour=BikeScan.nextDouble();
      if(parkHour<30){
          System.out.println("Parking Hour at least 30 minutes");
      }
      else{
          
         now.add(Calendar.MINUTE, (int) parkHour);
 
    System.out.println("Check-Out-Time : "                     //show check-out-time
                      + now.get(Calendar.HOUR_OF_DAY)
                      + ":"
                      + now.get(Calendar.MINUTE)
                      );
    if(parkHour<60){
        System.out.println("Parking Time: "+parkHour+ " min");
    }
    else{
        double time = parkHour/60;
        DecimalFormat df = new DecimalFormat("#.##");      
        time = Double.valueOf(df.format(time));
        System.out.println("Parking Time: "+time+ " h");
        
    }
    System.out.println("\tPayment");
    System.out.println("----------------------");
    System.out.println("Total payble: "+parkHour*.25+" tk");   //bill 
    System.out.println("Recieved");
    receive=BikeScan.nextDouble();
    double change=receive-parkHour*.25;
    System.out.println("Received Amount: "+receive+" tk");
    System.out.println("Changed amount: "+change+" tk");
    System.out.println("\n");
    }
      
    }
    
}

public class main {
    
    public static void main(String[] args){
      Scanner input=new Scanner(System.in);
      Car c1=new Car("Toyota", "Allion A15", "Red", "DHA-15-1156");
      Bike b1= new Bike("Bajaj", "Pulser-150", "Black", "DHA-09-5638");
      System.out.println("    ||||||||||||||||||||||||||");
      System.out.println("   \tParking Management");
      System.out.println("    ||||||||||||||||||||||||||");
      
      
      System.out.println("Area \n 1.Car (press 1) \n 2.Bike (Press 2)");
      System.out.println(".................................");
      System.out.println("\tChoose Area");
      int check=input.nextInt();
      
      if(check==1){
      c1.showInfo();
      c1.calculateBill();
      }
      else{
      b1.showInfo();
      b1.calculateBill();
      }
     
      System.out.println("\t~~~~Thank You for Parking~~~~");
    }
}

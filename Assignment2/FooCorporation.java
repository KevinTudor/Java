/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/34c78de406d2935f4b23c8149111a81a_MIT6_092IAP10_assn02.pdf

Assignment 2: 
    Foo Corporation needs a program to calculate how much to pay their hourly employees. The US Department of Labor
requires that employees get paid time and a half for any hours over 40 that they work in a single week. For example, if an
employee works 45 hours, they get 5 hours of overtime, at 1.5 times their base pay. The State of Massachusetts requires
that hourly employees be paid at least $8.00 an hour. Foo Corp requires that an employee not work more than 60 hours in
a week.  

Rules:
    - An employee gets paid (hours worked) × (base pay), for each hour up to 40 hours.
    - For every hour over 40, they get overtime = (base pay) × 1.5.
    - The base pay must not be less than the minimum wage ($8.00 an hour). If it is, print an error.
    - If the number of hours is greater than 60, print an error message.
*/

package Assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class employee {
    
    String name;
    String pay;
    String hours;
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public String getPay() {
        return pay;
    }
  
    public void setPay(String pay) {
        this.pay = pay;
    }
  
    public String getHours() {
        return hours;
    }
  
    public void setHours(String hours) {
        this.hours = hours;
    }
  
    employee(String name, String pay, String hours) {
        this.name = name;
        this.pay = pay;
        this.hours = hours;
    }
}

public class FooCorporation {
    public static void main(String[] args) {
        
        employee e1 = new employee("Employee 1", "7.50", "35");
        employee e2 = new employee("Employee 2", "8.20", "47");
        employee e3 = new employee("Employee 3", "10.00", "73");

        List<employee> employeeList = new ArrayList<employee>(Arrays.asList(e1,e2,e3));
        HashMap<String, List<String>> employeeHashMap = new HashMap<String, List<String>>(); 

        for(employee e : employeeList) {            
            if (employeeHashMap.containsKey(e.name)) {
                employeeHashMap.get(e.name).add(e.pay+","+e.hours);
            } else {
                employeeHashMap.put(e.name, new ArrayList<String>());
                employeeHashMap.get(e.name).add(e.pay+","+e.hours);
            }
        }
        System.out.println(employeeHashMap);
    }
}
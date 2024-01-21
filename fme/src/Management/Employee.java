package Management;

public class Employee extends Person{
   private double salary;

   public Employee(String namae, int sai, double salary) {
      super(namae, sai);
      this.salary = salary;
   }

   public double getSalary() {
      return salary;
   }

   protected void setSalary(double salary) {
      this.salary = salary;
   }

   public void performTask(){
      System.out.println(getNamae() + " is working");
   }

   @Override
   public String toString() {
      return super.toString() + " - " + salary;
   }
}

package Management;

public class Manager extends Employee{
    public Manager(String namae, int sai, double salary) {
        super(namae, sai, salary);
    }

    public void Raise(Employee em, double inc){
        if(inc < 0){
            System.out.println("Invalid increase");
        }else{
            if(em == this){
                double ceo = inc;
                setSalary(getSalary() + ceo);
            }else{
                double sahodko = em.getSalary();
                double mginc = inc/2;

                em.setSalary(sahodko+inc);
                setSalary(getSalary()+mginc);
            }
        }
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString();
    }
}

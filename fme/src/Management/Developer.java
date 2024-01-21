package Management;

public class Developer extends Employee{
    private Manager pm;

    public Developer(String namae, int sai, double salary) {
        super(namae, sai, salary);
        this.pm = null;
    }

    public Manager getPm() {
        return pm;
    }

    protected void setPm(Manager mgn) {
            if(pm == null){
                pm = mgn;
            }else{
                System.out.println(getNamae() + " already hasa a manager");
            }
    }

    public boolean hasPM(){
        return pm != null;
    }

    public void fire(){
        pm = null;
    }

    @Override
    public void performTask() {
        System.out.println(getNamae() + " is coding");
    }

    @Override
    public String toString() {
        if(pm == null){
            return super.toString();
        }
        return super.toString() + " [" + pm.getNamae() + "]";
    }

    @Override
    public void bday() {
        super.bday();
        if(pm != null){
            double bdaygift = 0.05 * getSalary();
            pm.Raise(this, bdaygift);
        }

    }
}

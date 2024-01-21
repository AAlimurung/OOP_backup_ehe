package Management;

public class Customer extends Person{
    private String cn;
    private String en;

    public Customer(String namae, int sai) {
        super(namae, sai);
    }

    @Override
    public void performTask() {
        System.out.println(getNamae() + " is browsing through");
    }

    public void talk(Employee em){
        if(em instanceof Developer && getSai() > ((Developer)em).getSai() && ((Developer)em).getPm() != null){
            System.out.println("Can I see your manager " + ((Developer)em).getPm().getNamae() + "?");
        }
        System.out.println("Oh, hello, " + em.getNamae() + ". Can you assist me?");
    }

}

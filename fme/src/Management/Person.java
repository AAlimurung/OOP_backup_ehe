package Management;

public abstract class Person {
    private final String namae;
    private int sai;

    public Person(String namae, int sai) {
        this.namae = namae;
        this.sai = sai;
    }

    public String getNamae() {
        return namae;
    }

    public int getSai() {
        return sai;
    }

    public void setSai(int sai) {
        this.sai = sai;
    }

    public void bday(){
        System.out.println("Happy birthday, " + namae + "!");
        setSai(getSai()+1);
    }

    public abstract void performTask();

    @Override
    public String toString() {
        return namae + " (" + sai + ")";
    }
}

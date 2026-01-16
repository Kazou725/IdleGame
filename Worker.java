public class Worker {
    private int ID;
    private String name;
    private String lastName;
    private int potential;
    private int overall;
    private double moneyPerSecond;
    private double moneyPerClick;
    private double cost;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPotential() {
        return potential;
    }

    public void setPotential(int potential) {
        this.potential = potential;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }


    public double getMoneyPerSecond() {
        return moneyPerSecond;
    }

    public void setMoneyPerSecond(double moneyPerSecond) {
        this.moneyPerSecond = moneyPerSecond;
    }

    public double getMoneyPerClick() {
        return moneyPerClick;
    }

    public void setMoneyPerClick(double moneyPerClick) {
        this.moneyPerClick = moneyPerClick;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Worker(int ID, String name, String lastName, int potential, int overall,double moneyPerSecond, double moneyPerClick, double cost) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.potential = potential;
        this.overall = overall;
        this.moneyPerSecond = moneyPerSecond;
        this.moneyPerClick = moneyPerClick;
        this.cost = cost;
    }

}

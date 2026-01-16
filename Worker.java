public class Worker {
    private double moneyPerSecond;
    private double moneyPerClick;
    private double cost;

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

    public Worker(double moneyPerSecond, double moneyPerClick, double cost) {
        this.moneyPerSecond = moneyPerSecond;
        this.moneyPerClick = moneyPerClick;
        this.cost = cost;
    }
}

public class Player {
    private double money;
    private double moneyPerClick;
    private double moneyPerSecond;
    private int nbBasicWorker;

    public int getNbBasicWorker() {
        return nbBasicWorker;
    }

    public void setNbBasicWorker(int nbBasicWorker) {
        this.nbBasicWorker = nbBasicWorker;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoneyPerClick() {
        return moneyPerClick;
    }

    public void setMoneyPerClick(double moneyPerClick) {
        this.moneyPerClick = moneyPerClick;
    }

    public double getMoneyPerSecond() {
        return moneyPerSecond;
    }

    public void setMoneyPerSecond(double moneyPerSecond) {
        this.moneyPerSecond = moneyPerSecond;
    }

    public Player(double money, double moneyPerClick, double moneyPerSecond, int nbBasicWorker) {
        this.money = money;
        this.moneyPerClick = moneyPerClick;
        this.moneyPerSecond = moneyPerSecond;
        this.nbBasicWorker = nbBasicWorker;
    }

    public void addMoneyPerClick() {
        this.setMoney(this.getMoney() + this.getMoneyPerClick());
    }
    public void buyWorker(Worker worker){
        if(this.getMoney() >= worker.getCost()){
            this.setNbBasicWorker(this.getNbBasicWorker() + 1);
            this.setMoneyPerSecond(this.getMoneyPerSecond() + worker.getMoneyPerSecond());
            this.setMoneyPerClick(this.getMoneyPerClick() + worker.getMoneyPerClick());
            this.setMoney(this.getMoney() - worker.getCost());
        }
    }
    public void addMoneyPerSecond() {
        this.setMoney(this.getMoney() + this.getMoneyPerSecond());
    }
}

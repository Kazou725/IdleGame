public class Player {
    private double money;
    private double moneyPerClick;
    private double moneyPerSecond;
    private int[] workers;

    public int[] getWorkers() {
        return workers;
    }

    public void setWorkers(int[] workers) {
        workers = workers;
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

    public Player(double money, double moneyPerClick, double moneyPerSecond, int[] workers) {
        this.money = money;
        this.moneyPerClick = moneyPerClick;
        this.moneyPerSecond = moneyPerSecond;
        this.workers = workers;
    }

    public Player(double money, double moneyPerClick, double moneyPerSecond, int workerCount) {
        this(money, moneyPerClick, moneyPerSecond, new int[workerCount]);
    }

    public void addMoneyPerClick() {
        this.setMoney(this.getMoney() + this.getMoneyPerClick());
    }
    public void buyWorker(Worker worker){
        if (this.workers[0] != worker.getID())
        {
            this.workers[0] = worker.getID();
            this.setMoneyPerSecond(this.getMoneyPerSecond() + worker.getMoneyPerSecond());
            this.setMoneyPerClick(this.getMoneyPerClick() + worker.getMoneyPerClick());
            this.setMoney(this.getMoney() - worker.getCost());
            worker.setCost((worker.getCost() * 0.5) + worker.getCost());
        }
        else if(this.workers[0] == 0){
            if (worker.getOverall() < worker.getPotential())
            {
                worker.setOverall(worker.getOverall() + 1);
                this.setMoney(this.getMoney() - worker.getCost());
                this.setMoneyPerSecond(this.getMoneyPerSecond() + worker.getMoneyPerSecond());
                this.setMoneyPerClick(this.getMoneyPerClick() + worker.getMoneyPerClick());
                worker.setCost((worker.getCost() * 0.5) + worker.getCost());
            }
        }
    }
    public void addMoneyPerSecond() {
        this.setMoney(this.getMoney() + this.getMoneyPerSecond());
    }


    public int getWorkerCount(int workerId) {
        return workers[workerId];
    }
}

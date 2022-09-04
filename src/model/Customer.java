package model;

public class Customer {
    private int id;
    private int bonus;
    private boolean useBonus;

    public Customer(int id, int bonus) {
        this.id = id;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public boolean isUseBonus() {
        return useBonus;
    }

    public void setUseBonus(boolean useBonus) {
        this.useBonus = useBonus;
    }

    @Override
    public String toString() {
        return  "У вас " + bonus + " бонусных баллов.";
    }
}

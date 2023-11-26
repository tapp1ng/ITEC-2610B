public class Mob extends Entity {
    private int expDrop;
    private int goldDrop;
    
    public Mob(int hp2 , String name2, int dmg2,int expDrop2, int goldDrop2) {
        HP = hp2;
        name = name2;
        dmg = dmg2;
        expDrop = expDrop2; 
        goldDrop = goldDrop2;
    }

    public Mob() {
    }

    public int addGold (int money) {
        money = money+ goldDrop;
        return money;
    }

    public int addExp (int exp) {
        exp = exp + expDrop;
        return exp;
    }

    public int getExp () {
        return expDrop;
    }

    public int getGold () {
        return goldDrop;
    }

    public void setGold (int gold) {
        goldDrop = gold; 
    }

    public void setExpDrop (int newExp) {
        expDrop = newExp;
    }
}

public class Character extends Entity {
    public int exp;
    public int level;
    public int levelUpExp;
    public int price;

    public Character(int hp2 , String name2, int dmg2, int exp2, int level2, int levelUpExp2,int price2) {
        
        HP = hp2;
        name = name2;
        dmg = dmg2;
        exp = exp2;
        level = level2;
        levelUpExp = levelUpExp2;
        price = price2;
    }
    

    public Character() {
    }


    public void levelUp () {
        
            level += 1;
            HP += 150;
            dmg += 3;
            exp = 0;
            levelUpExp = levelUpExp + 25;
        
    }

    public int getExp () {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getLevelUpExp() {
        return levelUpExp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price2) {
        price = price2;
    }
    
    public void setExp(int exp2) {
        exp = exp + exp2;
    }

    public void setLevelUpExp(int levelUpExp2) {
        levelUpExp = levelUpExp2;
    }

    public void setLevel (int level2) {
        level = level2;
    }

}
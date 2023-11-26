public class Entity {
    public  int HP = 0;
    public  String name = "";
    public int dmg = 1;

    Entity() {
        HP = 0;
        name = "";
        dmg = 0;
}

    //when dealt dmg to
    public  int removeHP (int dmg) {
        HP = HP - dmg;
        return HP;
    }

    //check to see if dead after dmg is dealt
    public boolean isDead () {
        if (HP <= 0) {
            return true;
        }
        return false;
    }

    //get and set methods to use 
    public int getHealth () {
        return HP;
    }

    public int getDmg  () {
        return dmg;
    }

    public String getName () {
        return name;
    }

    public void setDmg (int newDmg) {
        dmg = newDmg;
    }

    public void setHP (int newHealth) {
        HP = newHealth;
    }

    public void setName (String newName) {
        name = newName;
    }
    
}

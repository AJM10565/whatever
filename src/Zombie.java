import java.util.ArrayList;

public class Zombie {
    private int HP = Constants.DefaultHP;
    private int Damage = Constants.DefaultDamage;
    private String name = "Unknown";
    public static ArrayList<Zombie> zombies = new ArrayList<>();








    public Zombie(){
        zombies.add(this);

    }


    public Zombie(int hp, int damage){
        setHP(hp);
        setDamage(damage);
        zombies.add(this);
    }

    private Zombie(int hp,int damage, String name){
        setDamage(damage);
        setHP(hp);
        setName(name);
        zombies.add(this);

    }

    public static Zombie makeZombie(Survivor infectedDead){
        int IDhp = infectedDead.getHP();
        int IDdamage = infectedDead.getDamage();
        String IDname = infectedDead.getName();
        Zombie result = new Zombie(IDhp,IDdamage,IDname);

        return result;
    }

    private Zombie makeZombiebylevel(int level){
        int hp = Constants.DefaultHP*level;
        int damage = Constants.DefaultDamage*level;
        Zombie ZN  = new Zombie(hp,damage);
        return ZN;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public int getDamage() {
        return Damage;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return Damage/10;
    }

    public int takeDamage(int damagetaken){
        this.HP = this.HP-damagetaken;
        if (this.HP<=0){
            zombies.remove(this);
            return this.getLevel();
        } else {
            return 0;
        }

    }
    public static int getAllDamage(){
        int damage = 0;
        for (Zombie z:zombies) {
            damage = damage + z.getDamage();
        }
        return damage;
    }

}

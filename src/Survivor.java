public class Survivor {
    private String name;
    private int MaxHP;
    private int HP = Constants.DefaultHP;
    private int Damage = Constants.DefaultDamage;
    private boolean infected = false;
    private Group group;

    @Override
    public String toString() {
        String status="";
        if (infected){
            status = "Infected";
        } else{
            status = "Healthy";
        }
        return name + ":"+
                HP+"/"+MaxHP+" HP" +
                ", Damage=" + Damage +", "+
                status ;
    }

    public Survivor(String name){
        setName(name);
        MaxHP = HP;



    }


    public void setDamage(int damage) {
        this.Damage = damage;
    }

    public void setHP(int HP) {
        this.HP = HP;
        if (this.getHP()<=0 && this.infected){
            System.out.println("Oh no!! " +this.getName() + " is now a Zombie. Watch Out Survivors!");
//            Group oldGroup = this.group;
            Zombie.makeZombie(this);
            if (this.inGroup()){
                this.group.removeSurvivor(this);

            }
//            System.out.println(oldGroup);

        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return Damage;
    }

    public int getHP() {
        return HP;
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public boolean inGroup(){
        return this.group != null;

    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void leaveGroup(){
        setGroup(null);
    }

    public void takeDamage(int damagetaken){
        setHP(this.HP-damagetaken);
    }
}

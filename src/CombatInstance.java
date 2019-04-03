import java.util.ArrayList;

public class CombatInstance {
    private ArrayList<Zombie> zombies;
    private Group group;


    public CombatInstance(ArrayList<Zombie> z, Group g) {
        setGroup(g);
        setZombies(z);

    }

    public void doBattle() {
        int NumberofZombiesAtStart = zombies.size();
        int Round = 0;
        Round(NumberofZombiesAtStart, Round);


    }

    private void Round(int numberofZombiesAtStart, int round) {

        while (group.getDamage()>=0 && Zombie.getAllDamage() >= 0) {
            int damage_bonus = 0;
            System.out.println("Round: " + round);
            System.out.println(group);

            int Zdamage = Zombie.getAllDamage();
            int GroupDamage = group.getDamage();



            damage_bonus = SurvivorHit(GroupDamage,Zdamage);

            // then the humans get damage increased
            Buff(damage_bonus);
            // then the zombies remaining attack all humans equally
            System.err.println("group Damage: " + group.getDamage());
            if (group.getDamage()>0){
                group.takeDamage(Zdamage);
            } else {
                System.out.println("GAME OVER. Zombies rule the world now. It is a new reality!");
                return;
            }

            System.out.println("Number of Zombies Remaining: " + zombies.size() + " / " + numberofZombiesAtStart + " is less than " + (numberofZombiesAtStart +group.getMembers().size()));
            round++;
        }
    }

    private void Buff(int damage_bonus) {
        if (damage_bonus>0){
            group.buffGroup(damage_bonus);
        }
    }


    private int SurvivorHit(int GroupDamage, int Zdamage){
        int damage_bonus = 0;
        while ((GroupDamage > 0) && (Zombie.getAllDamage() > 0)&& !zombies.isEmpty()) {
            Zombie Z_attacked = zombies.get(0);
            int predamageZombieHealth = Z_attacked.getHP();
            System.err.println("Zombie HP: " + Z_attacked.getHP());
            System.out.println("Survivors hit Zombie for " + GroupDamage + " Damage.");
            int deadZlevel = Z_attacked.takeDamage(GroupDamage);
            System.err.println("Zombie HP: " + Z_attacked.getHP());
            if (Z_attacked.getHP()<=0){
                Zdamage = Zdamage-Z_attacked.getDamage();
                System.out.println("Zombie Level: " + deadZlevel + "  is dead!");
                damage_bonus += deadZlevel;
                int damage_dealt = GroupDamage-predamageZombieHealth;
                GroupDamage = GroupDamage - damage_dealt;
                System.err.println("Damage left:" +GroupDamage);

            } else {
                GroupDamage = 0;
            }
        }
        return damage_bonus;
    }




    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Survivor> family;

    public Group(String name){
        setName(name);
        family = new ArrayList<>();
    }

    public void addSurvivor(Survivor newbie){

        if (!family.contains(newbie) && newbie.getHP()>0 && !newbie.isInfected() && !newbie.inGroup()){
            family.add(newbie);
            newbie.setGroup(this);
        }
    }
    public void removeSurvivor(Survivor member){
        if (family.contains(member)){
            this.family.remove(member);
            member.leaveGroup();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Survivor> getMembers(){
        return this.family;
    }

    public int getDamage() {
        int damage = 0;
        for (Survivor s:family) {
            damage += s.getDamage();
        }
        if (damage==0) return -1000;
        return damage;
    }

    public int getMemberCount() {
        return family.size();
    }

    public void buffGroup(int amount){
        System.out.println("Group members Buffed by +" + amount + " Damage.");
        for(Survivor s:family){
            s.setDamage(s.getDamage()+amount);
        }
    }
    public void takeDamage(int amount){

        int Damageportion = amount/this.getMemberCount();
        System.out.println("Group members take " +Damageportion + " Damage.");
        for (int i=0;i<family.size();i++) {
            Survivor s = family.get(i);
            s.setInfected(true);
            s.takeDamage(Damageportion);
        }
    }
    @Override
    public String toString(){
        StringBuilder printString = new StringBuilder(this.name +  "\n" +"--------------------------------------------"+"\n");
        for(Survivor s:family){
            printString.append(s.toString());
            printString.append("\n");
        }
        return printString.toString();
    }
}

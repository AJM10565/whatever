public class ZombieApocalypse {

    public static void main(String[] args) {
        boolean game_guard = true;
        while(game_guard){
            Group g1 = new Group("Celebrities");
            Survivor s1 = new Survivor("Bonzo");
            Survivor s2 = new Survivor("t1");
            Zombie z1 = new Zombie(100,10);
            Zombie z2 = new Zombie(200,20);
            Zombie z3 = new Zombie(3000,40w);

            g1.addSurvivor(s1);
            g1.addSurvivor(s2);

            CombatInstance combat1 = new CombatInstance(Zombie.zombies,g1);
            combat1.doBattle();
            System.out.println(g1);


        }






    }


}

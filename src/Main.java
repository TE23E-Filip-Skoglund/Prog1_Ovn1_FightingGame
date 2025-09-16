import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Random randomgenerator = new Random();


    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");

        // Contains the stats of the first character (hp, mana, damage)
        ArrayList<Integer> stats1 = new ArrayList<>();
        stats1.add(100);
        stats1.add(randomgenerator.nextInt(21, 80));
        stats1.add(randomgenerator.nextInt(21, 80));

        // Contains the stats of the second character (hp, mana, damage)
        ArrayList<Integer> stats2 = new ArrayList<>();
        stats2.add(100);
        stats2.add(randomgenerator.nextInt(21, 80));
        stats2.add(randomgenerator.nextInt(21, 80));

        // Print character stats to check if it works
        System.out.println("Character 1 has " + stats1.get(0) + " hp.");
        System.out.println("Character 2 has " + stats2.get(0) + " hp.");


        // Initialize standard attack (smakareu attack)
        int newhp = standardAttack(stats1.get(2), stats2.get(0));
        stats2.set(0, newhp);
        System.out.println("Character 1 hit character two, \nThey now only have " + newhp + "hp left");

    }

    // Method for standard attack
    public static int standardAttack(int damage, int hp) {
        int chance = randomgenerator.nextInt(100); // generates a number 0-99
        if (chance < 67) {
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        } else {
            hp = hp - damage;
            System.out.println("Critical hit");
        }
        return hp;
    }

    // Method for special attack
    public static void specialAttack() {

    }


    /*
    TODO: fix special attack
     */
}
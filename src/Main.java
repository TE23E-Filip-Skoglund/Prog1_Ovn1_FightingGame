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
        System.out.println("Character 1 has " + stats1.getFirst() + " hp.");
        System.out.println("Character 2 has " + stats2.getFirst() + " hp.");


        // Initialize standard attack (smakareu attack)
        int newhp = standardAttack(stats1.get(2), stats2.getFirst());
        stats2.set(0, newhp);
        System.out.println("Character 1 hit character 2, \nThey now only have " + newhp + "hp left");

        // Initialize special attack (Supersmakaerueu attackish)
        int[] hpMana = specialAttack(stats2.get(2), stats2.get(1), stats1.getFirst());
        stats1.set(0, hpMana[0]);
        stats2.set(1, hpMana[1]);
        System.out.println("Charcter 2 hit character 1, \nThey now only have " + hpMana[0] + "hp left");
        System.out.println("Character 2 now has " + stats2.get(1) + " mana left");

        // TODO: Fix game loop in seperate method
        //          Start with user interaction
        //          After let AI hit back with random choice
        //          If time:  Make AI more clever in attack choice
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
    public static int[] specialAttack(int damage, int mana, int hp) {

        if (mana - 20 < 0) {
            System.out.println("The special attack isn't available. You need more mana.");
        } else {
            // utför attacken
            hp = (int) (hp - 0.25 * damage);
            mana -= 20;
        }

        int[] returnArray = {hp, mana};
        return returnArray;
    }


}
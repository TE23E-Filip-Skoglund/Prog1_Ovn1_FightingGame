import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Random randomgenerator = new Random();
    static Scanner myscan = new Scanner(System.in); // Ansvarar för att läsa av tangentbordet


    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");

        int choice = chooseCharacter();

        // Create the placeholders for the characters
        ArrayList<Integer> mainCharacter;
        ArrayList<Integer> enemy;
        mainCharacter = createCharacter();
        enemy = createCharacter();

        startGame(mainCharacter, enemy);

        /*

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

         */

        // TODO: Fix game loop in seperate method
        //          Start with user interaction
        //          After let AI hit back with random choice
        //          If time:  Make AI more clever in attack choice
    }

    public static void startGame(ArrayList<Integer> mainCharacter, ArrayList<Integer> enemy) {
        System.out.println("DING DING DING 🔔🔔🔔");
        System.out.println("START FIGHT 💪💪💪");

        while (mainCharacter.getFirst() > 0 && enemy.getFirst() > 0) {
            standardAttack(mainCharacter.get(2), enemy.getFirst());

            int newHp = standardAttack(mainCharacter.get(2), enemy.getFirst());
            enemy.set(0, newHp);
            System.out.println("You hit the enemy, \nThey now have " + newHp + "hp left");

            if (enemy.getFirst() < 0) {
                System.out.println("You won!");
                break;
            } else {
                newHp = standardAttack(enemy.get(2), mainCharacter.getFirst());
                mainCharacter.set(0, newHp);
                System.out.println("The enemy hit you, \nYou now have " + newHp + "hp left");
            }

        }
    }


    public static ArrayList<Integer> createCharacter() {
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(100);
        stats.add(randomgenerator.nextInt(21, 80));
        stats.add(randomgenerator.nextInt(21, 80));

        return stats;
    }

    public static int chooseCharacter() {
        int choice;

        do {
            System.out.println("Do you want to play as character 1 or character 2? (1-2)");
            try {
                choice = Integer.valueOf(myscan.nextLine());
                System.out.println("You choose character " + choice);
                switch (choice) {
                    case 1, 2:
                        return choice;
                    default:
                        System.out.println("That is not a valid choice. (1-2)");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number");
            }


        } while (true);


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
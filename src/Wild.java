import java.util.Random;
import java.util.Scanner;

public class Wild {
    private Ball ball;
    private Scanner scan;

    public Wild(Ball ball){
        scan = new Scanner(System.in);
        this.ball = ball;
    }

    public boolean catchPokemon() {
        Random rand = new Random();
        double opportunity;
        double pokeball = 0;
        String wanting = "random";
        boolean word = false;
        boolean run = true;

        while(run){
            if(wanting.equals("random"))
                pokeball = ball.typeBall();
            System.out.print("<use,random,escape> :");
            wanting = scan.next();
            if(wanting.equals("use")){
                double mood = rand.nextDouble();
                opportunity = pokeball*mood;
                if(opportunity > 0.5){
                    System.out.println("============================");
                    System.out.println("Success");
                    System.out.println("============================");
                    word = true;
                    run = false;
                }
                else{
                    System.out.println("============================");
                    System.out.println("Fail");
                    System.out.println("============================");
                    word = false;
                    run = false;
                }
            }
            else if(wanting.equals("random")){
                double escape = rand.nextDouble();
                if(escape > 0.5){
                    System.out.println("=======================");
                    System.out.println("Pokemon Escape!!");
                    System.out.println("=======================");
                    run = false;
                }

            }
            else if(wanting.equals("escape")){
                System.out.println("=======================");
                System.out.println("Player Escape!!");
                System.out.println("=======================");
                run = false;
            }
        }

        return word;
    }
}

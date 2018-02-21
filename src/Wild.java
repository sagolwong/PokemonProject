import java.util.Random;

public class Wild {

    public boolean catchPokemon(double pokeball) {
        Random rand = new Random();
        double opportunity;

        double mood = rand.nextDouble();
        opportunity = pokeball*mood;
        if(opportunity > 0.5){
            System.out.println("Success");
            return true;
        }
        else{
            System.out.println("Fail");
            return false;
        }
    }
}

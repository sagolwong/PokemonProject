import java.util.Random;

public class Ball {

    public double typeBall(){
        Random rand = new Random();
        double pokeball = 0;

        int numPokeball = rand.nextInt(3);
        System.out.print("You get ");
        if(numPokeball == 0){
            System.out.println("PokeBall!!");
            pokeball = 0.8;
        }
        else if(numPokeball == 1){
            System.out.println("GreatBall!!");
            pokeball = 0.9;
        }
        else if(numPokeball == 2) {
            System.out.println("UltraBall!!");
            pokeball = 1.0;
        }
        return pokeball;
    }

}

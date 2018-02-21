import java.util.Random;

import java.util.Scanner;

public class CommandPlayer {
    private PokemonCenter pokemonCenter;
    private Wild wild;
    private Scanner commandScanner;
    private boolean isRunning;

    public CommandPlayer(PokemonCenter pokemonCenter,Wild wild){
        this.pokemonCenter = pokemonCenter;
        this.wild = wild;
        commandScanner = new Scanner(System.in);
        isRunning = false;
    }
    public  void runGame(){
        isRunning = true;
        String want;

        while(isRunning){
            System.out.println("Where do you want to go?");
            System.out.print("<pokemoncenter,wild,quit> :");
            want = commandScanner.next();
            if(want.equals("pokemoncenter")) this.pokemonCenter();
            else if(want.equals("wild")) this.wild();
            else if(want.equals("quit")){
                isRunning = false;
                System.out.print("Goodbye~~");
            }
            else System.out.println("Try agains.");
        }

    }
    private void wild(){
        boolean isRunning1 = true;
        String command1;

        while(isRunning1){
            System.out.println("What do you want to do? catch wild pokemon or quit?");
            System.out.println("<catch,quit>");
            command1 = commandScanner.next();

            if(command1.equals("catch")) this.catchPoke();
            else if(command1.equals("quit")){
                isRunning1 = false;
                System.out.println("~~~~~~~~~~~");
            }
        }
    }

    private void pokemonCenter(){
        boolean isRunning2 = true;
        String command;

        System.out.println("Welcome to PokemonCenter");
        while(isRunning2){
            System.out.print("What do you want?(add,list,feed,walk,exercise,quit):");
            command = commandScanner.next();

            if(command.equals("quit")){
                isRunning2 = false;
                System.out.println("See you~~");
            }
            else if(command.equals("add"))
                this.addPokemon();
            else if(command.equals("list"))
                this.listPokemons();
            else if(command.equals("feed"))
                this.feedPokemons();
            else if(command.equals("walk"))
                this.walkPokemons();
            else if(command.equals("exercise"))
                this.exercisePokemons();
        }
    }

    private void catchPoke(){
        Random rand = new Random();
        double pokeball = 0;
        boolean opportunity = false;

        int numOfPoke = rand.nextInt(3);
        int numPokeball = rand.nextInt(3);
        System.out.print("You get ");
        if(numPokeball == 1){
            System.out.println("PokeBall");
            pokeball = 0.8;
        }
        else if(numPokeball == 2){
            System.out.println("GreatBall");
            pokeball = 0.9;
        }
        else if(numPokeball == 3) {
            System.out.println("UltraBall");
            pokeball = 1.0;
        }
        System.out.println("...Wait.a.minute...");
        if(numOfPoke == 1){
            System.out.println("You found Dragonair!!");
            System.out.println(".....................");
            opportunity = wild.catchPokemon(pokeball);
        }
        else if(numOfPoke == 2){
            System.out.println("You found Magikarp!!");
            System.out.println(".....................");
            opportunity = wild.catchPokemon(pokeball);
        }
        else if(numOfPoke == 3){
            System.out.println("You found Ponyta!!");
            System.out.println(".....................");
            opportunity = wild.catchPokemon(pokeball);
        }

        if(opportunity){
            System.out.print("What do you want to do with ");
            if(numOfPoke == 1) System.out.println("Dragonair");
            else if(numOfPoke == 2) System.out.println("Magikarp");
            else if(numOfPoke == 3) System.out.println("Ponyta");

            System.out.print("<keep,release>");

        }
    }

    private void addPokemon(){
        String pokemonType;
        String name;

        System.out.println("What pokemon do you want to catch?");
        System.out.println("<Dragonair,Magikarp,Ponyta>: ");
        pokemonType = commandScanner.next();
        System.out.print("Name of "+pokemonType+" is ");
        name = commandScanner.next();
        float weight = 10f;
        float stepLength = 5f;

        if(pokemonType.equals("Dragonair")){
            Dragonair dragonair = new Dragonair(name, weight, stepLength);
            pokemonCenter.addPokemon(dragonair);
        }
        else if(pokemonType.equals("Magikarp")){
            Magikarp magikarp = new Magikarp(name,weight,stepLength);
            pokemonCenter.addPokemon(magikarp);
        }
        else if(pokemonType.equals("Ponyta")) {
            Ponyta ponyta = new Ponyta(name, weight, stepLength);
            pokemonCenter.addPokemon(ponyta);
        }
        else
            System.out.println("Don't have Pokemon do you want.");
    }

    private void listPokemons(){
        System.out.println("==========================================");
        System.out.println("Pokemon List");
        System.out.println("==========================================");
        this.pokemonCenter.list();
        System.out.println("==========================================");
    }

    private void feedPokemons(){
        this.pokemonCenter.list();
        System.out.print("Which pokemon do you want to feed? ");
        String name = this.commandScanner.next();
        this.pokemonCenter.feed(name);

    }

    private void walkPokemons(){
        System.out.print("Which pokemon do you want to walk with you? ");
        String name = this.commandScanner.next();
        this.pokemonCenter.walk(name);
    }
    private void exercisePokemons(){
        System.out.print("Which pokemon do you want to exercise? ");
        String name = this.commandScanner.next();
        this.pokemonCenter.exercise(name);
    }
}

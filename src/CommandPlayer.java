import java.util.Random;

import java.util.Scanner;

public class CommandPlayer {
    private PokemonCenter pokemonCenter;
    private Backpack backpack;
    private Wild wild;
    private Scanner commandScanner;
    private boolean isRunning;

    public CommandPlayer(PokemonCenter pokemonCenter,Wild wild,Backpack backpack){
        this.pokemonCenter = pokemonCenter;
        this.backpack = backpack;
        this.wild = wild;
        commandScanner = new Scanner(System.in);
        isRunning = false;
    }
    public  void runGame(){
        isRunning = true;
        String wanting;

        while(isRunning){
            System.out.println("Where do you want to go?");
            System.out.print("<pokemoncenter,wild,quit> :");
            wanting = commandScanner.next();
            if(wanting.equals("pokemoncenter")) this.pokemonCenter();
            else if(wanting.equals("wild")) this.wild();
            else if(wanting.equals("quit")){
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
            System.out.println("What do you want to do? catch wild pokemon or leave?");
            System.out.print("<catch,list,leave> :");
            command1 = commandScanner.next();

            if(command1.equals("catch")) this.catchPokemon();
            else if(command1.equals("list")) this.listWildPokemon();
            else if(command1.equals("leave")){
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
            System.out.print("What do you want?(buy,list,feed,walk,exercise,leave):");
            command = commandScanner.next();

            if(command.equals("leave")){
                isRunning2 = false;
                System.out.println("See you~~");
            }
            else if(command.equals("buy"))
                this.buyPokemon();
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

    private void catchPokemon(){
        Random rand = new Random();
        String type = "";
        boolean run = true;
        boolean opportunity = false;

        int numOfPoke = rand.nextInt(3);
        System.out.println("...Finding Wild Pokemon...");
        if(numOfPoke == 0){
            System.out.println("----------------------------");
            System.out.println("You found Dragonair!!");
            System.out.println("----------------------------");
            type = "Dragonair";
            opportunity = wild.catchPokemon();
        }
        else if(numOfPoke == 1){
            System.out.println("----------------------------");
            System.out.println("You found Magikarp!!");
            System.out.println("----------------------------");
            type = "Magikarp";
            opportunity = wild.catchPokemon();
        }
        else if(numOfPoke == 2){
            System.out.println("----------------------------");
            System.out.println("You found Ponyta!!");
            System.out.println("----------------------------");
            type = "Ponyta";
            opportunity = wild.catchPokemon();
        }

        if(opportunity){
            System.out.print("You get "+type+" ");
            while(run){
                System.out.print("<keep,release> :");
                String wantto = commandScanner.next();
                if(wantto.equals("keep")){
                    System.out.print("Enter Name of "+type+" :");
                    String name = commandScanner.next();
                    float weight = 10f;
                    float stepLength = 5f;

                    if(type.equals("Dragonair")){
                        Dragonair dragonair = new Dragonair(name, weight, stepLength);
                        backpack.addPokemon(dragonair);
                    }
                    else if(type.equals("Magikarp")){
                        Magikarp magikarp = new Magikarp(name,weight,stepLength);
                        backpack.addPokemon(magikarp);
                    }
                    else if(type.equals("Ponyta")) {
                        Ponyta ponyta = new Ponyta(name, weight, stepLength);
                        backpack.addPokemon(ponyta);
                    }
                    run = false;
                }
                else if(wantto.equals("release")){
                    System.out.println("=======================");
                    System.out.println("Pokemon Escape!!");
                    System.out.println("=======================");
                    run = false;
                }
            }


        }
    }

    private void listWildPokemon(){
        System.out.println("==========================================");
        System.out.println("Pokemon List (in backpack)");
        System.out.println("==========================================");
        this.backpack.list();
        System.out.println("==========================================");
    }

    private void buyPokemon(){
        String pokemonType;
        String name;

        System.out.println("What pokemon do you want to buy?");
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
        System.out.println("Pokemon List (in farm)");
        System.out.println("==========================================");
        this.pokemonCenter.list();
        System.out.println("==========================================");
        System.out.println("==========================================");
        System.out.println("Pokemon  List (in backpack)");
        System.out.println("==========================================");
        this.backpack.list();
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

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Pokemon> pokemons;
    public Backpack(){ pokemons = new ArrayList<Pokemon>(); }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public void list(){
        for(Pokemon pokemon: pokemons){
            pokemon.print();
        }
    }
}

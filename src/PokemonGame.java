public class PokemonGame {
    public static void main(String[] args){
        PokemonCenter pokemonCenter = new PokemonCenter();
        Wild wild = new Wild();
        CommandPlayer commandPlayer = new CommandPlayer(pokemonCenter,wild);

        commandPlayer.runGame();
    }

}

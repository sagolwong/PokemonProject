public class PokemonGame {
    public static void main(String[] args){
        PokemonCenter pokemonCenter = new PokemonCenter();
        Backpack backpack = new Backpack();
        Ball ball = new Ball();
        Wild wild = new Wild(ball);
        CommandPlayer commandPlayer = new CommandPlayer(pokemonCenter,wild,backpack);

        commandPlayer.runGame();
    }

}

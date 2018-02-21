public class Pokemon {
    private String name;
    private float weight;
    private float stepLength;
    private int step;
    private float gainingWeightStep;
    private String[] types;

    public Pokemon(String name,
                   float weight,
                   float stepLength,
                   float gainingWeightStep,
                   String[] types){
        this.name = name;
        this.weight = weight;
        this.stepLength = stepLength;
        this.gainingWeightStep = gainingWeightStep;
        this.types = types;
        step = 0;
    }

    public String getName(){
        return name;
    }
    public void exercise(){ weight -= 0.5; }

    public void walk(){ step += 2; }

    public void eat(){
        weight += gainingWeightStep;
    }

    public void print(){
        System.out.println("Pokemon name: " + name);
        System.out.print("        Type: ");
        for(String type: types){
            System.out.print(type+",");
        }
        System.out.println();
        System.out.println("      Weight: " + weight);
        System.out.println(" Step length: " + stepLength);
        System.out.println("  Today Step: " + step);
        System.out.println("------------------------------------------");
    }
}

public class Item {

    private String name;
    private double value;
    private double weight;
    
    //constructor
    public Item(String name, double value, double weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }
    //getter
    public String getName() {
        return this.name;
    }
    public double getValue() {
        return this.value;
    }
    public double getWeight() {
        return this.weight;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    } 
    
}   

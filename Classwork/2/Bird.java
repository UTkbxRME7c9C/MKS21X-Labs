public class Bird extends Animal {
    private double height;
    private String color;

    public Bird(String noise, int age, String name, double height, String color){
        super(noise, age, name);
        this.height = height;
        this.color = color;
    }


    public void speak(){
      super.speak();
      System.out.println("I am " + color + ". I am " + height + " inches tall.");
    }
}

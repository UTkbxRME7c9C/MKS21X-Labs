public class Animal {
    private String noise;
    private int age;
    private String name;

    public Animal(String noise, int age, String name){
      this.noise = noise;
      this.age = age;
      this.name = name;
    }

    public String getName() {
        return name;
    }

    public void speak(){
      System.out.println("My name is "+ name + ". I am "+ age + " years old. Say " + noise+".");
    }
}

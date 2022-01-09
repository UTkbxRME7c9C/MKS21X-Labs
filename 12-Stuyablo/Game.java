public class Game{
  public static void HPstat(Adventurer o){
    System.out.println(o+" ("+o.getHP()+ "HP)" );
  }
  public static void main(String[] args) {
    Adventurer a = new Warrior("Conan","Aaaaaaaar!",20);
    Adventurer b = new Wizard("Homer","Donuts?",20);
    HPstat(a);
    HPstat(b);
    a.attack(b);
    b.attack(a);
    HPstat(a);
    HPstat(b);
    a.specialAttack(b);
    b.specialAttack(a);
    HPstat(a);
    HPstat(b);
    a.heal();
    b.heal();
    HPstat(a);
    HPstat(b);
    a.specialHeal(b);
    b.specialHeal(a);
    HPstat(a);
    HPstat(b);
    }

}

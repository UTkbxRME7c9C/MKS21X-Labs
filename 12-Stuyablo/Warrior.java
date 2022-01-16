public class Warrior extends Adventurer {
    private int rage;
    private String warcry;
    private int maxrage;

    public Warrior(){
	     this("Magnus");
    }

    public Warrior(String name){
	     this(name,"Valhalllaaaaa!!", 20);
    }

    public Warrior(String name, String warcry, int rage){
      super(name);
      setWarcry(warcry);
      setSpecial(rage);
      setSpecialMax(rage);
    }

    public Warrior(String name, String warcry, int rage, int health){
      super(name, health);
      setWarcry(warcry);
      setSpecial(rage);
      setSpecialMax(rage);
    }

    //warrior methods

    public void attack(Damageable other){
      int damage = (int)(Math.random()*10)+1;
      other.applyDamage(damage);
      if (getSpecialMax() > getSpecial()){
        setSpecial(getSpecial() + 1);
      }
      System.out.println(this + " attacked " + other + " for " +damage + " HP!");
    }

    public void specialAttack(Damageable other){
      int damage = (int)(Math.random()*20)+1;
      other.applyDamage(damage);
      System.out.println(this + " unleashes his fury upon "+ other + " for " + damage + " HP! "+warcry);
      setSpecial(getSpecial()-10);
    }

    public void heal(int newheal){
      applyHeal(newheal);
      System.out.println(this + " mends themselves for " + newheal + " HP! "+warcry);
      setSpecial(getSpecial()-10);
    }

    //get methods

    public String getSpecialName(){
      return "Rage";
    }
    public int getSpecial(){
	     return rage;
    }

    //set methods
    public void setSpecial(int r){
	     this.rage = r;
    }

    public void setWarcry(String warcry){
	     this.warcry = warcry;
    }
    public void setSpecialMax(int r){
      this.maxrage = r;
    }
    public int getSpecialMax(){
      return maxrage;
    }
    public String getWarcry(){
      return warcry;
    }
}

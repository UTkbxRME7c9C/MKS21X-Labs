public class Wizard extends Adventurer {
    private int mana;
    private String warcry;
    private int maxmana;

    public Wizard(){
	     this("Glaxus");
    }

    public Wizard(String name){
	     this(name,"No more exist!!", 20);
    }

    public Wizard(String name, String warcry, int mana){
      super(name);
      setWarcry(warcry);
      setSpecial(mana);
      setSpecialMax(mana);
    }

    public Wizard(String name, String warcry, int rage, int health){
      super(name, health);
      setWarcry(warcry);
      setSpecial(rage);
      setSpecialMax(rage);
    }


    public void attack(Damageable other){
      int damage = (int)(Math.random()*10)+1;
      other.applyDamage(damage);
      if (getSpecialMax() > getSpecial()){
        setSpecial(getSpecial() + 1);
      }
      System.out.print(this + " attacked " + other + " for " +damage + " HP!");
    }

    public void specialAttack(Damageable other){
      int damage = (int)(Math.random()*20)+1;
      other.applyDamage(damage);
      System.out.print(this + " greatly curses "+ other + " for " + damage + " HP! "+warcry);
      setSpecial(getSpecial()-10);
    }
  
    public void heal(int newheal){
      applyHeal(newheal); 
      System.out.print(this + " does magic healings for " + newheal + " HP! "+warcry);
      setSpecial(getSpecial()-10);
    }

      public String getSpecialName(){
        return "Mana";
      }

    public int getSpecial(){
        return mana;
    }

    public String getWarcry(){
        return warcry;
    }

    public void setSpecial(int r){
        this.mana = r;
    }

    public void setWarcry(String warcry){
        this.warcry = warcry;
    }
    public void setSpecialMax(int r){
      this.maxmana = r;
    }
    public int getSpecialMax(){
      return maxmana;
    }
}

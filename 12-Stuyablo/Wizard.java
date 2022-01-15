public class Wizard extends Adventurer {
    private int mana;
    private String warcry;
    private int maxmana;

    public Wizard(){
	     this("Glaxus");
    }

    public Wizard(String name){
	     this(name,"Prepare for your unhealing!", 18);
    }

    public Wizard(String name, String warcry, int mana){
      super(name);
      setWarcry(warcry);
      setRage(mana);
      setMaxRage(mana);
    }

    public void attack(Damageable other){
        int damage = (int)(Math.random()*10)+1;
        other.applyDamage(damage);
        setRage(getRage() + 1);
        System.out.print(this + " attacked " + other + " for " +damage + " HP!");
    }

    public void specialAttack(Damageable other){
      if(getRage() >= 10){
          int damage = (int)(Math.random()*20)+1;
        other.applyDamage(damage);
        System.out.print(this + " greatly curses "+ other + " for " + damage + " HP! "+warcry);
        setRage(getRage()-10);
      }else{
        System.out.print("Not enough mana! ");
        attack(other);
      }
    }
  
    public void heal(){
          if(getRage() >= 10){
          int newheal = (int)(Math.random()*20)+1;
          applyHeal(newheal); 
          System.out.print(this + " does magic blessings on himself for " + newheal + " HP! "+warcry);
          setRage(getRage()-10);
        }else{
            System.out.print("Not enough mana! ");
            heal();
        }
    }

      public String getid(){
        return "Mana";
      }

    public int getRage(){
        return mana;
    }

    public String getWarcry(){
        return warcry;
    }

    public void setRage(int r){
        this.mana = r;
    }

    public void setWarcry(String warcry){
        this.warcry = warcry;
    }
    public void setMaxRage(int r){
      this.maxmana = r;
    }
    public int getMaxRage(){
      return maxmana;
    }
}

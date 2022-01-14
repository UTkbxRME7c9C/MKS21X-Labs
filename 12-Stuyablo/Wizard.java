public class Wizard extends Adventurer {
    private int mana;
    private String warcry;

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
    }

    public void attack(Damageable other){
        int damage = (int)(Math.random()*10)+1;
        other.applyDamage(damage);
        setRage(getRage() + 1);
        System.out.println(this + " attacked " + other + " for " +damage + " HP!");
    }

    public void specialAttack(Damageable other){
      if(getRage() >= 10){
          int damage = (int)(Math.random()*20)+1;
        other.applyDamage(damage);
        System.out.println(this + " greatly curses "+ other + " for " + damage + " HP! "+warcry);
        setRage(getRage()-10);
      }else{
        System.out.println("Not enough mana! ");
        attack(other);
      }
    }

    public void heal(){
        int newheal = (int)(Math.random()*10)+1;
        applyHeal(newheal);
        setRage(getRage()+1);
        System.out.println(this + " heals themselves for " + newheal + " HP!");
    }
  
    public void specialHeal(){
          if(getRage() >= 10){
          int newheal = (int)(Math.random()*20)+1;
          applyHeal(newheal); 
          System.out.println(this + " does magic blessings on himself for " + newheal + " HP! "+warcry);
          setRage(getRage()-10);
        }else{
            System.out.println("Not enough mana! ");
            heal();
        }
    }

    public void heal(Damageable other){
        int newheal = (int)(Math.random()*10)+1;
        other.applyHeal(newheal);
        setRage(getRage()+1);
        System.out.println(this + " heals " + other + " for " + newheal + " HP!");
      }
  
      public void specialHeal(Damageable other){
        if(getRage() >= 10){
          int newheal = (int)(Math.random()*20)+1;
          other.applyHeal(newheal);
          System.out.println(this + " does magic blessings on "+ other + " for " + newheal + " HP!");
          setRage(getRage()-10);
      }else{
          System.out.println("Not enough mana! ");
          heal(other);
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
}

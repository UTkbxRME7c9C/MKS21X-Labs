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
      super(name,30+(int)(Math.random()*10));
      setWarcry(warcry);
      setMana(mana);
    }

    public void attack(Damageable other){
        int damage = (int)(Math.random()*10)+1;
        other.applyDamage(damage);
        setMana(getMana() + 1);
        System.out.println(this + " attacked " + other + " for " +damage + " HP!");
    }

    public void specialAttack(Damageable other){
      if(getMana() >= 10){
          int damage = (int)(Math.random()*20)+1;
        other.applyDamage(damage);
        System.out.println(this + " greatly curses "+ other + " for " + damage + " HP! "+warcry);
        setMana(getMana()-10);
      }else{
        System.out.println("Not enough mana! ");
        attack(other);
      }
    }

    public void heal(){
        int newheal = (int)(Math.random()*10)+1;
        applyHeal(newheal);
        setMana(getMana()+1);
        System.out.println(this + " heals themselves for " + newheal + " HP!");
    }
  
    public void specialHeal(){
          if(getMana() >= 10){
          int newheal = (int)(Math.random()*20)+1;
          applyHeal(newheal); 
          System.out.println(this + " does magic blessings on himself for " + newheal + " HP! "+warcry);
          setMana(getMana()-10);
        }else{
            System.out.println("Not enough mana! ");
            heal();
        }
    }

    public void heal(Damageable other){
        int newheal = (int)(Math.random()*10)+1;
        other.applyHeal(newheal);
        setMana(getMana()+1);
        System.out.println(this + " heals " + other + " for " + newheal + " HP!");
      }
  
      public void specialHeal(Damageable other){
        if(getMana() >= 10){
          int newheal = (int)(Math.random()*20)+1;
          other.applyHeal(newheal);
          System.out.println(this + " does magic blessings on "+ other + " for " + newheal + " HP!");
          setMana(getMana()-10);
      }else{
          System.out.println("Not enough mana! ");
          heal(other);
      }
      }

    public int getMana(){
        return mana;
    }

    public String getWarcry(){
        return warcry;
    }

    public void setMana(int r){
        this.mana = r;
    }

    public void setWarcry(String warcry){
        this.warcry = warcry;
    }
}

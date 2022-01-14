public class Warrior extends Adventurer {
    private int rage;
    private String warcry;

    public Warrior(){
	     this("Magnus");
    }

    public Warrior(String name){
	     this(name,"Valhalllaaaaa!!", 18);
    }

    public Warrior(String name, String warcry, int rage){
      super(name);
      setWarcry(warcry);
      setRage(rage);
    }

    //warrior methods

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
          System.out.println(this + " unleashes his fury upon "+ other + " for " + damage + " HP! "+warcry);
          setRage(getRage()-10);
	    }else{
			    System.out.println("Not enough rage! ");
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
        System.out.println(this + " performs a mend on themselves for " + newheal + " HP! "+warcry);
        setRage(getRage()-10);
      }else{
          System.out.println("Not enough rage! ");
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
        System.out.println(this + " performs a strong mend on "+ other + " for " + newheal + " HP!");
        setRage(getRage()-10);
    }else{
        System.out.println("Not enough rage! ");
        heal(other);
    }
    }

    //get methods

    public String getid(){
      return "Rage";
    }
    public int getRage(){
	     return rage;
    }

    //set methods
    public void setRage(int r){
	     this.rage = r;
    }

    public void setWarcry(String warcry){
	     this.warcry = warcry;
    }

    public String getWarcry(){
      return warcry;
    }
}

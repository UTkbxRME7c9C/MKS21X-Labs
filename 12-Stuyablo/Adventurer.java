public abstract class Adventurer implements Damageable{
    private String name;
    private int HP;
    private int XP;

    //Abstract methods are meant to be implemented in child classes.
    public abstract void attack(Damageable other);
    public abstract void specialAttack(Damageable other);
    public abstract void heal();
    public abstract void specialHeal();
    public abstract void heal(Damageable other);
    public abstract void specialHeal(Damageable other);

    public Adventurer(){
  	   this("Lester");
    }

    public Adventurer(String name){
  	   this(name, 10);
    }

    public Adventurer(String name, int hp){
       this.name = name;
       this.HP = hp;
    }

    //toString method
    public String toString(){
    	return this.getName();
    }

    //Get Methods
    public String getName(){
    	return name;
    }

    public int getHP(){
	     return HP;
    }

    public int getXP(){
      return XP; 
    }

    public void setXP(int amt){
      this.XP += amt;
    }

    public void applyDamage(int amount){
      this.HP -= amount;
    }

    public void applyHeal(int amount){
      this.HP += amount;
    }

    //Set Methods
    public void setHP(int health){
	     this.HP = health;
    }

    public void setName(String s){
	     this.name = s;
    }

}

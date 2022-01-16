import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE;

  public static void main(String[] args) {
    run();
  }

  //Display a List of 1-4 adventurers on the rows row through row+3 (4 rows max)
  //Should include Name and HP on 2 separate lines. (more to be added later)
  public static void drawParty(ArrayList<Adventurer> party,int startRow){
    for(int i = 0;i<party.size();i++){
      int space = ((WIDTH/party.size())*i)+2;
      Text.go(startRow,space);
      System.out.print(party.get(i).getName());
      Text.go(startRow+1,space);
      System.out.print(party.get(i).getSpecialName()+": "+party.get(i).getSpecial()+"/"+party.get(i).getSpecialMax());
      Text.go(startRow+2,space);
      double hper = (double)(party.get(i).getHP())/(double)(party.get(i).getmaxHP());
      if(hper <= 0.25){
        System.out.print("HP: "+Text.colorize(party.get(i).getHP()+"/"+party.get(i).getmaxHP(),Text.RED));
      }else if (hper >= 0.75){
        System.out.print("HP: "+Text.colorize(party.get(i).getHP()+"/"+party.get(i).getmaxHP(),Text.GREEN));
      }else{
        System.out.print("HP: "+ party.get(i).getHP()+"/"+party.get(i).getmaxHP());
      }
    }
  }

  //Display a line of text starting at column 2 of the specified row.
  public static void drawText(String s,int startRow){
    Text.go(startRow, 2);
    System.out.print(s);
  }

  public static void drawScreen(){
    Text.hideCursor();
    Text.clear();
    Text.border(WIDTH,HEIGHT,BORDER_BACKGROUND,BORDER_COLOR);
    Text.go(5,2);
    for(int i = 0;i<WIDTH-2;i++){
      System.out.print(Text.colorize("-",BORDER_BACKGROUND+Text.BACKGROUND,BORDER_COLOR));
    }
    Text.go(HEIGHT-4,2);
    for(int i = 0;i<WIDTH-2;i++){
      System.out.print(Text.colorize("-",BORDER_BACKGROUND+Text.BACKGROUND,BORDER_COLOR));
    }
    Text.go(5,(WIDTH/2)-3); System.out.print(Text.colorize("PARTY",BORDER_BACKGROUND+Text.BACKGROUND,BORDER_COLOR));
    Text.go(HEIGHT-4,(WIDTH/2)-4); System.out.print(Text.colorize("ENEMIES",BORDER_BACKGROUND+Text.BACKGROUND,BORDER_COLOR));
  }


  public static void run(){
    Random randgen = new Random();
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    Text.go(1,1);


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1 enemy to it.
    ArrayList<Adventurer>enemies = new ArrayList<>();
    enemies.add(new Warrior("Goblin","DIE!",40, 40));
    enemies.add(new Wizard("Amogus", "Sus", 25));

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 3 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    party.add(new Warrior());
    party.add(new Wizard());
    party.add(new Wizard("Goroth"));

    //Main loop
    boolean partyTurn = false;
    int whichPlayer = 0;
    int turn = 0;
    String input = "";
    Scanner in = new Scanner(System.in);
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){

      //Draw the window border
      Text.hideCursor();
      drawScreen();

      //display event based on last turn's input
      if(partyTurn){
        int enemy = randgen.nextInt(enemies.size());
        //Process user input:
        if(input.equals("attack") || input.equals("")){
          Text.go((HEIGHT/2)-1,2);
          party.get(whichPlayer).attack(enemies.get(enemy));
        }
        else if(input.equals("special")){
          if (party.get(whichPlayer).getSpecial() <10){
            drawText("Not enough "+party.get(whichPlayer).getSpecialName()+" - attacking instead.",(HEIGHT/2)-2);
            Text.go((HEIGHT/2)-1,2);
            party.get(whichPlayer).attack(enemies.get(enemy));
          } else{
            Text.go((HEIGHT/2)-1,2);
            party.get(whichPlayer).specialAttack(enemies.get(enemy));
          }
        } else if (input.equals("heal")){
          int newhp = randgen.nextInt(10)+1;
          if (party.get(whichPlayer).getSpecial() <10){
            drawText("Not enough "+party.get(whichPlayer).getSpecialName()+" - attacking instead.",(HEIGHT/2)-2);
            Text.go((HEIGHT/2)-1,2);
            party.get(whichPlayer).attack(enemies.get(enemy));
          } else if (party.get(whichPlayer).getmaxHP()-party.get(whichPlayer).getHP() <= newhp){
            drawText("Too healthy - attacking instead",(HEIGHT/2)-2);
            Text.go((HEIGHT/2)-1,2);
            party.get(whichPlayer).attack(enemies.get(enemy));
          } else{
            Text.go((HEIGHT/2)-1,2);
            party.get(whichPlayer).heal(newhp);
          }
        }
        whichPlayer++;



        if(whichPlayer < party.size()){
          drawText(Text.colorize("Enter command for "+party.get(whichPlayer)+": attack/special/heal/(q)uit",1),HEIGHT/2);
        }else{
          drawText(Text.colorize("Press enter to see enemies turn",1),HEIGHT/2);
          partyTurn = false;
        }
      }else{
        //this block ignores user input!
        //display enemy attack except on turn 0.
        if(turn > 0){
          int newhp = randgen.nextInt(10)+1;
          for(int i = 0;i<enemies.size();i++){
            Text.go((HEIGHT/2)+i+1,2);
            if (enemies.get(i).getSpecial() >= 10){
              if (randgen.nextBoolean()){
                enemies.get(i).specialAttack(party.get(randgen.nextInt(party.size())));
              } else if (enemies.get(i).getmaxHP()-enemies.get(i).getHP() > newhp){
                enemies.get(i).heal(newhp);
              }
            } else {
              enemies.get(i).attack(party.get(randgen.nextInt(party.size())));
            }
          }
        }

        //after enemy goes, change back to player's turn.
        partyTurn=true;
        whichPlayer = 0;
        //display which player's turn is next and prompt for action.
        drawText(Text.colorize("Enter command for "+party.get(whichPlayer)+": attack/special/heal/(q)uit",1),HEIGHT/2);

        //end the turn.
        turn++;

      }

      //display current state of all Adventurers
      drawParty(party,2);
      drawParty(enemies,HEIGHT-3);

      //Draw the prompt
      Text.reset();
      Text.go(HEIGHT+1,1);
      System.out.print(">");
      Text.showCursor();
      //Read user input
      input = in.nextLine();
    }
    in.close();
    //After quit reset things:
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }




}

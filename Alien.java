import java.util.*;

public class Alien implements Contract{
    private String name;
    private int height;
    private int energy_level;
    private String direction;
    private int holding_capacity;
    private ArrayList<String> collected_items;
    private int x_coor;
    private int y_coor;
    private String last_action;
    


    public Alien(String name, int height, String direction, int holding_capacity, int x_coor, int y_coor){
        this.name = name;
        this.height = height;
        this.energy_level = 100;
        this.direction = direction;
        this.holding_capacity = holding_capacity;
        this.collected_items = new ArrayList<>();
        this.x_coor = x_coor;
        this.y_coor = y_coor;
        this.last_action = "N/A";
    }

    public Alien(String name, int height, int holding_capacity){
        this.name = name;
        this.height = height;
        this.energy_level = 100;
        this.direction = "Center";
        this.holding_capacity = holding_capacity;
        this.collected_items = new ArrayList<>();
        this.x_coor = 0;
        this.y_coor = 0;
        this.last_action = "N/A";
    }

    public Alien(String name){
        this.name = name;
        this.height = 80;
        this.energy_level = 100;
        this.direction = "Center";
        this.holding_capacity = 8;
        this.collected_items = new ArrayList<>();
        this.x_coor = 0;
        this.y_coor = 0;
        this.last_action = "N/A";
    }

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.height;
    }
    public int getEnergy_level(){
        return this.energy_level;
    }
    public String getDirection(){
        return this.direction;
    }

    public int getHolding_capacity(){
        return this.holding_capacity;
    }
    public ArrayList<String> getCapacity(){
        return this.collected_items;
    }

    public int x_coor(){
        return this.x_coor;
    }

    public int y_coor(){
        return this.y_coor;
    }

    public String getLast_Action(){
        return this.last_action;
    }


    public void move(String direction){
        if(walk(direction)==false){
            walk(direction);
        }
        else if(direction == "North"){
            this.y_coor += 1;
            System.out.println(this.name + " moved one step North");
            this.last_action = "Walked North";
            this.energy_level -= 10;
        }
        else if(direction == "South"){
            this.y_coor -= 1;
            System.out.println(this.name + " moved one step South");
            this.last_action = "Walked South";
            this.energy_level -= 10;
        }
        else if(direction == "East"){
            this.x_coor += 1;
            System.out.println(this.name + " moved one step East");
            this.last_action = "Walked East";
            this.energy_level -= 10;
        }
        else if(direction == "West"){
            this.y_coor -= 1;
            System.out.println(this.name + " moved one step West");
            this.last_action = "Walked West";
            this.energy_level -= 10;
        }
        
    }

    public void grab(String item){
        try{
            if (this.energy_level < 10){
                throw new RuntimeException(" I do not have enough energy to grab anything.");
            }
            else if (this.collected_items.size() == this.holding_capacity){
                throw new RuntimeException("I can't grab the item because I do not have enough space to grab.");
            }
            else if (this.collected_items.contains(item)){
                throw new RuntimeException("I already have this item.");
            }
            this.collected_items.add(item);
            System.out.println(item + " has been grabbed");
            this.last_action = "Grab";
            this.energy_level -=10;
         } catch (Exception e){
            System.out.println(e);
         }  
    }

    public String drop(String item){
        try{
            if(this.energy_level < 10){
                throw new RuntimeException("I don't have enough energy to drop this item");
            }
            else if (!this.collected_items.contains(item)){
                throw new RuntimeException("I cannot drop this item because I am not holding it.");
            }
            this.collected_items.remove(item);
            System.out.println("I have dropped " + item );
            this.last_action = "Drop";
         } catch (Exception e){
            System.out.println(e);
         }  
         return item;
    }

   
   public void examine(String item){
    Random rand = new Random();
    int n = rand.nextInt(2);
    try{
        if(this.energy_level < 10){
            throw new RuntimeException("I do not have the energy to examine this item.");
        }
        else if(n == 0){
            System.out.println("I think " + item + " is ugly! I do not want it.");

        } System.out.println("Ooo I like this item. I want to grab it");
         grab(item);
         this.energy_level -= 10;
         this.last_action = "Examine";
    } catch (Exception e){
        System.out.println(e);
    }
    
    }
    
    
    public void use(String item){
        try{
            if(this.energy_level <10 ){
                throw new RuntimeException("I do not have enough energy to use " + item);
            }
            else if (!this.collected_items.contains(item)){
                throw new RuntimeException("I cannot use this item because I am not holding it.");
            }
            System.out.println("I am now using " + item );
            this.energy_level -=10;
            this.last_action = "Use";
         } catch (Exception e){
            System.out.println(e);
         }  
    }

    public boolean walk (String direction){
        try{
            if(this.energy_level < 10){
                throw new RuntimeException("I do not have enough energy to do this");
            }
            else if (this.direction == "North" && y_coor >= 100){
                throw new RuntimeException("I can't go there because it is out of bounds");
            } 
            else if (this.direction == "South" && y_coor <=0){
                throw new RuntimeException("I can't go there because it is out of bounds");
            } 
            else if (this.direction == "East" && x_coor >=100){
                throw new RuntimeException("I can't go there because it is out of bounds");
            } 
            else if (this.direction == "West" && x_coor <=0){
                throw new RuntimeException("I can't go there because it is out of bounds");
            } 
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean fly(int x, int y){
        try{
            if (this.energy_level <10){
                throw new RuntimeException("I do not have enough energy to fly");
            }
            else if(this.x_coor == x && this.y_coor == y){
                throw new RuntimeException("I am already here so I cannot fly to this location.");
            }
            else if(x < 0 | x> 100 | y < 0 | y > 100){
                throw new RuntimeException("This is out of bounds so I cannot fly here.");
            }
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false; 
        }    
    }

    public void fly_to(int x, int y){
        if(fly(x,y)== false){
            fly(x,y);
        }
        this.x_coor = x;
        this.y_coor = y;
        System.out.println(this.name + " is now at the coordinate: "+ " (" + x + ", " + y + ")");
        this.last_action = "Fly";
        this.energy_level -= 10;
          
}

    public Number shrink(){
        try{
            if(this.energy_level < 10){
                throw new RuntimeException("I do not have enough energy to shrink.");
            }
            else if(this.height <= 20){
                throw new RuntimeException("I am too small so I cannot shrink more.");
            }
            this.height -= 20;
            this.last_action = "Shrink";
            return this.height;
        }
        catch (Exception e){
            System.out.println(e);
            return this.height; 
           }
        
    }

    public Number grow(){
       try{
        if (this.energy_level < 10){
            throw new RuntimeException("I do not have enough energy to grow.");
        }
        this.height += 20;
        this.last_action = "Grow";
        return this.height;
       }
       catch (Exception e){
        System.out.println(e);
        return this.height; 
       }
    }

    public void rest(){
        this.energy_level += 10;
        System.out.println("My energy level is now up to " + this.energy_level);
    }

    public void undo(){
       try{
        if(this.last_action.equals("N/A")){
            throw new RuntimeException("Cannot undo because no action has been done");
        }
        else if (this.last_action.equals("Grow")){
            this.energy_level += 10;
            shrink();
        }
        else if (this.last_action.equals("Shrink")){
            this.energy_level += 10;
            grow();
        }
        else if (this.last_action.equals("Grab")){
            this.energy_level += 10;
            System.out.println("Call the drop method with the name of the item you just grabbed");
        }
        else if (this.last_action.equals("Drop")){
            this.energy_level += 10;
            System.out.println("Call the grab method with the name of the item you just dropped");
        }
        else if (this.last_action.equals("Examine")){
            System.out.println("Can't undo examine");
        }
        else if (this.last_action.equals("Use")){
            this.energy_level += 10;
            System.out.println("Can't undo Use");
        }
        else if (this.last_action.equals("Walked North")){
            this.energy_level += 10;
            walk("South");
        }
        else if (this.last_action.equals("Walked South")){
            this.energy_level += 10;
            walk("North");
        }
        else if (this.last_action.equals("Walked East")){
            this.energy_level += 10;
            walk("West");
        }
        else if (this.last_action.equals("Walked West")){
            this.energy_level += 10;
            walk("East");
        }
        else if (this.last_action.equals("Fly")){
            this.energy_level += 10;
            System.out.println("Call the fly_to method with your pervious coordinate.");
        }
       }catch (Exception e){
        System.out.println(e);
       }
    }
    public static void main(String[] args){
        Alien Fred = new Alien("Fred", 180, 4);
        Fred.grab("Fries");
        Fred.grab("Mom");
        Fred.grab("Candy");
        Fred.drop("Fries");
        Fred.undo();
        Fred.shrink();
        Fred.move("East");
        Fred.grow();
        Fred.fly_to(10, 20);
    }
    
}


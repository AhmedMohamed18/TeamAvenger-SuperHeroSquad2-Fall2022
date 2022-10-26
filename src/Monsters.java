/*
 * @author stremya
 *
 * */

import java.util.ArrayList;

public class Monster
{
    private String description;
    private int id;
    private ArrayList<Collectible> itemPouch = new ArrayList<Collectible>();
    private String catagory;

    public class Monster()
    {
	super.setName("Ana");
	super.setCurrentHealth(100);
	super.setMaxHealthPoints(100);
	super.setCurrentRoom(0);
	super.setAttackValue(5);
	this.catagory = "Living"; 
	this.description = " A foot wide anaconda."; 
	this.id = 0;
    }
    {
        super.setName("Harvey");
        super.setCurrentHealth(100);
        super.setMaxHealthPoints(100);
        super.setCurrentRoom(0);
        super.setAttackValue(5);
        this.catagory = "Living";
        this.description = " No eyes and dirty, rotten teeth hyena.";
        this.id = 0;
    }
	super.setName("Freddy");
	super.setCurrentHealth(100);
	super.setMaxHealthPoints(100);
	super.setCurrentRoom(0);
	super.setAttackValue(5);
	this.catagory = "Living"; 
	this.description = " 8 ft long, deep ocean scary fish"; 
	this.id = 0;
}
	{
            super.setName("Odin");
            super.setCurrentHealth(100);
            super.setMaxHealthPoints(100);
            super.setCurrentRoom(0);
            super.setAttackValue(5);
            this.catagory = "Living";
            this.description = "White owl with scary deep daunting fixated eyes.";
            this.id = 0;
            }
            {
            super.setName("Porter");
            super.setCurrentHealth(100);
            super.setMaxHealthPoints(100);
            super.setCurrentRoom(0);
            super.setAttackValue(5);
            this.catagory = "Living";
            this.description = " A panda but as a 6 foot slim man, ";
            this.id = 0;
            }
            {
            super.setName("Alli");
            super.setCurrentHealth(100);
            super.setMaxHealthPoints(100);
            super.setCurrentRoom(0);
            super.setAttackValue(5);
            this.catagory = "Living";
            this.description = " A fast hungry, skinned alligator";
            this.id = 0;
            }
            {
            super.setName("Marley");
            super.setCurrentHealth(100);
            super.setMaxHealthPoints(100);
            super.setCurrentRoom(0);
            super.setAttackValue(5);
            this.catagory = "Living";
            this.description = " A ferocious reptile monster.";
            this.id = 0;
            }

public Monster(String name, int healthPoints, String description, int id)
        {
        super.setCurrentHealth(healthPoints);
        super.setMaxHealthPoints(healthPoints);
        super.setName(name);
        this.description = description;
        this.id = id;
        }

public int attack()
        {
        return getAttackValue();
        }

public void recieveAttack(int attackValue)
        {
        super.setCurrentHealth(super.getCurrentHealth() - attackValue);
        }


        {
        return "Monster [description=" + description + ", id=" + id + ", getCurrentRoom()=" + getCurrentRoom()
        + ", getCurrentHealth()=" + getCurrentHealth() + ", getAttackValue()=" + getAttackValue()
        + ", getMaxHealthPoints()=" + getMaxHealthPoints() + ", getName()=" + getName() + ", isAlive()=" + isAlive();
        }

        //Method talk, attack

        }
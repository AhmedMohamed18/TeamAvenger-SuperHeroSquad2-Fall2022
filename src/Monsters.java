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
	super.setName("Mummy");
	super.setCurrentHealth(100);
	super.setMaxHealthPoints(100);
	super.setCurrentRoom(0);
	super.setAttackValue(5);
	this.catagory = "Living";
	this.description = "They are servants of a lost and forgotten tomb awakened when the player enters the dungeon.
			";
			this.id = 0;
	}
	{
		super.setName("Ghoul");
		super.setCurrentHealth(100);
		super.setMaxHealthPoints(100);
		super.setCurrentRoom(0);
		super.setAttackValue(5);
		this.catagory = "Living";
		this.description = "An undead creature that had a curse placed on them when they were human. They feed on corpses or living flesh.";
		this.id = 0;
	}
	super.setName("Bandit Raider");
	super.setCurrentHealth(100);
	super.setMaxHealthPoints(100);
	super.setCurrentRoom(0);
	super.setAttackValue(5);
	this.catagory = "Living";
	this.description = "A robber or outlaw that typically operates in an isolated or lawless area, seeking treasure and riches..
		";
		this.id = 0;
}
	{
			super.setName("Bandit Captain");
			super.setCurrentHealth(100);
			super.setMaxHealthPoints(100);
			super.setCurrentRoom(0);
			super.setAttackValue(5);
			this.catagory = "Living";
			this.description = "The captain of the band of robbers and outlaws that typically operates in an isolated or lawless area, seeking treasure and riches.
			";
			this.id = 0;
			}
			{
			super.setName("Vampire Raider");
			super.setCurrentHealth(100);
			super.setMaxHealthPoints(100);
			super.setCurrentRoom(0);
			super.setAttackValue(5);
			this.catagory = "Living";
			this.description = "An outlaw who succumbed to a vampiric bite, now forced to forever traversing these hallowed halls.
			";
			this.id = 0;
			}
			{
			super.setName("Skeleton King");
			super.setCurrentHealth(100);
			super.setMaxHealthPoints(100);
			super.setCurrentRoom(0);
			super.setAttackValue(5);
			this.catagory = "Living";
			this.description = "The undead remains of a powerful monarch who still seeks control over his domain.
			";
			this.id = 0;
			}
			{
			super.setName("Dragon Lord");
			super.setCurrentHealth(100);
			super.setMaxHealthPoints(100);
			super.setCurrentRoom(0);
			super.setAttackValue(5);
			this.catagory = "Living";
			this.description = "A fire breathing ancient wyvern that has made this dungeon his throne. He seeks to defend his territory at all costs.
			";
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
		
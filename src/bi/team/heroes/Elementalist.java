package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.Attack;
import bi.team.heroes.attacks.elementalist.ArcaneBlast;
import bi.team.heroes.attacks.elementalist.BurstingFlames;
import bi.team.heroes.attacks.elementalist.Missile;
import bi.team.heroes.attacks.elementalist.MissileDetonation;
import bi.team.heroes.attacks.elementalist.Rejuvenate;
import bi.team.heroes.attacks.elementalist.Whack;

public class Elementalist extends Hero {
	
	// constructor
	public Elementalist(Game game) {
		
		super(game);
		
		// instantiate variables
		AttacksArrayList = new ArrayList<Attack>();
		
		// create this class's attacks
		AttacksArrayList.add(new Whack(this));
		AttacksArrayList.add(new Missile(this));
		AttacksArrayList.add(new Rejuvenate(this));
		AttacksArrayList.add(new MissileDetonation(this));
		AttacksArrayList.add(new ArcaneBlast(this));
		AttacksArrayList.add(new BurstingFlames(this));
		
	}

	@Override
	public void enableUpgradeButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableUpgradeButtons() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

package bi.team.heroes;

import java.util.ArrayList;

import bi.team.Game;
import bi.team.heroes.attacks.barbarian.Attack;
import bi.team.heroes.attacks.elementalist.ArcaneBlast;
import bi.team.heroes.attacks.elementalist.BurstingFlames;
import bi.team.heroes.attacks.elementalist.Missile;
import bi.team.heroes.attacks.elementalist.MissileDetonation;
import bi.team.heroes.attacks.elementalist.Rejuvenate;
import bi.team.heroes.attacks.elementalist.Whack;

public class Elementalist extends Hero {

	public Elementalist(Game game, int sex) {
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
	public void enableStanceButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableStanceButtons() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

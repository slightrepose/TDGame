package objects;

import javafx.scene.image.Image;
import javafx.util.Duration;

public abstract class TargetedTower extends Tower{
	private int damage;
	private boolean canFire;
	private Duration delay; //in ms
	public TargetedTower(int range, int dmg, double dly, String idCode, Image i, double x, double y, double width, double height) {
		super(idCode, i, x, y, width, height, range);
		damage = dmg;
		canFire = true;
		delay = Duration.millis(dly);
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public boolean canFire() {
		return canFire;
	}
	public void setCanFire(boolean canFire) {
		this.canFire = canFire;
	}
	public Duration getDelay() {
		return delay;
	}
	public void setDelay(Duration delay) {
		this.delay = delay;
	}
	public abstract void fire(Enemy enemy);

}

package ui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import objects.Tower;
import objects.towers.BoosterTower;

public class OptionsMenu extends VBox{
	public OptionsMenu(Tower t){
		setId("options");
		this.setPrefWidth(.1*Main.GAME_WIDTH);
		setBackground(new Background(new BackgroundFill(Color.web("#9966ff"), new CornerRadii(7), Insets.EMPTY)));
		Label sellText = new Label("Sell "+(int)(.75*t.getTowerIcon().getCost()));
		sellText.setId("options");
		sellText.setWrapText(true);
		HBox sellButton = new HBox(new ImageView(Main.spark), new ImageView(Main.spark));
		sellButton.setId("options");
		sellButton.setBackground(new Background(new BackgroundFill(Color.web("#6699ff"), new CornerRadii(7), Insets.EMPTY)));
		sellButton.setOnMouseClicked(click -> {
			t.unshowOptions();
			Main.removeNode(t);
			Main.changeMoney((int)(.75*t.getTowerIcon().getCost()));
			if(t instanceof BoosterTower){
				ArrayList<Tower> towers = Main.getPlacedTowers();
				for(Tower to: towers){
					if(Main.getDistanceBetween(t, to) <= t.getRange()){
						to.setBoosted(false);
					}
				}
			}
		});
		Text upgradeText = new Text("Upgrades");
		upgradeText.setId("options");
		upgradeText.setFill(Color.ALICEBLUE);
		getChildren().addAll(sellText, sellButton, upgradeText);
	}
}

import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl.HvlMath;
import com.osreboot.ridhvl.display.collection.HvlDisplayModeResizable;
import com.osreboot.ridhvl.painter.HvlCursor;
import com.osreboot.ridhvl.template.HvlTemplateInteg2D;

public class Main extends HvlTemplateInteg2D{
	
	



	public static void main(String args[]) {
		
		new Main();
	}
	
	Player player;
	Enemy enemy;
	public static boolean playerMoved = false;
	public static float enemyMovement;
	
	
	

	public Main() {
		super(144, 1280, 720, "MMPrototype", new HvlDisplayModeResizable());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		getTextureLoader().loadResource("background");
		getTextureLoader().loadResource("player1");
		getTextureLoader().loadResource("enemy1");

		player = new Player();
		enemy = new Enemy();
		
	}

	@Override
	public void update(float delta) {
		
		
		hvlDrawQuadc(1280/2, 720/2, 500, 720, Main.getTexture(0));
		player.update(delta);
		enemy.update(delta);
		if(player.playerSelected()) {
			
			
			if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() + 65 && HvlCursor.getCursorX() < player.getxPos() + 85
					&& HvlCursor.getCursorY() > player.getyPos() - 10 && HvlCursor.getCursorY() < player.getyPos() + 10) {
			hvlDrawQuadc(player.getxPos() + 75, player.getyPos(), 15, 15, Color.green);
			}else {
				hvlDrawQuadc(player.getxPos() + 75, player.getyPos(), 15, 15, Color.white);	
			}
			
			
			
			if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 10 && HvlCursor.getCursorX() < player.getxPos() + 10
					&& HvlCursor.getCursorY() < player.getyPos() - 65 && HvlCursor.getCursorY() > player.getyPos() - 85) {
			hvlDrawQuadc(player.getxPos(), player.getyPos() - 75, 15, 15, Color.green);
			}else {
				hvlDrawQuadc(player.getxPos(), player.getyPos() - 75, 15, 15, Color.white);	
			}
			
			
			
			if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 85 && HvlCursor.getCursorX() < player.getxPos() - 65
					&& HvlCursor.getCursorY() > player.getyPos() - 10 && HvlCursor.getCursorY() < player.getyPos() + 10) {
			hvlDrawQuadc(player.getxPos() - 75, player.getyPos(), 15, 15, Color.green);
			}else {
				hvlDrawQuadc(player.getxPos() - 75, player.getyPos(), 15, 15, Color.white);	
			}
			
			
			
			
			if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 10 && HvlCursor.getCursorX() < player.getxPos() + 10
					&& HvlCursor.getCursorY() > player.getyPos() + 65 && HvlCursor.getCursorY() < player.getyPos() + 85) {
			hvlDrawQuadc(player.getxPos(), player.getyPos() + 75, 15, 15, Color.green);
			}else {
			hvlDrawQuadc(player.getxPos(), player.getyPos() + 75, 15, 15, Color.white);
			}
		}
		
		///////////////////////////////////////////////////////
	
		///////////////////////////////////////////////////////
		
		if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 10 && HvlCursor.getCursorX() < player.getxPos() + 10
				&& HvlCursor.getCursorY() < player.getyPos() - 65 && HvlCursor.getCursorY() > player.getyPos() - 85
				&& Mouse.isButtonDown(0)) {
			player.setPlayerSelected(false);
			//hvlDrawQuadc(100, 100, 100, 100, Color.gray);
			playerMoved = true;
			player.setMoveCooldown(75);
			player.setyPos(player.getyPos() - 75);
			}
		if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 10 && HvlCursor.getCursorX() < player.getxPos() + 10
				&& HvlCursor.getCursorY() > player.getyPos() + 65 && HvlCursor.getCursorY() < player.getyPos() + 85
				&& Mouse.isButtonDown(0)) {
			player.setPlayerSelected(false);
			//hvlDrawQuadc(100, 100, 100, 100, Color.gray);
			playerMoved = true;
			player.setMoveCooldown(75);
			player.setyPos(player.getyPos() + 75);
			}
		if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() + 65 && HvlCursor.getCursorX() < player.getxPos() + 85
				&& HvlCursor.getCursorY() > player.getyPos() - 10 && HvlCursor.getCursorY() < player.getyPos() + 10
				&& Mouse.isButtonDown(0)) {
			player.setPlayerSelected(false);
			//hvlDrawQuadc(100, 100, 100, 100, Color.gray);
			playerMoved = true;
			player.setMoveCooldown(75);
			player.setxPos(player.getxPos() + 75);
			}
		if(player.playerSelected() && HvlCursor.getCursorX() > player.getxPos() - 85 && HvlCursor.getCursorX() < player.getxPos() - 65
				&& HvlCursor.getCursorY() > player.getyPos() - 10 && HvlCursor.getCursorY() < player.getyPos() + 10
				&& Mouse.isButtonDown(0)) {
			player.setPlayerSelected(false);
			//hvlDrawQuadc(100, 100, 100, 100, Color.gray);
			playerMoved = true;
			player.setMoveCooldown(75);
			player.setxPos(player.getxPos() - 75);
			}
		
		if(player.getMoveCooldown() == 30) {
			enemyMovement = HvlMath.randomFloatBetween(0, 1);
			if(enemyMovement < 0.5){
			enemy.setyPos(enemy.getyPos() + 75);
			}else {
				enemy.setxPos(enemy.getxPos() + 75);
	
			}
			
		}
		System.out.println(enemyMovement);
		////////////////////////////////RUN THIS LAST///////////////////////////////////////////////////////////////////////////////////////////
		playerMoved = false;
	}


	
}

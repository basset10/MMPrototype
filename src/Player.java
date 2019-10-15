import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl.painter.HvlCursor;

public class Player {

	private float xPos;
	private float yPos;
	private boolean playerSelected = false;
	private static int moveCooldown = 0;

	
	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public static final float PLAYER_START_X = 1280/2;
	public static final float PLAYER_START_Y = 660;
	

	public Player(){

		xPos = PLAYER_START_X;
		yPos = PLAYER_START_Y;
		

	}
	
	public static int getMoveCooldown() {
		return moveCooldown;
	}

	public static void setMoveCooldown(int moveCooldown) {
		Player.moveCooldown = moveCooldown;
	}

	public void update(float deltaArg) {
		if(moveCooldown > 0) {
			moveCooldown = moveCooldown - 1;
		}
		
		hvlDrawQuadc(xPos, yPos, 30, 30, Main.getTexture(1));
		if(HvlCursor.getCursorX() > xPos - 15 && HvlCursor.getCursorX() < xPos + 15 && HvlCursor.getCursorY() > yPos - 15 && HvlCursor.getCursorY() < yPos + 15
			&& Mouse.isButtonDown(0) && moveCooldown == 0){
				playerSelected = true;
			}
		/*else if(!((HvlCursor.getCursorX() > xPos - 15) && (HvlCursor.getCursorX() < xPos + 15) && (HvlCursor.getCursorY() > yPos - 15) && (HvlCursor.getCursorY() < yPos + 15))
				&& Mouse.isButtonDown(0)){
					playerSelected = false;
				}*/
		
	}
	
public boolean playerSelected() {
		
		return playerSelected;
		
		
	}

public void setPlayerSelected(boolean selectedArg) {
	this.playerSelected = selectedArg;
}
	
	
	
	
}

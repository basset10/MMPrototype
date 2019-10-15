import static com.osreboot.ridhvl.painter.painter2d.HvlPainter2D.hvlDrawQuadc;

public class Enemy {

	private float xPos;
	private float yPos;
	
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

	public static final float ENEMY_START_X = 1280/2;
	public static final float ENEMY_START_Y = 60;
	

	public Enemy() {
		xPos = ENEMY_START_X;
		yPos = ENEMY_START_Y;
	}
	
	public void update(float deltaArg) {
		
		hvlDrawQuadc(xPos, yPos, 30, 30, Main.getTexture(2));
		
			
			
		}
		
		
	}
	
	


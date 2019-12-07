package raycast.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import raycast.entity.property.Sprite;
import utility.Point;

public class FpsCounter implements Entity {
	
	
	public final double ONE_SECOND = 1000000000L;
	public final double HALF_SECOND = ONE_SECOND / 2F;

	private Font fpsFont;
	private String fpsDisplay;
	private int frameCount;
	private double lastTime;
	private Point pos;
	private Sprite sprite;
	
	public FpsCounter(double x, double y) {
		sprite = new Sprite() {
			@Override
			public void draw(GraphicsContext gc) {
				Font tempFont = gc.getFont();
				gc.setFont(fpsFont);
				gc.setFill(getFill());
				gc.fillText(fpsDisplay, pos.x(), pos.y());
				gc.setStroke(getStroke());
				gc.setLineWidth(getWidth());
				gc.strokeText(fpsDisplay, pos.x(), pos.y());
				gc.setFont(tempFont);
			}

		};
		pos = new Point();
		setPos(x,y);
		setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BLACK, 24));
	}
	
	
//	calculateFPS needs to update the frame count. 
//	in an if condition check if now - lastTime is bigger than HALF_SECOND
//	assign frameCount*2 to fpsDisplay
//	set frameCount to 0
//	set lastTime to now
//	increment frameCount
	public void calculateFPS(long now) {
		if (now-lastTime > HALF_SECOND) {
			fpsDisplay = Integer.toString(frameCount * 2);
			frameCount = 0;
			lastTime = now;
		}
		frameCount++;
	}
	
	public FpsCounter setFont(Font font) {
		fpsFont = font;
		return this;
	}
	
	public FpsCounter setPos(double x, double y) {
		pos.set(x, y);
		return this;
	}
	
	public boolean isDrawable() {
		return true;
	}
	
	public Sprite getDrawable() {
		return sprite;
		
	}
	

}



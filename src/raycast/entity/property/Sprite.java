package raycast.entity.property;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public abstract class Sprite implements Drawable<Sprite> {
	
	
	private double strokeWidth;
	private Paint fillColor;
	private Paint strokeColor;
	
	
	public Sprite setFill(Paint color) {
		fillColor = color;
		return this;
		
	}
	
	public Sprite setStroke(Paint paint) {
		strokeColor = paint;
		return this;
		
	}
	
	public Sprite setWidth(double width) {
		strokeWidth = width;
		return this;
		
	}
	
	public double getWidth() {
		return strokeWidth;
		
	}
	
	public abstract void draw(GraphicsContext gc);
	
	public Paint getFill() {
		return fillColor;
		
	}
	
	public Paint getStroke() {
		return strokeColor;
		
	}

}

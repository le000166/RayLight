package raycast.entity.property;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public interface Drawable<T extends Sprite> {

	public double getWidth();
	public T setFill(Paint paint);
	public T setStroke(Paint paint);
	public T setWidth(double width);
	public void draw(GraphicsContext gc); 
	public Paint getFill();
	public Paint getStroke();
}


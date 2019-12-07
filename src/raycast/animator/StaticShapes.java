package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticShapes extends AbstractAnimator {
	private static final Color BACKGROUND = Color.BISQUE;
	
	public void handle(long now, GraphicsContext gc) {
		//clearAndFill and pass gc and color of your choice
		super.clearAndFill(gc, Color.CADETBLUE);
		
		for(int i=0; i<super.map.shapes().size(); i++) {
			super.map.shapes().get(i).getDrawable().draw(gc);
		}
	}

	@Override
	public String toString() {
		return "StaticShapes";
	}
	
}

package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.entity.geometry.PolyShape;
import utility.IntersectUtil;

public class MultiRayAnimator extends AbstractAnimator {

    private double[] intersectResult = new double[4];
    private double[] intersectPoint = new double[4];

    public void drawLine(GraphicsContext gc, Color color, double sx, double sy, double ex, double ey){
        gc.setLineWidth( 1);
        gc.setStroke(color);
        gc.setFill( Color.MAGENTA);
        gc.strokeLine( sx, sy, ex, ey);
        if( map.getDrawIntersectPoint()){
            gc.fillOval( ex - 5, ey - 5, 10, 10);
        }
    }

    private void drawRays(GraphicsContext gc, double startX, double startY, Color lightColor) {
        double endX;
        double endY;
        double rayIncrementer = 360d / map.getRayCount();

        for (double rayAngle = 0; rayAngle < 360; rayAngle+=rayIncrementer) {
            endX = Math.cos(Math.toRadians(rayAngle));
            endY = Math.sin(Math.toRadians(rayAngle));

            for (PolyShape s: map.shapes()) {
                for (int i = 0,j = s.pointCOunt() - 1; i < s.pointCOunt() ; i++,j = i -1) {
                    boolean doesIntersect = IntersectUtil.getIntersection(intersectResult, startX, startY, startX + endX, startY + endY,s.pX(i),s.pY(i),s.pX(j), s.pY(j));

                    if (doesIntersect && intersectPoint[2] > intersectResult[2]) {
                        System.arraycopy(intersectResult, 0, intersectPoint, 0, intersectPoint.length);
                    }
                }
            }

            this.drawLine(gc, lightColor, startX, startY, intersectPoint[0], intersectPoint[1]);
            intersectPoint[2] = Double.MAX_VALUE;
        }
    }


    @Override
    public String toString() {
        return "MultiRayAnimator";
    }

    @Override
    protected void handle(long now, GraphicsContext gc) {
        super.clearAndFill(gc, Color.CHARTREUSE);
        for(int i=0; i<super.map.shapes().size(); i++) {
            super.map.shapes().get(i).getDrawable().draw(gc);
        }
        drawRays(gc, mouse.x(), mouse.y(), Color.LIGHTBLUE);
    }
}

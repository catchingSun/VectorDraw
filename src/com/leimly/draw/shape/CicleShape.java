package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.shape.Circle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by lizm on 17-11-22.
 */
public class CicleShape implements PenShape {
    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        Circle circle = new Circle();
        circle.setFill(p.fillColor);
        circle.setStroke(p.penColor);
        circle.setCenterX(p.startX - (p.startX - p.endX) / 2);
        circle.setCenterY(p.startY - (p.startY - p.endY) / 2);
        circle.setRadius(sqrt(pow((p.endX - p.startX), 2) + pow((p.endY - p.startY), 2)) / 2);
        return circle;

    }
}

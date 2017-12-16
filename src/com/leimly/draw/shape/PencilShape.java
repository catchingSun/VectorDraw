package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * Created by lizm on 17-11-22.
 */
public class PencilShape implements PenShape {
    @Override
    public Shape setDraw(Pen p) {
        Line line = new Line();
        line.setFill(p.fillColor);
        line.setStroke(p.penColor);
        line.setStartX(p.getStartX());
        line.setStartY(p.getStartY());
        line.setEndX(p.getEndX());
        line.setEndY(p.getEndY());
        return line;
    }
}
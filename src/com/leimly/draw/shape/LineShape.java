package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.shape.*;

/**
 * Created by lizm on 17-11-22.
 */
public class LineShape implements PenShape {

    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
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
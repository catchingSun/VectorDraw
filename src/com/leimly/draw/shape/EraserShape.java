package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.shape.Line;

/**
 * Created by lizm on 17-11-28.
 */
public class EraserShape implements PenShape {


    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        Line eraser = new Line();
        eraser.setStrokeWidth(40);
        eraser.setFill(p.fillColor);
        eraser.setStroke(p.penColor);
        eraser.setStartX(p.getStartX());
        eraser.setStartY(p.getStartY());
        eraser.setEndX(p.getEndX());
        eraser.setEndY(p.getEndY());

        return eraser;
    }

}

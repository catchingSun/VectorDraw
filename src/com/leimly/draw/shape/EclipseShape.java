package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Ellipse;

import static java.lang.Math.abs;

/**
 * Created by lizm on 17-11-22.
 */
public class EclipseShape implements PenShape {
    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);

//        ds.setColor();
        Ellipse eclipse = new Ellipse();
        eclipse.setFill(p.fillColor);
        eclipse.setStroke(p.penColor);
        eclipse.setCenterX(p.startX);
        eclipse.setCenterY(p.startY);
        eclipse.setRadiusX(abs(p.startX - p.endX));
        eclipse.setRadiusY(abs(p.startY - p.endY));
        eclipse.setEffect(ds);
        return eclipse;
    }
}

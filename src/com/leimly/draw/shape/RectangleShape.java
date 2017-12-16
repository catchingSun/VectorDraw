package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.shape.Rectangle;

import static java.lang.Math.abs;

/**
 * Created by lizm on 17-11-22.
 */
public class RectangleShape implements PenShape {

    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        Rectangle r = new Rectangle();
        r.setStroke(p.penColor);
        r.setFill(p.fillColor);

        if(p.getStartX() >= p.getEndX() && p.getStartY() >= p.getEndY()){
            r.setX(p.getEndX());
            r.setY(p.getEndY());
        }
        else if(p.getStartX() <= p.getEndX() && p.getStartY() <= p.getEndY()){
            r.setX(p.getStartX());
            r.setY(p.getStartY());
        }else if(p.getStartX() > p.getEndX() && p.getStartY() < p.getEndY()){
            r.setX(p.getEndX());
            r.setY(p.getStartY());
        }else{
            r.setX(p.getStartX());
            r.setY(p.getEndY());
        }

        r.setWidth(abs(p.getEndX() - p.getStartX()));
        r.setHeight(abs(p.getEndY() - p.getStartY()));
        return r;
    }
}
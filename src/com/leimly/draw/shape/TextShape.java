package com.leimly.draw.shape;

import com.leimly.draw.Pen;
import com.leimly.draw.impl.PenShape;
import javafx.scene.text.Text;

/**
 * Created by lizm on 17-11-28.
 */
public class TextShape implements PenShape {
    @Override
    public javafx.scene.shape.Shape setDraw(Pen p) {
        Text text = new Text();
        text.setFill(p.fillColor);
        text.setStroke(p.penColor);
        text.setX(p.getStartX());
        text.setY(p.getStartY());
        text.setText(p.getText());
        return text;
    }
}

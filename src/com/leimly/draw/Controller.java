package com.leimly.draw;

import com.leimly.draw.factory.*;
import com.leimly.draw.impl.Draw;
import com.leimly.draw.impl.Factory;
import com.leimly.draw.shape.*;
import com.leimly.draw.impl.PenShape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static javafx.scene.paint.Color.*;


public class Controller {
    @FXML
    private VBox pencil;
    @FXML
    private VBox line;
    @FXML
    private VBox eclipse;
    @FXML
    private VBox cicle;
    @FXML
    private VBox text;
    @FXML
    private VBox eraser;
    @FXML
    private ColorPicker penColorPicker;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private AnchorPane drawAnchorPane;
    @FXML
    private Group drawGroup;
    @FXML
    private ChoiceBox sizeMenu;
    @FXML
    private ChoiceBox fontMenu;

    private MainStage mainStage;
    TextArea textArea = new TextArea();


    Pen p = new Pen();
    Pen pOld = new Pen();
    static boolean flag = true;
    javafx.scene.shape.Shape shape = null;
    Group group = new Group();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    static int imgNum = 0;
    static int count = 0;

    @FXML
    public void setOpenFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MGC files (*.mgc)", "*.mgc");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(mainStage);
        if (file != null) {
            try {
                Image image = new Image(new FileInputStream(file));
                ImageView iv = new ImageView();
                iv.setImage(image);
                drawAnchorPane.getChildren().add(iv);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    @FXML
    public void setSaveFile() {
        imgNum++;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("\u4fdd\u5b58\u56fe\u7247");//保存图片
        fileChooser.setInitialFileName("IMG_" + imgNum + ".mgc");
        File file = fileChooser.showSaveDialog(mainStage);
        save(file);
    }

    private void save(File file) {
        String extension = "";
        String name = file.getName();
        if (name.contains(".")) {
            int start = name.lastIndexOf(".");
            extension = file.getName().substring(start + 1);

        } else {
            extension = "jpg";
        }
        WritableImage image = drawAnchorPane.snapshot(new SnapshotParameters(), null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            JOptionPane.showMessageDialog(null, "保存成功", "Success", JOptionPane.NO_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "保存失败", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void setPenColor(ActionEvent t) throws Exception {
        p.setPenColor(penColorPicker.getValue());
    }

    @FXML
    public void setFillColor(ActionEvent t) throws Exception {
        p.setFillColor(fillColorPicker.getValue());
    }

    @FXML
    public void setPencilDraw() {

        p.setDrawShape("pencil");
    }

    @FXML
    public void setLineDraw() {
        p.setDrawShape("line");
    }

    @FXML
    public void setTextDraw() {
        p.setDrawShape("text");
    }

    @FXML
    public void setCicleDraw() {
        p.setDrawShape("cicle");
    }

    @FXML
    public void setRectangleDraw() {
        p.setDrawShape("rectangle");
    }

    @FXML
    public void setEclipseDraw() {
        p.setDrawShape("eclipse");
    }

    @FXML
    public void setEraserDraw() {
        p.setFillColor(WHITE);
        p.setPenColor(WHITE);
        p.setDrawShape("eraser");
    }

    @FXML
    public void drawMousePressed() {
        textArea.setMaxWidth(200);
        textArea.setMaxHeight(20);
        drawAnchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (p.getDrawShape() == "text") {
                    drawText(event);
                } else {
                    Group dGroup = new Group();
                    setGroup(dGroup);
                    p.setStartX(event.getX());
                    p.setStartY(event.getY());
                }


            }
        });
    }


    @FXML
    public void drawMouseDragReleased() {
        drawAnchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                p.setEndX(event.getX());
                p.setEndY(event.getY());
            }
        });
    }

    @FXML
    public void drawMouseDragged() {

        drawAnchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (flag) {
                    p.setStartX(event.getX());
                    p.setStartY(event.getY());
                    flag = false;

                } else {

                    p.setEndX(event.getX());
                    p.setEndY(event.getY());
                    drawOperation();

                }
            }
        });
    }

    public void draw(Factory operFactory, Group group) {
        Draw draw = operFactory.createPen(p);
        draw.creatDraw(group, p, drawAnchorPane);
    }

    public void drawOperation() {
        switch (p.getDrawShape()) {

            case "pencil":
                Factory operFactoryPencil = new PencilFactory();
                draw(operFactoryPencil, drawGroup);
                break;

            case "line":
                Factory operFactoryLine = new LineFactory();
                draw(operFactoryLine, group);
                break;
            case "rectangle":
                Factory operFactoryRectangle = new RectangleFactory();
                draw(operFactoryRectangle, group);
                break;
            case "cicle":
                Factory operFactoryCicle = new CicleFactory();
                draw(operFactoryCicle, group);
                break;
            case "eclipse":
                Factory operFactoryEclipse = new EclipseFactory();
                draw(operFactoryEclipse, group);
                break;
            case "eraser":
                Factory operFactoryEraser = new EraserFactory();
                draw(operFactoryEraser, group);
                break;
        }
    }

    public void drawText(MouseEvent event) {
        count++;
        if (count % 2 == 1) {
            Group dGroup = new Group();
            setGroup(dGroup);
            p.setStartX(event.getX());
            p.setStartY(event.getY());
            textArea.setLayoutX(p.getStartX());
            textArea.setLayoutY(p.getStartY());

            group.getChildren().add(textArea);
            drawGroup.getChildren().add(group);
        } else {
            p.setText(textArea.getText());
            Factory operFactoryText = new TextFactory();
            draw(operFactoryText, drawGroup);
            drawGroup.getChildren().remove(group);
            textArea.setText("");

        }
    }


    private ObservableList<Object> fontSizeItems = FXCollections.observableArrayList();
    private ObservableList<Object> fontFamilyItems = FXCollections.observableArrayList();

    @FXML
    public void setPenSize() {
//        fontMenu.setItems(fontSizeItems);
        for (int i = 0; i < 5; ) {
            int sum = i * 2;
            sizeMenu.getItems().add(sum);
        }

    }

    @FXML
    public void setPenFont() {
//        fontMenu.setItems(fontFamilyItems);
        for (int i = 0; i < 5; i++) {
            fontMenu.getItems().add(Font.getFamilies().get(i));
        }
    }
}

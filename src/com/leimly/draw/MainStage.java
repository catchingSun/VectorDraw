package com.leimly.draw;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizm on 17-11-30.
 */
public class MainStage extends Stage{
    private BorderPane content;
    private double width = 1000;
    private double height = 600;
//    private List<ToolMessage> toolMessageItems = new ArrayList<ToolMessage>();

    public MainStage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("VectorDraw.fxml"));
//        content = BorderPaneBuilder.create().prefHeight(height)
//                .prefWidth(width).build();
        setTitle("绘图");
        setScene(new Scene(root,width,height, Color.web("#949494")));
//        setTitle("\u753b\u56fe 1.0 \u9884\u89c8\u7248");
//        setResizable(false);
//        getIcons().add(new Image(MainStage.class.getResourceAsStream("images/logo.png")));
//        initUI();
//        initToolMessage();

//        root.getChildren().add(content);
//        root.getChildren().addAll(toolMessageItems);

        show();
    }
}

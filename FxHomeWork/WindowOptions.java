package FxHomeWork;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class WindowOptions {

    //конструктор сетки(GridPane) с параметрами
    static GridPane createGridPane(Pos position, int hgap, int vgap, int top, int right, int bottom, int left){
        GridPane grid = new GridPane();
        grid.setAlignment(position);
        grid.setHgap(hgap);
        grid.setVgap(vgap);
        grid.setPadding(new Insets(top, right, bottom, left));
        return grid;
    }

    //конструктор сетки(GridPane) по умолчанию
    static GridPane createGridPane(){
        return createGridPane(Finals.DEFAULT_POS, Finals.DEFAULT_HGAP, Finals.DEFAULT_VGAP, Finals.DEFAULT_TOP, Finals.DEFAULT_RIGHT,
                Finals.DEFAULT_BOTTOM, Finals.DEFAULT_LEFT);
    }

    //создание сцены(Scene) с заданным разрешением
    static Scene createScene(Stage stage, Parent parent, int width, int height){
        Scene scene = new Scene(parent, width, height);
        stage.setScene(scene);
        return scene;
    }

    //создание сцены(Scene) с разрешением по умолчанию
    static Scene createScene(Stage stage, Parent parent){
        return createScene(stage, parent, Finals.DEFAULT_WIDTH, Finals.DEFAULT_HEIGHT);
    }

    //создание нередактируемого текста с заданным шрифтом  и размером шрифта
    static Text createText(String s, String font, FontWeight weight, int size){
        Text text = new Text(s);
        text.setFont(Font.font(font, weight, size));
        return text;
    }

    //создание текста со значениями по умолчанию
    static Text createText(String s){
        return createText(s, Finals.DEFAULT_FONT, Finals.DEFAULT_FONTWEIGHT, Finals.DEFAULT_SIZE);
    }

    //создание HBox с заданными значениями Position и Spacing
    static HBox createHBox(int spacing, Pos position){
        HBox hbBtn = new HBox(spacing);
        hbBtn.setAlignment(position);
        return hbBtn;
    }

    //создание HBox со значениями по умолчанию
    static HBox createHBox(){
        return createHBox(Finals.DEFAULT_SPACING, Finals.DEFAULT_POS);
    }
}


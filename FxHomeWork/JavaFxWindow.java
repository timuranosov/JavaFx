package FxHomeWork; /**
 * Created by admin on 13.04.2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JavaFxWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome on board!");
        primaryStage.show();

        GridPane grid = WindowOptions.createGridPane();

        Scene scene = WindowOptions.createScene(primaryStage, grid);

        Text sceneTitle = WindowOptions.createText("Sign up");
        grid.add(sceneTitle, 30, 0, 2, 1);


        Button submit = new Button("Submit");
        HBox hbBtn = WindowOptions.createHBox(10, Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(submit);
        grid.add(hbBtn, 30, 5);


        final TextField textField = new TextField();
        textField.setPromptText("Enter your input here"); //текст-подсказка для пользователя
        textField.setFocusTraversable(false); //курсор изначально не стоит на textfield, чтобы текст-подсказка был виден
        grid.add(textField, 25, 1, 15, 4);


        final Text actionTarget = new Text();
        grid.add(actionTarget, 30, 7);


        final TextArea errorArea = new TextArea();
        grid.add(errorArea, 0, 10, Finals.DEFAULT_TEXTAREACOLUMNS, Finals.DEFAULT_TEXTAREARAWS);
        errorArea.setStyle("-fx-text-fill: firebrick;");
        errorArea.setEditable(false);
        errorArea.setVisible(false);
        errorArea.setPrefColumnCount(Finals.DEFAULT_TEXTAREACOLUMNS);
        errorArea.setPrefRowCount(Finals.DEFAULT_TEXTAREARAWS);

        //если цифр в строке нет, то выводим ту же самую строку зеленым цветом(при этом скрываем наше поле ошибок);
        //если цифра нашлась, то кидаем runtime exception и обрабатываем его(выводим стек-трейс в наше поле ошибок);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    if (!CheckDigits.hasDigits(textField.getText())) {
                        actionTarget.setFill(Color.GREEN);
                        actionTarget.setText(textField.getText());
                        actionTarget.setVisible(true);
                        errorArea.setVisible(false);
                    } else {
                        throw new RuntimeException("Numbers in input:" + CheckDigits.getDigits(textField.getText()));
                    }
                } catch (RuntimeException ex) {
                    actionTarget.setVisible(false);
                    errorArea.setVisible(true);
                    errorArea.setText(CheckDigits.getStackTrace(ex));
                }
            }
        });
    }
}

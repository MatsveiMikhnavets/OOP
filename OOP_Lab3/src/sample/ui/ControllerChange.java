package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.furniture.engine.Engine;
import sample.furniture.engine.LightEngine;
import sample.furniture.furniture.*;

public class ControllerChange {
    @FXML
    Text t_info;

    @FXML
    Button btn_change;

    @FXML
    RadioButton radio_engine1;
    Engine engine1 = LightEngine.getEngine();

    @FXML
    RadioButton radio_engine2;
    Engine engine2 = LightEngine.getEngine();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() {
        Furniture current = XCell.changeVehicle;

        t_info.setText(current.getFurnitureType() + "   " + current.getFurnitureModel()
                + "   " + "speed = " + current.getWarranty());

        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        if (current.getWarranty().equals("1 year"))
            radio_engine1.setSelected(true);
        else
            radio_engine2.setSelected(true);

        tf_model.setText(current.getFurnitureModel());

        btn_change.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (model != null) {
                Engine engine = engine1;
                if (radio_engine2.isSelected())
                    engine = engine2;
                current.setFurnitureModel(model);
                current.setEngine(engine);
                XCell.changeVehicle = null;

                Stage stage = (Stage) btn_change.getScene().getWindow();
                stage.close();

            }
        });
    }
}

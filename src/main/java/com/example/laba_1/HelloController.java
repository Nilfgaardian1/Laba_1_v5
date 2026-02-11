package com.example.laba_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Convector;

import static java.lang.Integer.parseInt;

public class HelloController
{
    Convector convector = new Convector();
    public TextField tf_erd;
    public TextField tf_usd;
    public TextField tf_input_rus;
    public Label lb_result;

    double rubli;

    @FXML
    public void click_on_convert(ActionEvent actionEvent)
    {
        rubli = Double.parseDouble((tf_input_rus.getText()));
        tf_usd.setText(String.valueOf(convector.ConvectorUSD(rubli)));
        tf_erd.setText(String.valueOf(convector.ConvectorUER(rubli)));
    }
}
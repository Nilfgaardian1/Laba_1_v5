package com.example.laba_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Convector;

import static java.lang.Integer.parseInt;

public class HelloController
{
    public Label lb_out_history;

    public Label lb_result_d;
    public Label lb_result_e;

    public TextField tf_erd;
    public TextField tf_usd;
    public TextField tf_input_rus;

    Convector convector = new Convector();

    double rubli;
    String str_history = " ";
    int operationNumber = 1;
    int click_convert = 0;

    @FXML
    public void click_on_convert(ActionEvent actionEvent)
    {
        if (CheckValue()) return;

        convector.setUSD(Double.parseDouble(tf_usd.getText())); // установка значения в приват поля класса
        convector.setUER(Double.parseDouble(tf_erd.getText())); // установка значения в приват поля класса

        rubli = Double.parseDouble((tf_input_rus.getText()));

        double dollars = convector.ConvectorUSD(rubli);
        double euro = convector.ConvectorUER(rubli);

        String str_format = String.format("Операция %d: $=%.2f, E=%.2f, \n RUS=%.2f => %.2f$ и %.2fE\n",
                operationNumber, convector.getUSD(), convector.getUER(), rubli, dollars, euro);

        HistoryLogic(str_format);
    }

    private boolean CheckValue()
    {
        if (!isNumeric(tf_usd.getText())) {
            lb_out_history.setText("Ошибка: некорректный курс USD");
            return true;
        }
        if (!isNumeric(tf_erd.getText())) {
            lb_out_history.setText("Ошибка: некорректный курс EUR");
            return true;
        }
        if (!isNumeric(tf_input_rus.getText())) {
            lb_out_history.setText("Ошибка: некорректная сумма в рублях");
            return true;
        }
        return false; // Всё в порядке
    }
    private boolean isNumeric(String str)
    {
        if (str == null || str.trim().isEmpty())
        {
            return false;
        }
        try
        {
            Double.parseDouble(str);
            return true;  // Это число
        }
        catch (NumberFormatException e)
        {
            return false; // Не число
        }
    }
    private void HistoryLogic(String str_format)
    {
        str_history += str_format;
        operationNumber++;
        click_convert++;

        if (click_convert == 5)
        {
            str_history = "";
            lb_out_history.setText("");
            click_convert = 0;
            operationNumber = 1;
        }else
        {
            lb_out_history.setText(str_history);
        }
    }
    public void clearHistory(ActionEvent actionEvent)
    {
        str_history ="";
        operationNumber = 1;
        lb_out_history.setText("пусто");
        tf_input_rus.clear();
        tf_erd.clear();
        tf_usd.clear();
    }
}
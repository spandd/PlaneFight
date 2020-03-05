package Client;

import javax.swing.*;

import Controller.ChooseDifficultyFactory;
import Controller.DifficultyValue;
import Model.Constants;
import View.MainView;
import View.TemplateView;



public class Test{
    static JFrame client = new JFrame("飞机大战");
    static TemplateView mainView = new MainView();
    static ChooseDifficultyFactory chooseDifficultyFactory = new ChooseDifficultyFactory();

    public static void main(String[] args) {
        DifficultyValue difficultyValue = chooseDifficultyFactory.chooseDifficulty("normal");
        difficultyValue.chooseDifficulty(mainView.controller);
        client.setVisible(true);
        client.setSize(Constants.windowWidth,Constants.windowHeight);
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setLocationRelativeTo(null);
        client.setResizable(false);
        client.add(mainView);
        mainView.templateMethod(mainView);

    }
}

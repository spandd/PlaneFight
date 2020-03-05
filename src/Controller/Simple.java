package Controller;

import Model.Constants;

public class Simple implements DifficultyValue {
    @Override
    public void chooseDifficulty(Controller controller) {
        controller.getMePlane().setFireLevel(1);
        controller.makeEnemySpeed = 15;
        controller.makeBulletSpeed = 5;
    }
}
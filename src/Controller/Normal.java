package Controller;
public class Normal implements DifficultyValue {
    @Override
    public void chooseDifficulty(Controller controller) {
        controller.getMePlane().setFireLevel(2);
        controller.makeEnemySpeed = 10;
        controller.makeBulletSpeed = 10;
    }

}


package Controller;

public class Hard implements DifficultyValue {
    @Override
    public void chooseDifficulty(Controller controller) {
        String[] enemyImageNames = {"/img/enemy3_hit.png"};
        String[] enemyDestroyImageNames = {"/img/enemy3_down1.png",
                "/img/enemy3_down2.png","/img/enemy3_down3.png","/img/enemy3_down4.png","/img/enemy3_down5.png","/img/enemy3_down6.png"};
        controller.getMePlane().setFireLevel(3);
        controller.makeEnemySpeed = 5;
        controller.makeBulletSpeed = 5;
        controller.enemyImageNames = null;
        controller.enemyImageNames = enemyImageNames;
        controller.enemyDestroyImageNames = null;
        controller.enemyDestroyImageNames = enemyDestroyImageNames;
    }

}
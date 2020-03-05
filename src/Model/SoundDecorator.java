package Model;

public abstract class SoundDecorator extends FlyObject{
    protected FlyObject enemy;
    @Override
    public void attacked(int attackValue) {
        enemy.attacked(attackValue);
    }
}

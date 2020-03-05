package Controller;

public class ChooseDifficultyFactory{
    public DifficultyValue chooseDifficulty(String type){
            if("simple".equals(type)){
                return new Simple();
            }
            else if("normal".equals(type)){
                return new Normal();
            }
            else if("hard".equals(type)){
                return new Hard();
            }
        return null;
    }
}
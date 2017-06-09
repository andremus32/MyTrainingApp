package space.musatov.mytraining.model;

/**
 * Created by LENOVO on 31.05.2017.
 */

public class Excersize {
    private String excersizeType;
    private String excersizeDescription;
    private int excersizeCount;

    public Excersize(String excersizeType, String excersizeDescription, int excersizeCount) {
        this.excersizeType = excersizeType;
        this.excersizeDescription = excersizeDescription;
        this.excersizeCount = excersizeCount;
    }

    public String getExcersizeDescription() {
        return excersizeDescription;
    }

    public String getExcersizeType() {
        return excersizeType;
    }

    public int getExcersizeCount() {
        return excersizeCount;
    }
}

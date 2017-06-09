package space.musatov.mytraining.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import space.musatov.mytraining.R;

/**
 * Created by ANDREY MUSATOV on 31.05.2017.
 */

public class ExcersizeList {
    private static ExcersizeList ourInstance = null;

    List<Excersize> excersizes;


    public static ExcersizeList getInstance() {

        if(ourInstance == null){
            ourInstance = new ExcersizeList();
            return ourInstance;
        }
        else {
            return ourInstance;
        }
    }

    public List<Excersize> getExcersizes(){
        return excersizes;
    }

    private ExcersizeList() {
        initExcersizeList();
    }

    private void initExcersizeList(){
        excersizes = new ArrayList<>();
        //Activity activity = new Activity();
        //String berpi = activity.getResources().getString(R.string.berpi);

        excersizes.add(new Excersize("Берпи", "Здесь будет описание упражнения Берпи", 0));
        excersizes.add(new Excersize("Боковые выпады", "Здесь будет описание упражнения Боковые выпады", 0));
        excersizes.add(new Excersize("Велосипед", "Здесь будет описание упражнения Велосипед", 0));
        excersizes.add(new Excersize("Отжимания на трицепс", "Здесь будет описание упражнения Отжимания на трицепс", 0));
        excersizes.add(new Excersize("Обычные отжимания", "Здесь будет описание упражнения Обычные отжимания", 0));
        excersizes.add(new Excersize("Скручивания с ногами", "Здесь будет описание упражнения Скручивания с ногами", 0));
        excersizes.add(new Excersize("Скручивания. Ноги в воздухе.", "Здесь будет описание упражнения Скручивания. Ноги в воздухе.", 0));
        excersizes.add(new Excersize("Планка", "Здесь будет описание упражнения Планка", 0));

    }

}

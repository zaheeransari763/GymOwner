package com.example.gymowner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class AssetsActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen
        setContentView(R.layout.activity_assets);

        models=new ArrayList<>();
        models.add(new model(R.drawable.dumbells,"Dumbbells are often used for joint-isolation exercises such as biceps curls, chest flyes or shoulder raises. Using dumbbells for full-body, multiplanar movements, however, can provide a variety of different strength outcomes. It also offers many benefits for cardiorespiratory fitness and flexibility.","Dumbbells"));
        models.add(new model(R.drawable.benchpress,"The bench press is an upper-body weight training exercise in which the trainee presses a weight upwards while lying on a weight training bench. The exercise uses the pectoralis major, the anterior deltoids, and the triceps, among other stabilizing muscles.","Bench Press"));
        models.add(new model(R.drawable.chestpressmachine,"The chest press machine is probably the most famous piece of gym equipment. It is designed for chest workouts, but it trains shoulders and triceps as well. All machines in this category have adjustable seats and weight stacks, and they are seated, incline or decline.","Chest Press"));
        models.add(new model(R.drawable.chestflymachine,"The chest fly machine (also called pec fly machine) only targets one group of muscles – the chest. Available in two models, seated and supine, these machines are equipped with pads for increased comfort and allow you to adjust the distance between the pads. Although exercises done with this gym machine also involve triceps and shoulders, these only act as stabilizers, so they are not pumped and strengthen during the fly chest routine.","Chest Fly"));
        models.add(new model(R.drawable.shoulderpressmachine,"As its name implies, shoulder press machine works the shoulders, but also tones and shapes the triceps. Handles are pulled over head with slow, controlled motions, and lowered back to ear level, elbows being kept bent during the exercises.","Shoulder Press"));
        models.add(new model(R.drawable.latpulldownmachine,"Lat pull-down gym machine is for compound exercises, working the muscles in shoulders, biceps, neck, upper and mid-back. The natural arch in the lower back should be maintained throughout the routine to prevent injuries and muscles should be contracted during the movements for maximum benefits.\n" +
                "\n","Lat Pulldown"));
        models.add(new model(R.drawable.cablerowmachine,"Cable row machine is another machine designed for compound exercises. The cable row works mainly the upper and middle back muscles, but involves the lats, biceps and lower back muscles as well, strengthening and toning them. The grasp should be firm on the vertical grips and the body’s alignment should be maintained during the exercises to avoid back injuries.","Cable Row"));
        models.add(new model(R.drawable.bicepscurlpress,"Biceps curl bench is designed for isolation exercises, its main purpose is to work your biceps. It is one of the easiest to use machine, the needed adjustments being limited to adapting the seat height.","Biceps Curl"));
        models.add(new model(R.drawable.legpressmachine,"The leg press machine is for compound exercises, working the quadriceps, calves and hamstrings at the same time. It is equipped with a backrest, an adjustable seat and a leg press. For correctly performing exercises with this machine, legs should be bent and extended slowly and knees should be maintained in a soft lock position.","Leg Press"));
        models.add(new model(R.drawable.legextensionmachine,"Unlike the leg press, leg extension only targets and shapes the quadriceps. Besides keeping the muscles contracted while performing the exercise, you should also pay attention to respiration, exhaling as you straighten the legs and inhaling as you return to the initial position.","Leg Extension"));
        models.add(new model(R.drawable.abdominalcrunchmachine,"Abdominal crunch machine is an isolation machine that only targets the abdominal muscles. This machine is intensely used for crunches by people trying to achieve ripped ABS. For noticeable results and for avoiding injuries, elbows have to be placed against the pads while the head and neck have to be maintained in a neutral position.","Abs Press"));



        adapter =new Adapter(models,this);
        viewPager =findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] color_temp={
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary)
        };

        colors=color_temp;

         viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                 if (position<(adapter.getCount()-1)&&position<(colors.length-1)){

                     viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position],colors[position+1]));

                 }
                 else {
                     viewPager.setBackgroundColor(colors[colors.length-1]);
                 }
             }

             @Override
             public void onPageSelected(int position) {

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
    }
}

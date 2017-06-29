package com.example.lenovo.opps;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;

public class OptionMenuActivity extends Activity {
    ObjectAnimator animY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_option_menu);

    }

    public void startGameActivity(final View view) {
        animY = ObjectAnimator.ofFloat(view, "translationY", -200f, 0f);
        animY.setDuration(500);
        animY.setInterpolator(new BounceInterpolator());

        animY.setRepeatCount(0);
        animY.start();
        view.setBackgroundColor(Color.RED);
        animY.addListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (view.getTag().equals("normal")) {
                    VarHolder.GAME_TYPE = 1;
                } else if (view.getTag().equals("thunder")) {
                    VarHolder.GAME_TYPE = 2;
                } else if (view.getTag().equals("danger")) {
                    VarHolder.GAME_TYPE = 3;
                } else if (view.getTag().equals("zen")) {
                    VarHolder.GAME_TYPE = 4;
                } else if (view.getTag().equals("rush")) {
                    VarHolder.GAME_TYPE = 5;
                }
                Intent i = new Intent(getApplicationContext(), StartGameActivity.class);
                startActivity(i);
                finish();

            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });

    }

    public void startAboutUs(final View view) {
        animY = ObjectAnimator.ofFloat(view, "translationY", -200f, 0f);
        animY.setDuration(500);
        animY.setInterpolator(new BounceInterpolator());
        animY.setRepeatCount(0);
        animY.start();
        view.setBackgroundColor(Color.RED);
        animY.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (view.getTag().equals("about")) {
                    Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                    startActivity(i);
                    finish();
                } else if (view.getTag().equals("score")) {
                    Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
                    startActivity(i);
                    finish();
                } else if (view.getTag().equals("exit")) {
                    AlertDialog.Builder build = new AlertDialog.Builder(OptionMenuActivity.this);
                    build.setTitle("Exit").setIcon(R.drawable.oops).setMessage("Do you really want to exit ?").setPositiveButton("yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = build.create();
                    alert.show();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {

    }

    ;


    protected void onPause() {
        super.onResume();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(0, 0);
    }
}
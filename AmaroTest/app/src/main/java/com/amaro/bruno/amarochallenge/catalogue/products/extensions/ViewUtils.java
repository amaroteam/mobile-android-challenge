package com.amaro.bruno.amarochallenge.catalogue.products.extensions;

import android.animation.Animator;
import android.view.View;

public class ViewUtils {

    public static void hideViewOnScrollDownWithAnimation(View view){
        view
                .animate()
                .translationY(view.getHeight())
                .alpha(0.0f)
                .setDuration(50)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) { }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) { }

                    @Override
                    public void onAnimationRepeat(Animator animator) { }
                });
    }

    public static void showViewOnScrollUpWithAnimation(View view){
        view
                .animate()
                .translationY(0)
                .alpha(1f)
                .setDuration(200)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) { }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) { }

                    @Override
                    public void onAnimationRepeat(Animator animator) { }
                });
    }

}

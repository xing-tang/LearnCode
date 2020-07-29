package com.open.learncode.动画

import android.animation.AnimatorInflater
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation.*
import learncode.open.com.learncode.R

/**
 * Android帧动画、补间动画、属性动画的示例Activity
 */
class AnimationActivity : AppCompatActivity() {

    private var isTween: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        //帧动画
        frameAnimation()
        radio_group.check(R.id.radio_tween)
        radio_group.setOnCheckedChangeListener { _, _ ->
            isTween = radio_tween.isChecked
        }
    }

    /**
     * 帧动画
     */
    private fun frameAnimation() {
        view_animation.setBackgroundResource(R.drawable.animation_frame)
        val drawable = view_animation.background as AnimationDrawable
        btn_frame.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                drawable.start()
            } else {
                drawable.stop()
            }
        }
    }

    fun translate(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_trans)
        } else {
            startPropertyAnimation(R.animator.anim_trans)
        }
    }

    fun scale(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_scale)
        } else {
            startPropertyAnimation(R.animator.anim_scale)
        }
    }

    fun rotate(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_rotate)
        } else {
            startPropertyAnimation(R.animator.anim_rotate)
        }
    }

    fun alpha(v: View) {
        if (isTween) {
            startAnimation(R.anim.anim_alpha)
        } else {
            startPropertyAnimation(R.animator.anim_alpha)
        }
    }

    fun meanwhileAnimate(v: View) {
        if (isTween) {
            startAnimation(R.anim.set_animation1)
        } else {
            startPropertyAnimation(R.animator.set_animation1)
        }
    }

    fun orderAnimate(v: View) {
        if (isTween) {
            startAnimation(R.anim.set_animation2)
        } else {
            startPropertyAnimation(R.animator.set_animation2)
        }
    }

    private fun startAnimation(animation: Int) {
        val animate = AnimationUtils.loadAnimation(this, animation)
        view_animation.startAnimation(animate)
    }

    private fun startPropertyAnimation(animate: Int) {
        val propertyAnimator = AnimatorInflater.loadAnimator(this, animate)
        propertyAnimator.setTarget(view_animation)
        propertyAnimator.start()
    }
}

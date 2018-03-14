package com.example.prat.androidhelloworld;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Prat on 3/8/2018.
 */

public class CustomView extends View {

    private boolean isBlue = false;
    private boolean isDown = false;
    private GestureDetector gestureDetector;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        gestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {

                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                isBlue = !isBlue;
                invalidate();

                return false;
            }
        });

        setClickable(true);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, defStyleRes);
        try {
            isBlue = a.getBoolean(R.styleable.CustomView_isBlue, false);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        if(isBlue)
        {
            p.setColor(0XFF0000FF); //Blue
        }
        else
        {
            p.setColor(0XFFFF0000); //Red
        }

        //canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), p);

        if(isDown)
        {
            canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), p);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //Pass event to GestureDetector
        gestureDetector.onTouchEvent(event);
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                isDown = true;
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                isDown = true;
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                isDown = false;
                invalidate();
                return true;
            case MotionEvent.ACTION_CANCEL:
                isDown = false;
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        CustomerViewSavedState savedState = new CustomerViewSavedState(superState);
        savedState.setBlue(isBlue);

        return  savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        CustomerViewSavedState savedState = (CustomerViewSavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        isBlue = savedState.isBlue();
    }
}

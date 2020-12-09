package com.example.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageViewJobDetail extends ImageView
{
    public SquareImageViewJobDetail(Context context)
    {
        super(context);
    }

    public SquareImageViewJobDetail(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public SquareImageViewJobDetail(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredWidth()/1.5)); //Snap to width
    }
}
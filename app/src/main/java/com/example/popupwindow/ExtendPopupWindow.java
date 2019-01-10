package com.example.popupwindow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by LiuYi on 2019/1/10.
 */
public class ExtendPopupWindow {


    public static class Builder {
        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        public PopupWindow create()
        {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popupView = layoutInflater.inflate(R.layout.popwindow_extend, null);
            final PopupWindow mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
            mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);//解决底部导航栏(NavigationBar)遮挡
            mPopupWindow.setTouchable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable(mContext.getResources(), (Bitmap) null));
            mPopupWindow.getContentView().setFocusableInTouchMode(true);
            mPopupWindow.getContentView().setFocusable(true);
            mPopupWindow.getContentView().setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    Toast.makeText(mContext,"出发事件",Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            popupView.findViewById(R.id.textCancle).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.dismiss();
                }
            });
            return mPopupWindow;

        }
    }
}

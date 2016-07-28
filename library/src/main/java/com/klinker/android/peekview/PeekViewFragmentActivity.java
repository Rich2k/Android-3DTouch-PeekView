package com.klinker.android.peekview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

import jp.wasabeef.blurry.Blurry;

public class PeekViewFragmentActivity extends FragmentActivity {

    private PeekView peekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        removePeek();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (peekView != null && event.getAction() == MotionEvent.ACTION_UP) {

            // the user lifted their finger, so we are going to remove the peek view
            removePeek();

            return false;
        } else if (peekView != null) {

            // we don't want to pass along the touch event or else it will just scroll under the PeekView

            return false;
        }

        return super.dispatchTouchEvent(event);
    }

    public void showPeek(final PeekView view) {
        peekView = view;
        peekView.show();
    }

    public void removePeek() {
        if (peekView != null) {
            peekView.hide();
            peekView = null;
        }
    }
}

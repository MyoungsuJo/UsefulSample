package com.androidworld.msjo.usefulsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity{


    int nImgCount = 0;

    @BindView(R.id.view)
    View view;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameratest);

        ButterKnife.bind(this);

//        Cursor cursor = loadCursor();
//        nImgCount = cursor.getCount();
//        Log.d("jms","jms imgcount : " + nImgCount);
//
//        Intent i = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
//        startActivityForResult(i,3344);

        expand(view);
    }

//    /**
//     * Called when an activity you launched exits, giving you the requestCode
//     * you started it with, the resultCode it returned, and any additional
//     * data from it.  The <var>resultCode</var> will be
//     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
//     * didn't return any result, or crashed during its operation.
//     * <p>
//     * <p>You will receive this call immediately before onResume() when your
//     * activity is re-starting.
//     * <p>
//     * <p>This method is never invoked if your activity sets
//     * {@link android.R.styleable#AndroidManifestActivity_noHistory noHistory} to
//     * <code>true</code>.
//     *
//     * @param requestCode The integer request code originally supplied to
//     *                    startActivityForResult(), allowing you to identify who this
//     *                    result came from.
//     * @param resultCode  The integer result code returned by the child activity
//     *                    through its setResult().
//     * @param data        An Intent, which can return result data to the caller
//     *                    (various data can be attached to Intent "extras").
//     * @see #startActivityForResult
//     * @see #createPendingResult
//     * @see #setResult(int)
//     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.i("jms","onActivityResult : " + requestCode);
////        super.onActivityResult(requestCode, resultCode, data);
//        exitingCamera();
//    }
//
//    public Cursor loadCursor() {
//
//        final String[] columns = { MediaStore.Images.Media.DATA,
//                MediaStore.Images.Media._ID };
//
//        final String orderBy = MediaStore.Images.Media.DATE_ADDED;
//
//        return getContentResolver().query(
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
//                null, orderBy);
//    }
//
//    public String[] getImagePaths(Cursor cursor, int startPosition) {
//
//        int size = cursor.getCount() - startPosition;
//
//        if (size <= 0)
//            return null;
//
//        String[] paths = new String[size];
//
//        int dataColumnIndex = cursor
//                .getColumnIndex(MediaStore.Images.Media.DATA);
//
//        for (int i = startPosition; i < cursor.getCount(); i++) {
//
//            cursor.moveToPosition(i);
//
//            paths[i - startPosition] = cursor.getString(dataColumnIndex);
//        }
//
//        return paths;
//    }
//
//    private void exitingCamera() {
//
//        Cursor cursor = loadCursor();
//        String[] paths = getImagePaths(cursor, nImgCount);
//
//        Log.d("jms","jms length : " + paths.length);
//        Log.d("jms","jms path : " + paths[0]);
//
//        // 이미지 프로세싱 작업
////        new ProcessImage(paths).execute();
//
//        cursor.close();
//
//
//    }


    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
}
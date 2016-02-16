package com.mobaires.gymdroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import com.mobaires.gymdroid.data.DisciplineAdapter;

import java.util.Random;

/**
 * Created by gcalero
 */
public class IconAsyncTask extends AsyncTask<Integer, Void , Bitmap>{

    public static long seed = System.currentTimeMillis();
    public static Random rnd = new Random(seed);

    private final Context ctx;
    private final DisciplineAdapter.ViewHolder holder;
    private final int position;

    public IconAsyncTask(Context ctx, DisciplineAdapter.ViewHolder holder, int position) {
        this.ctx = ctx;
        this.holder = holder;
        this.position = position;
    }

    @Override
    protected Bitmap doInBackground(Integer... integers) {
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(),
                integers[0]);
        try {
            long l = Math.abs(rnd.nextLong() % 1000) + 10;
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return icon;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (holder.position == position) {
            holder.icon.setImageBitmap(bitmap);
            holder.icon.setVisibility(View.VISIBLE);
            holder.task = null;
        }
    }
}

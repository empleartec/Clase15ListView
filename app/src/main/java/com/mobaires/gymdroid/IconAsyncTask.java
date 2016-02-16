package com.mobaires.gymdroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.mobaires.gymdroid.data.DisciplineAdapter;

/**
 * Created by gcalero
 */
public class IconAsyncTask extends AsyncTask<Integer, Void , Bitmap>{

    private final Context ctx;
    private final DisciplineAdapter.ViewHolder holder;

    public IconAsyncTask(Context ctx, DisciplineAdapter.ViewHolder holder) {
        this.ctx = ctx;
        this.holder = holder;
    }

    @Override
    protected Bitmap doInBackground(Integer... integers) {
        Bitmap icon = BitmapFactory.decodeResource(ctx.getResources(),
                integers[0]);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return icon;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        holder.icon.setImageBitmap(bitmap);

    }
}

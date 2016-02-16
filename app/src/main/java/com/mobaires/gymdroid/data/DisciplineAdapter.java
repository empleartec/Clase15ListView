package com.mobaires.gymdroid.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobaires.gymdroid.IconAsyncTask;
import com.mobaires.gymdroid.R;

import java.util.List;

/**
 * Created by gcalero
 */
public class DisciplineAdapter extends BaseAdapter {


    private final Context ctx;
    private final List<Discipline> list;
    private LayoutInflater inflater;

    public DisciplineAdapter(Context ctx, List<Discipline> disciplineList) {
        this.ctx = ctx;
        this.list = disciplineList;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ((Discipline)getItem(i)).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View row;
        ViewHolder holder;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_discipline_row_example, null);
            holder = new ViewHolder();
            holder.icon = (ImageView) row.findViewById(R.id.icon);
            holder.title = (TextView) row.findViewById(R.id.list_item_title);
            holder.subtitle = (TextView) row.findViewById(R.id.list_item_subtitle);
            holder.rightText = (TextView) row.findViewById(R.id.list_item_right_text);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }


        Discipline dis = (Discipline) getItem(position);

        new IconAsyncTask(ctx, holder).execute(dis.getLogoResId());

        holder.title.setText(dis.getName());
        holder.subtitle.setText(ctx.getString(R.string.level) + dis.getLevel());
        holder.rightText.setText(dis.getSchedule());

        holder.position = position;
        return row;
    }

    public static class ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView subtitle;
        public TextView rightText;
        public int position;
    }
}

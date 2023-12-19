package kr.jonghyeok.android.liberty4u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContentGridAdapter extends BaseAdapter {
    ArrayList<ContentItem> items = new ArrayList<ContentItem>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    public void addItem(ContentItem item) {
            items.add(item);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        final ContentItem contentItem = items.get(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_contents, viewGroup, false);

            TextView tv_name = (TextView) convertView.findViewById(R.id.tvContentName);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_content);

            tv_name.setText(contentItem.getName());
            iv_icon.setImageResource(contentItem.getResId());

        } else {
            View view = new View(context);
            view = (View) convertView;
        }

        //각 아이템 선택 event
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, contentItem.getName()+" 입니당! ", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;  //뷰 객체 반환
    }
}

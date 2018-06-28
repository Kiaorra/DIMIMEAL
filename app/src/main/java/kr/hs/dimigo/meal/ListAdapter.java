package kr.hs.dimigo.meal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kr.hs.dimigo.meal.ListViewItem;

public class ListAdapter extends BaseAdapter{

    ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();

    // 생성자
    public ListAdapter() {

    }


    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);

            TextView dayTime = convertView.findViewById(R.id.dayTime);
        }

        return null;
    }
}

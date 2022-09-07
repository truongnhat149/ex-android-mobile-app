package lpnt.com.todolist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WorkAdapter extends BaseAdapter {

    private MainActivity context;

    private int layout;

    private List<Work> workList;

    public WorkAdapter(MainActivity context, int layout, List<Work> workList) {
        this.context = context;
        this.layout = layout;
        this.workList = workList;
    }

    @Override
    public int getCount() {
        return workList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName;
        ImageView imgEdit, imgDel;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder.txtName = view.findViewById(R.id.textViewOne);
            viewHolder.imgEdit = view.findViewById(R.id.imageId1);
            viewHolder.imgDel  = view.findViewById(R.id.imageId2);

            view.setTag(viewHolder);


        } else  {
            viewHolder = (ViewHolder) view.getTag();
        }

        Work work = workList.get(i);

        viewHolder.txtName.setText(work.getName());

        // take event edit delete

        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogEditWork(work.getWorkId(), work.getName());
            }
        });


        viewHolder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.dialogDeleteWork(work.getWorkId(), work.getName());
            }
        });

        return view;
    }
}

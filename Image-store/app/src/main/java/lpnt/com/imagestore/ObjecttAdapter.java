package lpnt.com.imagestore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ObjecttAdapter extends BaseAdapter{

    private Context context;

    private int layout;

    private List<Objectt> objecttList;

    public ObjecttAdapter(Context context, int layout, List<Objectt> objecttList) {
        this.context = context;
        this.layout = layout;
        this.objecttList = objecttList;
    }


    @Override
    public int getCount() {
        return objecttList.size();
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
        TextView txtName, txtDesc;
        ImageView imgView;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout, null);

            holder.txtName = view.findViewById(R.id.textShowListName);
            holder.txtDesc = view.findViewById(R.id.textShowListDesc);
            holder.imgView = view.findViewById(R.id.textViewImage);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Objectt objectt = objecttList.get(i);

        holder.txtName.setText(objectt.getName());
        holder.txtDesc.setText(objectt.getDescription());

        // convert byte[ư => bitmapp

        byte[] img = objectt.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);

        holder.imgView.setImageBitmap(bitmap);

        return view;
    }
}

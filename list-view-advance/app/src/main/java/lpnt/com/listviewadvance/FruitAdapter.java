package lpnt.com.listviewadvance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;

    private int layout;

    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
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
        ImageView imgFruit;
        TextView txtTitle, txtDescription;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(layout, null);

            holder.txtTitle = view.findViewById(R.id.textTitle);
            holder.txtDescription = view.findViewById(R.id.textDesc);
            holder.imgFruit = view.findViewById(R.id.imgFruit);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        Fruit fruit = fruitList.get(i);

        holder.txtTitle.setText(fruit.getTitle());
        holder.txtDescription.setText(fruit.getDescription());
        holder.imgFruit.setImageResource(fruit.getImage());

        return view;
    }
}

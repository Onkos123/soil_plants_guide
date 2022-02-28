package br.keneitec.dio.trabalhobiologia.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.keneitec.dio.trabalhobiologia.R;
import br.keneitec.dio.trabalhobiologia.model.ClasseGeral;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<ClasseGeral> list;
    private int tipoEscolhido;

    LayoutInflater inflater;

    public GridAdapter(Context context, List<ClasseGeral> list, int tipoEscolhido) {
        this.context = context;
        this.list = list;
        this.tipoEscolhido = tipoEscolhido;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null){
            view = inflater.inflate(R.layout.grid_item,null);
        }


        ImageView image = view.findViewById(R.id.iv_grid);
        TextView text = view.findViewById(R.id.tv_grid);
        //LinearLayout layout = view.findViewById(R.id.linearGrid);
        image.setImageResource(list.get(position).getImagem());
        text.setText(list.get(position).getNome());


        return view;
    }
}

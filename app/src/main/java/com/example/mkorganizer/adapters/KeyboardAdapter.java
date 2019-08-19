package com.example.mkorganizer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mkorganizer.R;
import com.example.mkorganizer.entity.Keyboard;
import com.example.mkorganizer.utils.AppContext;

import java.util.List;

public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.ViewHolder> {

    private List<Keyboard> keyboardList;

    public KeyboardAdapter(List<Keyboard> keyboardList) {
        this.keyboardList = keyboardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.keyboard_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.brandRow.setText(keyboardList.get(position).getBrand());
        holder.modelRow.setText(keyboardList.get(position).getModel());
        holder.switchesRow.setText(keyboardList.get(position).getSwitches());

        holder.keyboardrow.setOnLongClickListener(view -> {
            Toast.makeText(AppContext.getContext(), keyboardList.get(position).getBrand(), Toast.LENGTH_LONG).show();
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return keyboardList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout keyboardrow;
        TextView brandRow;
        TextView modelRow;
        TextView switchesRow;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            keyboardrow = itemView.findViewById(R.id.keyboardrow);
            brandRow = itemView.findViewById(R.id.brandRow);
            modelRow = itemView.findViewById(R.id.modelRow);
            switchesRow = itemView.findViewById(R.id.switchesRow);
        }
    }
}

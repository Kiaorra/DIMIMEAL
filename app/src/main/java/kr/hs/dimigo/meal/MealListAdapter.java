package kr.hs.dimigo.meal;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.hs.dimigo.meal.data.DateCalculator;

public class MealListAdapter extends RecyclerView.Adapter<MealListAdapter.MyViewHolder> {

    private List<String> meals;

    private boolean isToday;

    public MealListAdapter(List<String> meals, boolean isToday) {
        this.meals = meals;
        this.isToday = isToday;
    }

    @NonNull
    @Override
    public MealListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealListAdapter.MyViewHolder holder, int position) {
        setupContent(holder, position);
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView lamp;
        TextView title, content;

        public MyViewHolder(View itemView) {
            super(itemView);
//            lamp = itemView.findViewById(R.id.lamp);
//            title = itemView.findViewById(R.id.title);
//            content = itemView.findViewById(R.id.mealContent);
        }
    }

    // 리스트에 있는 각각의 아이템들이 포함하는 급식정보를 세팅하는 메소드이다.
    private void setupContent(MealListAdapter.MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.title.setText(R.string.title_breakfast);
                break;
            case 1:
                holder.title.setText(R.string.title_lunch);
                break;
            case 2:
                holder.title.setText(R.string.title_dinner);
                break;
            case 3:
                holder.title.setText(R.string.title_snack);
                break;
            default:
                break;
        }
        holder.content.setText(meals.get(position));

        if(isToday) setupColor(holder, position);
    }

    // 시간대에 따라 급식정보, 램프의 색상을 변경하는 메소드이다.
    private void setupColor(MealListAdapter.MyViewHolder holder, int position) {
        if(DateCalculator.lampSelector() == position) {
            holder.title.setTextColor(Color.BLACK);
            holder.content.setTextColor(Color.BLACK);
            holder.lamp.setImageResource(R.drawable.ic_lamp_on);
        }
    }
}

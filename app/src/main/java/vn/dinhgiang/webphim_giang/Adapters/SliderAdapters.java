package vn.dinhgiang.webphim_giang.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import vn.dinhgiang.webphim_giang.Domain.SliderItems;
import vn.dinhgiang.webphim_giang.R;

public class SliderAdapters extends RecyclerView.Adapter<SliderAdapters.SliderViewHoder> {
    private List<SliderItems> sliderItems;
    private ViewPager2 viewPager2;
    private Context context;

    public SliderAdapters(List<SliderItems> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapters.SliderViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return  new SliderViewHoder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_item_container,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapters.SliderViewHoder holder, int position) {
    holder.setImage(sliderItems.get(position));
    if (position==sliderItems.size()-2){
        viewPager2.post(runnable);
    }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }
    public class SliderViewHoder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public SliderViewHoder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }
        void setImage(SliderItems sliderItems){
            RequestOptions requestOptions = new RequestOptions();
            requestOptions=requestOptions.transforms(new CenterCrop(),new RoundedCorners(60));

            Glide.with(context)
                    .load(sliderItems.getImage())
                    .apply(requestOptions)
                    .into(imageView);
        }
    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}

package shuza.sa.babyapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import shuza.sa.babyapp.R;

/**
 * Created by Boka on 21-May-15.
 */
public class PhotoListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> items;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    public PhotoListAdapter(Context context, ArrayList<String> items){
        this.context = context;
        this.items = items;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(0)).build();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewToUse = null;
        ViewHolder holder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            viewToUse = inflater.inflate(R.layout.photo_list_item, null);
            holder = new ViewHolder();
            holder.iv = (ImageView) viewToUse.findViewById(R.id.ivListItem);
        }else{
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        imageLoader.displayImage(items.get(position), holder.iv, options);

        viewToUse.setTag(holder);
        return viewToUse;
    }

    class ViewHolder{
        ImageView iv;
    }
}

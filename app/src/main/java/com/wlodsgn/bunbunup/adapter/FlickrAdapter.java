package com.wlodsgn.bunbunup.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.wlodsgn.bunbunup.JeansDetailsActivity;
import com.wlodsgn.bunbunup.R;

import java.util.List;

/**
 * Created by WILO on 3/18/2015.
 */
public class FlickrAdapter extends ArrayAdapter<JeansDetailsActivity> {
    private ImageLoader mImageLoader;
    /**private boolean mIsListView;**/

    public FlickrAdapter(Context context, int textViewResourceId, List<JeansDetailsActivity> objects,
                         ImageLoader imageLoaderFS) {
        super(context, textViewResourceId, objects);
        mImageLoader = imageLoaderFS;
        /**mIsListView = textViewResourceId == R.id.list_view;**/
    }

    /**@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        /**if (view == null) {
            LayoutInflater inflator = (LayoutInflater) this.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(mIsListView ? R.layout.lv_item : R.layout.gv_item, null);
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }**/

        /**PhotoItem entry = getItem(position);
        String thumbUrl = entry.getThumbnailUrl();
        if (!TextUtils.isEmpty(thumbUrl)) {
            holder.image.setImageUrl(thumbUrl, mImageLoader);
        } else {
            holder.image.setImageResource(R.drawable.flickr); // TODO use a better placeholder.
        }**/

        /**holder.title.setText(entry.getTitle());
        if (mIsListView) {
            holder.author.setText(entry.getAuthor());
            holder.timestamp.setText(entry.getDateTaken());
        }

        return view;
    }**/

    private class ViewHolder {
        NetworkImageView image;
        /**TextView title;
        TextView author;
        TextView timestamp;**/

        public ViewHolder(View view) {
            image = (NetworkImageView) view.findViewById(R.id.fullScreenImg);
            /**title = (TextView) view.findViewById(R.id.lv_title);
            if (mIsListView) {
                author = (TextView) view.findViewById(R.id.lv_author);
                timestamp = (TextView) view.findViewById(R.id.lv_date);**/
            }

            /**view.setTag(this);**/

    }

}

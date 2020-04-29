package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(@NonNull Context context, List<Word> words) {
        super(context, 0,words);

    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word word = getItem(position);
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        ImageView img = (ImageView) listItemView.findViewById(R.id.image_word);
        if(word.getImagePath()!=0)
            img.setImageDrawable(getContext().getResources().getDrawable(word.getImagePath()));
        else
            img.setVisibility(View.GONE);

       TextView tv = (TextView) listItemView.findViewById(R.id.miowokText);
        tv.setText(word.getMiowokWord());

        tv = (TextView) listItemView.findViewById(R.id.englishText);
        tv.setText(word.getDefTransaltion());



        return listItemView;
    }

}

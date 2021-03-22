package com.alongo.tourguideapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter {


    public CardAdapter(Context context, ArrayList<Card> pCards) {
        super(context, 0, pCards);

    }

    ArrayList<Boolean> arrayIsSmall = new ArrayList<>();


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            arrayIsSmall.trimToSize();
        }

        arrayIsSmall.add(position, true);


        TextView cardNameView = listItemView.findViewById(R.id.textViewCardName);
        final Card my_card = (Card) getItem(position);
        final ImageView imageViewArrow = listItemView.findViewById(R.id.imageViewArrow);
        final TextView cardInformationView = listItemView.findViewById(R.id.textViewCardInfo);
        cardNameView.setText(my_card.getCardName());
        cardInformationView.setText(my_card.getCardInformation());

        imageViewArrow.setImageResource(R.drawable.ic_arrow_down_black_24dp);
        cardInformationView.setMaxLines(3);
        cardInformationView.setEllipsize(TextUtils.TruncateAt.END);


        ImageView imageViewCard = listItemView.findViewById(R.id.imageViewCard);


        if (my_card.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageViewCard.setImageResource(my_card.getCardImageResourceId());
            // Make sure the view is visible
            imageViewCard.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageViewCard.setVisibility(View.GONE);
        }

        LinearLayout webLinkViewLayout = listItemView.findViewById(R.id.linearLayoutWebLink);

        if (my_card.hasWeblink()) {
            final TextView textViewWeblink = listItemView.findViewById(R.id.textViewWeblink);

            textViewWeblink.setSingleLine(true);
            textViewWeblink.setEllipsize(TextUtils.TruncateAt.END);
            textViewWeblink.setText(my_card.getCardWebLink());
            webLinkViewLayout.setVisibility(View.VISIBLE);
        } else {
            webLinkViewLayout.setVisibility(View.GONE);

        }

        LinearLayout layoutCardTextInformation = listItemView.findViewById(R.id.LinearLayoutCardTextInformation);
        layoutCardTextInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrayIsSmall.get(position)) {
                    expandInformationTextView(imageViewArrow, cardInformationView, position);
                } else {
                    truncateInfoTextView(imageViewArrow, cardInformationView, position);
                }
            }
        });


        return listItemView;
    }

    public void expandInformationTextView(ImageView imageArrow, TextView cardInfo, int position) {
        imageArrow.setImageResource(R.drawable.ic_arrow_up_black_24dp);
        cardInfo.setMaxLines(0);
        arrayIsSmall.set(position, false);

    }

    public void truncateInfoTextView(ImageView imageArrow, TextView cardInfo, int position) {
        imageArrow.setImageResource(R.drawable.ic_arrow_down_black_24dp);
        cardInfo.setMaxLines(3);
        cardInfo.setEllipsize(TextUtils.TruncateAt.END);
        arrayIsSmall.set(position, true);
    }
}

package com.alongo.tourguideapp;

public class Card {

    private int mCardName;
    private int mCardInfo;


    private int mPictureId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mWebLink = NO_LINK_PROVIDED;
    private static final int NO_LINK_PROVIDED = -1;

    public Card(int pictureId, int cardName, int cardInfoId, int weblink) {
        mCardName = cardName;
        mCardInfo = cardInfoId;
        mPictureId = pictureId;
        mWebLink = weblink;
 }

    public Card(int pictureId, int cardName, int cardInfoId) {
        mCardName = cardName;
        mCardInfo = cardInfoId;
        mPictureId = pictureId;

    }
    public int getCardName() {
        return mCardName;
    }

    public int getCardInformation() {
        return mCardInfo;
    }

    public int getCardImageResourceId() {
        return mPictureId;
    }
    public int getCardWebLink() {
        return mWebLink;
    }
    public boolean hasImage() {
        return mPictureId != NO_IMAGE_PROVIDED;
    }
    public boolean hasWeblink() {
        return mWebLink != NO_LINK_PROVIDED;
    }
}

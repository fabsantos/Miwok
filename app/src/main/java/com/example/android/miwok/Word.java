package com.example.android.miwok;

/**
 * Created by Fabiola on 12/05/2017.
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word, as well as a sound file with a pronunciation and it
 *                  may or may not contain an image
 */

public class Word {

    //String for Miwok word
    private String mMiwokTranslation;

    //String for Default language word
    private String mDefaultTranslation;

    //Integer for the image resource ID
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    //Constant for the no image value
    private static final int NO_IMAGE_PROVIDED = -1;

    //Variable for the sound resource ID
    private int mSoundResourceID;


    /**
     * Constructor - Create a new Word object for numbers, family and colors (with image).
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param image imageResourceID, is the id of the drawable containing the image
     * @param soundResourceID is the pronunciation sound resource ID
     */
    public Word(String miwokTranslation, String defaultTranslation, int image, int soundResourceID) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceID = image;
        mSoundResourceID = soundResourceID;

    }

    /**
     * Constructor - Create a new Word object for phrases (without image).
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param soundResourceID is the pronunciation sound resource ID
     */
    public Word(String miwokTranslation, String defaultTranslation, int soundResourceID) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mSoundResourceID = soundResourceID;
    }

    //Get the default translation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    //Get the Miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    //Get the image for the word
    public int getImageResourceID (){return mImageResourceID;}

    //Returns whether there is or not an image for the word
    public boolean hasImage (){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    //Get the sound resourceID for the word
    public int getSoundResourceID(){ return mSoundResourceID;}
}
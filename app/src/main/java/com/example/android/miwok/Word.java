package com.example.android.miwok;

public class Word {

    private String defWord;
    private String miowokWord;

    private int imagePath;
    private  int songPath;

    @Override
    public String toString() {
        return "Word{" +
                "defWord='" + defWord + '\'' +
                ", miowokWord='" + miowokWord + '\'' +
                ", imagePath=" + imagePath +
                ", songPath=" + songPath +
                '}';
    }

    public Word(String defWord, String miowokWord, int imagePath, int songPath) {
        this.defWord = defWord;
        this.miowokWord = miowokWord;
        this.imagePath = imagePath;
        this.songPath = songPath;
    }

    public String getDefTransaltion() {
        return defWord;
    }

    public void setdefaultTraslation(String defWord) {
        this.defWord = defWord;
    }

    public String getMiowokWord() {
        return miowokWord;
    }

    public void setMiowokWord(String miowokWord) {
        this.miowokWord = miowokWord;
    }


    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getSongPath() {
        return songPath;
    }
}

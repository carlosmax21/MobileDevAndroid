package id.ac.umn.uts_34638;

import java.io.Serializable;

public class AudioItem implements Serializable {

    private String title;
    private String category;
    private String audioURI;

    public AudioItem(String title, String category, String audioURI){
        this.title = title;
        this.category = category;
        this.audioURI = audioURI;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAudioURI() {
        return audioURI;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAudioURI(String audioURI) {
        this.audioURI = audioURI;
    }
}

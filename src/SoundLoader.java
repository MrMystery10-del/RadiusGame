

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundLoader {

public void playClick(){

    try {
         URL path = this.getClass().getClassLoader().getResource("gameDesign/sounds/click.wav");
         AudioInputStream stream = AudioSystem.getAudioInputStream(path);
         
         Clip clip = AudioSystem.getClip();

        clip.open(stream);
        clip.start();
    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
        e.printStackTrace();
    }

}

public void playBackground(){
    try{
         URL path = this.getClass().getClassLoader().getResource("gameDesign/sounds/background_music.wav");
         AudioInputStream stream = AudioSystem.getAudioInputStream(path);
         
         Clip clip = AudioSystem.getClip();

        clip.open(stream);
        clip.start();
    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
        e.printStackTrace();
    }
}

}


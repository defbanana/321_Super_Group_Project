import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class creates can be called to play a .wav file.
 */
public class BGmusic
{
	/**
	 * Plays sound file for duration of clip, loops forever.
	 * @param fileName the filename of the .wav sound file you want to play.
	 *
	 */
    public static synchronized void play(final String fileName) 

    {

        // Note: use .wav files             

        new Thread(new Runnable() { 
        	
        	/**
        	 * This is what really gets the sound playing and checks for missing/wrong files.
        	 */
            public void run() {

                try {

                    Clip clip = AudioSystem.getClip();

                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));

                    clip.open(inputStream);

                    clip.start(); 
                    
                    clip.loop(Clip.LOOP_CONTINUOUSLY);

                } catch (Exception e) {

                    System.out.println("play sound error: " + e.getMessage() + " for " + fileName);

                }

            }

        }).start();

    }

}





package AudioANDfailScreen;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPF {
    public void pass(){
        try {
            // Load the audio file
            File file = new File("src/AudioANDfailScreen/Pokemon Level Up - Sound Effect SFX.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Start playing the audio
            clip.start();

            // Add a LineListener to detect when the clip stops
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    synchronized (clip) {
                        clip.notify(); // Notify the main thread when playback ends
                    }
                }
            });

            // Wait for the clip to finish playing
            synchronized (clip) {
                while (clip.isRunning()) {
                    clip.wait(); // Wait until playback completes
                }
            }

            // Close the clip after playback
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void fail(){
        try {
            // Load the audio file
            File file = new File("src/AudioANDfailScreen/Spongebob - disappointed sound effect.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Start playing the audio
            clip.start();

            // Add a LineListener to detect when the clip stops
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    synchronized (clip) {
                        clip.notify(); // Notify the main thread when playback ends
                    }
                }
            });

            // Wait for the clip to finish playing
            synchronized (clip) {
                while (clip.isRunning()) {
                    clip.wait(); // Wait until playback completes
                }
            }

            // Close the clip after playback
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

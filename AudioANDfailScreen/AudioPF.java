package AudioANDfailScreen;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPF {
    private Clip passClip;
    private Clip failClip;

    public AudioPF() {
        try {
            // Pre-load pass sound
            File passFile = new File("src/AudioANDfailScreen/Pokemon Level Up - Sound Effect SFX.wav");
            AudioInputStream passStream = AudioSystem.getAudioInputStream(passFile);
            passClip = AudioSystem.getClip();
            passClip.open(passStream);

            // Pre-load fail sound
            File failFile = new File("src/AudioANDfailScreen/Spongebob - disappointed sound effect.wav");
            AudioInputStream failStream = AudioSystem.getAudioInputStream(failFile);
            failClip = AudioSystem.getClip();
            failClip.open(failStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pass() {
        if (passClip != null) {
            passClip.setFramePosition(0); // Reset to start
            passClip.start(); // Play
        }
    }

    public void fail() {
        if (failClip != null) {
            failClip.setFramePosition(0); // Reset to start
            failClip.start(); // Play
        }
    }
}
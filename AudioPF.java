package AudioANDfailScreen;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPF {
    private Clip passClip;
    private Clip failClip;
    private Clip ballLaunch;

    public AudioPF() {
        try {
            // pre load pass sound
            AudioInputStream passStream = AudioSystem.getAudioInputStream(new File("src/AudioANDfailScreen/levelClear.wav"));
            passClip = AudioSystem.getClip();
            passClip.open(passStream);

            // pre load fail sound
            AudioInputStream failStream = AudioSystem.getAudioInputStream(new File("src/AudioANDfailScreen/fail.wav"));
            failClip = AudioSystem.getClip();
            failClip.open(failStream);

            // pre load shot sound
            AudioInputStream blStream = AudioSystem.getAudioInputStream(new File("src/AudioANDfailScreen/ball_launch.wav"));
            ballLaunch = AudioSystem.getClip();
            ballLaunch.open(blStream);
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

    public void ball(){
        if(ballLaunch != null){
            ballLaunch.setFramePosition(0);
            ballLaunch.start();
        }
    }
}
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
            // Pre-load pass sound
            File passFile = new File("src/AudioANDfailScreen/levelClear.wav");
            AudioInputStream passStream = AudioSystem.getAudioInputStream(passFile);
            passClip = AudioSystem.getClip();
            passClip.open(passStream);

            // Pre-load fail sound
            File failFile = new File("src/AudioANDfailScreen/fail.wav");
            AudioInputStream failStream = AudioSystem.getAudioInputStream(failFile);
            failClip = AudioSystem.getClip();
            failClip.open(failStream);

            File ballLaunchFile = new File("src/AudioANDfailScreen/ball_launch.wav");
            AudioInputStream blStream = AudioSystem.getAudioInputStream(ballLaunchFile);
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
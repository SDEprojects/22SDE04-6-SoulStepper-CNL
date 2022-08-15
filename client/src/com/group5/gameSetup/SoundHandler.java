package com.group5.gameSetup;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoundHandler {

    protected static Clip clip;

    // this will start the background music
    public void startBackgroundMusic() {

        List<String> playList = new ArrayList<>();
        playList.add("musicAndSoundEffectFiles/Computer Love.wav");
        playList.add("musicAndSoundEffectFiles/Donna Summer - I Feel Love [Studio Version].wav");
        playList.add("musicAndSoundEffectFiles/Gloria  Gaynor   --   I   Will   Survive   [[  Official  Video  ]] HD.wav");
        playList.add("musicAndSoundEffectFiles/Michael Jackson - Billie Jean [Instrumental Version].wav");
        playList.add("musicAndSoundEffectFiles/Phil Collins - In the Air Tonight.wav");



        Random rand = new Random();
        String newSong = playList.get(rand.nextInt(playList.size()));
        try {
            if (clip == null) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File(newSong));
                clip = AudioSystem.getClip();
                clip.open(audio);
                FloatControl gainControl =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-15.0f);
            }
            if (!clip.isRunning()) {
                clip.start();
            }
        }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException uae) {
            System.out.println(uae);
        }
    }
    // this will stop the background music
    public void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
        }
    }
}


import java.io.File;
import javax.sound.sampled.*;


public class Sound {
    private File magicSound=new File("./src/resources/spell.wav");

    private File heroSound=new File("./src/resources/hero.wav");
    private File battle=new File("./src/resources/pokemon.wav");

    private File win=new File("./src/resources/12_3.wav");

    private File monster=new File("./src/resources/monster.wav");

    private File potion=new File("./src/resources/potion.wav");
    public void Magic(){
        mp3(magicSound);
    }
    public void heroAttack(){
        mp3(heroSound);
    }
    public void Battle(){
        mp3(battle);
    }
    public void Win(){
        mp3(win);
    }
    public void monster(){
        mp3(monster);
    }

    public void potion(){
        mp3(potion);
    }
    public void mp3(File soundFile){
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    // Get a clip resource
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    // Start the clip
                    clip.start();
                    // Wait for the clip to stop playing
                    while (!clip.isRunning())
                        Thread.sleep(10);
                    while (clip.isRunning())
                        Thread.sleep(10);
                    // Close resources
                    clip.close();
                    audioInputStream.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame extends JFrame implements KeyListener {
    
    MainPanel mp;
    
    public MyJFrame(MainPanel mp) {
        this.mp = mp;
        addKeyListener(this);
        mp.playerAvatar = mp.ash;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {
        moveAvatar(e);
        System.out.println();
        System.out.println("X pos = " + mp.playerAvatarInitPositionX + "\nY pos = " + mp.playerAvatarInitPositionY);
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    private void moveAvatar(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'w' && mp.playerAvatarInitPositionY >= mp.avatarSize / 2)
            mp.playerAvatarInitPositionY -= 50;
        if (keyEvent.getKeyChar() == 's' && mp.playerAvatarInitPositionY < mp.getHeight() - mp.avatarSize)
            mp.playerAvatarInitPositionY += 50;
        if (keyEvent.getKeyChar() == 'a' && mp.playerAvatarInitPositionX >= mp.avatarSize / 2)
            mp.playerAvatarInitPositionX -= 50;
        if (keyEvent.getKeyChar() == 'd' && mp.playerAvatarInitPositionX < mp.getWidth() - mp.avatarSize * 1.5)
            mp.playerAvatarInitPositionX += 50;
        changeAvatar();
    }
    
    private void changeAvatar() {
        switch (checkPlayerPosition()) {
            case "BULB" -> mp.playerAvatar = mp.bulb;
            case "SQU" -> mp.playerAvatar = mp.squ;
            case "CHARM" -> mp.playerAvatar = mp.charm;
            default -> mp.playerAvatar = mp.ash;
        }
    }
    
    private String checkPlayerPosition() {
        if ((mp.playerAvatarInitPositionY <= mp.pokemonDistanceY + mp.avatarSize)
            && (mp.playerAvatarInitPositionY >= mp.pokemonDistanceY - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX >= mp.leafPositionX - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX <= mp.leafPositionX + mp.avatarSize))
            return "BULB";
        if ((mp.playerAvatarInitPositionY <= mp.pokemonDistanceY + mp.avatarSize)
            && (mp.playerAvatarInitPositionY >= mp.pokemonDistanceY - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX >= mp.waterPositionX - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX <= mp.waterPositionX + mp.avatarSize))
            return "SQU";
        if ((mp.playerAvatarInitPositionY <= mp.pokemonDistanceY + mp.avatarSize)
            && (mp.playerAvatarInitPositionY >= mp.pokemonDistanceY - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX >= mp.firePositionX - mp.playerAvatarSize)
            && (mp.playerAvatarInitPositionX <= mp.firePositionX + mp.avatarSize))
            return "CHARM";
        
        return "Ash";
    }
}
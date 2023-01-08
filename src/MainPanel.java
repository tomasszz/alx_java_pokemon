import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel {
    
    int tileSize = 48;
    int avatarScale = 2;
    int initialPanelWidth = tileSize * 30;
    int initialPanelHeight = tileSize * 20;
    
    int pokemonDistanceY = initialPanelHeight / 5;
    int pokemonDistanceX = initialPanelWidth / 3;
    int leafPositionX = pokemonDistanceX / 2;
    int waterPositionX = leafPositionX + pokemonDistanceX;
    int firePositionX = waterPositionX + pokemonDistanceX;
    
    int avatarSize = tileSize * avatarScale;
    int playerAvatarSize = avatarSize;
    
    Image background;
    Image ash;
    Image bulb;
    Image charm;
    Image squ;
    Image fire;
    Image water;
    Image leaf;
    
    Image playerAvatar;
    
    int x = 0;
    int y = 0;
    
    int playerAvatarInitPositionX = initialPanelWidth - initialPanelWidth / 2 - avatarSize / 2;
    int playerAvatarInitPositionY = initialPanelHeight - avatarSize;
    
    public MainPanel() {
        try {
            background = ImageIO.read(new File("bg.jpg"));
            ash = ImageIO.read(new File("ash.png"));
            bulb = ImageIO.read(new File("Bulbasaur.png"));
            charm = ImageIO.read(new File("Charmander.png"));
            squ = ImageIO.read(new File("Squirtle.png"));
            fire = ImageIO.read(new File("fire.png"));
            water = ImageIO.read(new File("water.png"));
            leaf = ImageIO.read(new File("leaf.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics component) {
        super.paintComponent(component);
        component.drawImage(background, x, y, initialPanelWidth, initialPanelHeight, null);
        component.drawImage(leaf, leafPositionX, pokemonDistanceY, avatarSize, avatarSize, null);
        component.drawImage(water, waterPositionX, pokemonDistanceY, avatarSize, avatarSize, null);
        component.drawImage(fire, firePositionX, pokemonDistanceY, avatarSize, avatarSize, null);
        component.drawImage(playerAvatar, playerAvatarInitPositionX, playerAvatarInitPositionY, playerAvatarSize, playerAvatarSize, null);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(initialPanelWidth, initialPanelHeight);
    }
}
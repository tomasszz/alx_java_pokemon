import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        MainPanel mp = new MainPanel();
        MyJFrame frame = new MyJFrame(mp);
        
        frame.add(mp);
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
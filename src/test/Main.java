package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import map.MapGen;

/**
 *
 * @author max
 */
public class Main extends JFrame {

    Container c = getContentPane();

    public Main() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Générateur de map");
        JPanel panel = new EssaiPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        c.add(panel);
    }

    class EssaiPanel extends JPanel {

        private BufferedImage img;
        private int col = 0;
        

        public EssaiPanel() {
            super();
        }

        @Override
        public void paint(Graphics g) {
            int imgWidth = getWidth();
            int imgHeight = getHeight();
            img = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
            MapGen map = new MapGen(0x42);
            for (int i = -300; i < 300; i += 1) {
                for (int j = -300; j < 300; j += 1) {

                    Enum type = map.getType(i, j);
                    if (type == MapGen.TYPE.WATER) {
                        col = Color.BLUE.getRGB();
                    } else if (type == MapGen.TYPE.LAND) {
                        col = Color.GREEN.getRGB();
                    } else if (type == MapGen.TYPE.HIDDEN) {
                        col = Color.BLACK.getRGB();
                    } else if (type == MapGen.TYPE.UNDEFINED) {
                        col = Color.BLACK.getRGB();
                    } else {
                        col = Color.BLACK.getRGB();
                    }

                    img.setRGB(i+(imgWidth/2), j+(imgHeight/2), col);
                }
            }
            g.drawImage(img, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.BLUE.getRGB() + "," + Color.GREEN.getRGB());
        Main map = new Main();
        map.pack();
        map.setVisible(true);
    }
}

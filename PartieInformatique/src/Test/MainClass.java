package Test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainClass extends JPanel{
    private static final int D_W = 400;
    private static final int D_H = 400;

    Cube cube;
    public MainClass() {
        cube = new Cube(75, 75, 200, 50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cube.drawCube(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Cube {
        int x, y, size, shift;
        Point[] cubeOnePoints;
        Point[] cubeTwoPoints;
        public Cube(int x, int y, int size, int shift) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.shift = shift;
            cubeOnePoints = getCubeOnePoints();
            cubeTwoPoints = getCubeTwoPoints();
        }

        private Point[] getCubeOnePoints() {
            Point[] points = new Point[4];
            points[0] = new Point(x, y);
            points[1] = new Point(x + size, y);
            points[2] = new Point(x + size, y + size);
            points[3] = new Point(x, y + size);
            return points;
        }

        private Point[] getCubeTwoPoints() {
            int newX = x + shift;
            int newY = y + shift;
            Point[] points = new Point[4];
            points[0] = new Point(newX, newY);
            points[1] = new Point(newX + size, newY);
            points[2] = new Point(newX + size, newY + size);
            points[3] = new Point(newX, newY + size);
            return points;
        }

        public void drawCube(Graphics g) {
            g.drawRect(x, y, size, size);
            g.drawRect(x + shift, y + shift, size, size);
            // draw connecting lines
            for (int i = 0; i < 4; i++) {
                g.drawLine(cubeOnePoints[i].x, cubeOnePoints[i].y, 
                        cubeTwoPoints[i].x, cubeTwoPoints[i].y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new MainClass());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
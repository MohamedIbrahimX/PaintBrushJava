package paintbrush;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    List<Line> lines = new ArrayList<>();
    List<Rectangle> rectangles = new ArrayList<>();
    List<Oval> ovals = new ArrayList<>();
    List<Eraser> erasers = new ArrayList<>();
    List<FreeHand> freeHands = new ArrayList<>();
    String currentShape = "l";  
    //Buttons
    Button line;
    Button rectangle;
    Button oval;
    Button eraser;
    Button redButton;
    Button greenButton;
    Button blueButton;
    Button clearAllButton;
    JCheckBox filledCheckbox;
    Button freeHandButton;
    Button undoButton;

    boolean linePressed = false;
    boolean rectanglePressed = false;
    boolean ovalPressed = false;
    boolean redPressed = false;
    boolean greenPressed = false;
    boolean bluePressed = false;
    boolean filled = false;
    boolean eraserPressed = false;
    boolean freeHandPressed = false;
    boolean undoPressed = false;
    boolean Dotted = false; 
    boolean dragged = false;
    boolean clearallpressed = false;
    
    BasicStroke stroke = new BasicStroke((float) 1);
   
    Graphics2D graphics2D;
    
    Color currentColor = Color.black;
    Color eraserColor = Color.white;
    
    int x1, y1, x2, y2; 

    public DrawPanel() {
       // setDoubleBuffered(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        
        //Line Button
        line = new Button("Line");
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "l";
                if (linePressed == false) {
                    linePressed = true;
                    line.setBackground(Color.ORANGE);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    freeHandPressed=false;
                    freeHandButton.setBackground(Color.LIGHT_GRAY);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                } else {
                    linePressed = false;
                    line.setBackground(Color.lightGray);
                }
            }
        });

        //Rectangle Button
        rectangle = new Button("Rectangle");
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "r";
                if (rectanglePressed == false) {
                    rectanglePressed = true;
                    rectangle.setBackground(Color.orange);
                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    freeHandPressed=false;
                    freeHandButton.setBackground(Color.LIGHT_GRAY);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                } else {
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                }
            }
        });

        //Oval Button
        oval = new Button("Oval");
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "o";
                if (ovalPressed == false) {
                    ovalPressed = true;
                    oval.setBackground(Color.orange);
                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    freeHandPressed=false;
                    freeHandButton.setBackground(Color.LIGHT_GRAY);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                } else {
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                }
            }
        });
        
        //Red color Button
        redButton = new Button("Red");
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
                if (redPressed == false) {
                    redPressed = true;
                    redButton.setBackground(Color.red);
                    greenPressed = false;
                    greenButton.setBackground(Color.lightGray);
                    bluePressed = false;
                    blueButton.setBackground(Color.lightGray);
                } else {
                    redPressed = false;
                    redButton.setBackground(Color.lightGray);
                }
            }
        });

        //Green color Button
        greenButton = new Button("Green");
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GREEN;
                if (greenPressed == false) {
                    greenPressed = true;
                    greenButton.setBackground(Color.green);
                    redPressed = false;
                    redButton.setBackground(Color.lightGray);
                    bluePressed = false;
                    blueButton.setBackground(Color.lightGray);
                } else {
                    greenPressed = false;
                    greenButton.setBackground(Color.lightGray);
                }
            }
        });

        //Blue color Button
        blueButton = new Button("Blue");
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
                if (bluePressed == false) {
                    bluePressed = true;
                    blueButton.setBackground(Color.blue);
                    redPressed = false;
                    redButton.setBackground(Color.lightGray);
                    greenPressed = false;
                    greenButton.setBackground(Color.lightGray);
                } else {
                    bluePressed = false;
                    blueButton.setBackground(Color.lightGray);
                }
            }
        });
        
        //Free Hand Button
        freeHandButton = new Button("Free Hand");
        freeHandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "f";
                if (freeHandPressed == false) {
                    freeHandPressed = true;
                    freeHandButton.setBackground(Color.pink);

                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                    clearallpressed = false;
                    clearAllButton.setBackground(Color.lightGray);
                } else {
                    freeHandPressed = false;
                    freeHandButton.setBackground(Color.lightGray);
                }
            }
        });
        
        //Undo Button
        undoButton = new Button("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "u";
                if (undoPressed == false) {
                    undoPressed = true;
                    undoButton.setBackground(Color.pink);

                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                    clearallpressed = false;
                    clearAllButton.setBackground(Color.lightGray);
                } else {
                    undoPressed = false;
                    undoButton.setBackground(Color.lightGray);
                }
                undo();
            }
        });

        //Eraser Button
        eraser = new Button("Eraser");
        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = "e";
                if (eraserPressed == false) {
                    eraserPressed = true;
                    eraser.setBackground(Color.pink);
                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    freeHandPressed = false;
                    freeHandButton.setBackground(Color.lightGray);
                    clearallpressed = false;
                    clearAllButton.setBackground(Color.lightGray);
                } else {
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                }
            }
        });
        
        //Clear All Button
        clearAllButton = new Button("Clear All");
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all drawings when the button is pressed
                currentShape = "c";
                if (clearallpressed == false) {
                    clearallpressed = true;
                    clearAllButton.setBackground(Color.pink);

                    // Reset other shape buttons
                    linePressed = false;
                    line.setBackground(Color.lightGray);
                    rectanglePressed = false;
                    rectangle.setBackground(Color.lightGray);
                    ovalPressed = false;
                    oval.setBackground(Color.lightGray);
                    eraserPressed = false;
                    eraser.setBackground(Color.lightGray);
                    undoPressed = false;
                    undoButton.setBackground(Color.lightGray);
                } else {
                    clearallpressed = false;
                    clearAllButton.setBackground(Color.lightGray);
                }
                lines.clear();
                rectangles.clear();
                ovals.clear();
                freeHands.clear();
                erasers.clear();
                repaint();
            }
        });

        //Dotted checkbox
        JCheckBox dotted = new JCheckBox("Dotted");
        dotted.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Dotted = (e.getStateChange() == ItemEvent.SELECTED);
            }
        });
        
        //Fill checkbox
        filledCheckbox = new JCheckBox("Filled");
        filledCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                filled = (e.getStateChange() == ItemEvent.SELECTED);
            }
        });

        
        //Add buttons to gui
        add(line);
        add(rectangle);
        add(oval);
        add(redButton);
        add(greenButton);
        add(blueButton);
        add(freeHandButton);
        add(eraser);
        add(clearAllButton);
        add(undoButton);
        add(dotted);
        add(filledCheckbox);
    }
    
    //Undo Function
    private void undo() {
        if (!lines.isEmpty() || !rectangles.isEmpty() || !ovals.isEmpty() || !freeHands.isEmpty() || !erasers.isEmpty()) {
            // Remove the last shape from the appropriate list
            if (!lines.isEmpty()) {
                lines.remove(lines.size() - 1);
            } else if (!rectangles.isEmpty()) {
                rectangles.remove(rectangles.size() - 1);
            } else if (!ovals.isEmpty()) {
                ovals.remove(ovals.size() - 1);
            } else if (!freeHands.isEmpty()) {
                freeHands.remove(freeHands.size() - 1);
            } else if (!erasers.isEmpty()) {
                erasers.remove(erasers.size() - 1);
            }

            repaint();
        }
    }
    
    //Paint Components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(currentColor);

        for (Line line : lines) {
            line.draw(g2d);
        }

        for (Rectangle rectangle : rectangles) {
            rectangle.draw(g2d);
        }

        for (Oval oval : ovals) {
            oval.draw(g2d);
        }
         for (FreeHand freeHand : freeHands) {
            freeHand.draw(g2d);
        }

        for (Eraser eraser : erasers) {
            eraser.draw(g2d);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        dragged = false;

        if (currentShape.equals("l")) {
            lines.add(new Line(x1, y1,currentColor, Dotted));
        } else if (currentShape.equals("r")) {
            rectangles.add(new Rectangle(x1, y1,currentColor,Dotted,filled));
        } else if (currentShape.equals("o")) {
            ovals.add(new Oval(x1, y1,currentColor, Dotted,filled));
        } else if (currentShape.equals("e")) {
            erasers.add(new Eraser(x1, y1));
        }else if (currentShape.equals("f")) {
                freeHands.add(new FreeHand(currentColor));
            }

        repaint();
       }
    
    //Press on gui to draw 
    @Override
    public void mouseDragged(MouseEvent e) {
        dragged = true;
        x2 = e.getX();
        y2 = e.getY();

        if (currentShape.equals("l")) {
            lines.get(lines.size() - 1).endPoint(x2, y2);
        } else if (currentShape.equals("r")) {
            rectangles.get(rectangles.size() - 1).updateEndPoint(x2, y2);
        } else if (currentShape.equals("o")) {
            ovals.get(ovals.size() - 1).updateEndPoint(x2, y2);
        } else if (currentShape.equals("e") && dragged) { 
            erasers.add(new Eraser(x2, y2));  
        }else if (currentShape.equals("f") && dragged) {
            freeHands.get(freeHands.size() - 1).addPoint(x2, y2);
        }

        repaint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        /*
        if (!dragged) {
            x2 = e.getX();
            y2 = e.getY();

            if (currentShape.equals("l")) {
                lines.get(lines.size() - 1).endPoint(x2, y2);
            } else if (currentShape.equals("r")) {
                rectangles.get(rectangles.size() - 1).updateEndPoint(x2, y2);
            } else if (currentShape.equals("o")) {
                ovals.get(ovals.size() - 1).updateEndPoint(x2, y2);
            }
        }

        repaint();
*/
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

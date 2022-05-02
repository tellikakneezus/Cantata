import java.awt.*;
import java.awt.event.*;

public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showChoiceDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showChoiceDemo(){                                       

      headerLabel.setText("Control in action: Choice"); 
      final Choice fruitChoice = new Choice();

      fruitChoice.add("Apple");
      fruitChoice.add("Grapes");
      fruitChoice.add("Mango");
      fruitChoice.add("Peer");

      Button showButton = new Button("Show");

      showButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {     
            String data = "Fruit Selected: " 
            + fruitChoice.getItem(fruitChoice.getSelectedIndex());
            statusLabel.setText(data);
         }
      }); 

      controlPanel.add(fruitChoice);
      controlPanel.add(showButton);

      mainFrame.setVisible(true);  
   }
}
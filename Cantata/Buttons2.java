
import java.awt.*;
import java.awt.event.*;


public class Buttons2 extends Frame implements ItemListener
{
	Choice colors = new Choice();

	public Buttons2()
	{
		//set the layout
		setLayout(new BorderLayout(20,5));

		  


		
		add(colors, BorderLayout.CENTER);
			colors.add("Colors");
			colors.add("Red");
			colors.add("Yellow");
			colors.add("Cyan");
			colors.add("Magenta");
			colors.add("White");

			colors.addItemListener(this);

		//override the windowClosing event
		addWindowListener(
			new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
					{
					   System.exit(0);
					}
				}
		);

	}//end Buttons2

   	public static void main(String[] args)
   	{
	   	// set frame properties
		Buttons2 f = new Buttons2();
		f.setBackground(Color.red);
		  f.setTitle("Border Application");
		  f.setBounds(200,200,300,300);
		f.setVisible(true);
	}//end main

   

	public void itemStateChanged(ItemEvent ie)
   {
	   String arg = colors.getSelectedItem();

	   if (arg== "Red")
	   		setBackground(Color.red);
	   if (arg== "Yellow")
	   		setBackground(Color.yellow);
	   if (arg== "Cyan")
	   		setBackground(Color.cyan);
	   if (arg== "Magenta")
	   		setBackground(Color.magenta);
	   if (arg== "White")
	   		setBackground(Color.white);

   }//end itemStateChanged

}//end public class
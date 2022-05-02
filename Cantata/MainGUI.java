import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainGUI extends Frame implements ActionListener, ItemListener
{
    //Standard GUI objects
    private Button submitButton;
    private MenuBar menuBar;
    private Choice itemChoice;

    //Find Page
    private TextField queryInput;
    private TextArea display;

    private Choice queryChoice;

    //Add Cable/ SFP
    private TextField serialInput;
    private TextField lengthInput;
    private TextField floorLocationOneInput;
    private TextField floorLocationTwoInput;
    private TextField deviceOneInput;
    private TextField deviceTwoInput;

    public static void main(String[] args){
        new MainGUI();
    }

    /**
     * Constructor for objects of class Main
     */
    public MainGUI()
    {
        setTitle("Cantata");
        setSize(500,500);
        createMenu();
        setMenuBar(menuBar);
        addComponents();
        //add(menuBar);
        closeOnExit();
        setLayout(new FlowLayout());
        setResizable(false);
        setVisible(true);
    }

    private void closeOnExit(){
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    dispose();
                }
            }
        );   
    }

    
    private void createMenu(){

        //init menu bar
        menuBar = new MenuBar();

        //create action listener for menu
        MenuItemListener menuItemListener = new MenuItemListener();
        
        //init file menu
        Menu fileMenu = new Menu("File");
        
        //add items to file menu
        MenuItem addItem = new MenuItem("Add");
        addItem.addActionListener(menuItemListener);

        MenuItem findItem = new MenuItem("Find");
        findItem.addActionListener(menuItemListener);

        MenuItem exitProgram = new MenuItem("Exit");
        exitProgram.addActionListener(menuItemListener);

        fileMenu.add(addItem);
        fileMenu.add(findItem);
        fileMenu.add(exitProgram);

        //add file menu to bar
        menuBar.add(fileMenu);

    }
    private void addComponents(){
        //Standard GUI objects
        submitButton = new Button("Submit");
        submitButton.setSize(100,20);
        submitButton.setLocation(200,420);
        submitButton.setVisible(false);
        add(submitButton);

        createItemChoice();
        itemChoice.setSize(100,20);
        itemChoice.setLocation(50,100);
        itemChoice.setVisible(false);
        add(itemChoice);

        //Find Page
        createQueryChoice();
        queryChoice.setSize(100,20);
        queryChoice.setLocation(50,175);
        queryChoice.setVisible(false);
        add(queryChoice);

        queryInput = new TextField();
        queryInput.setSize(120,20);
        queryInput.setLocation(50,325);
        queryInput.setVisible(false);
        add(queryInput);

        display = new TextArea();
        display.setSize(250,300);
        display.setLocation(225,75);
        display.setText("Here I am!!!!!!!!!!");
        display.setVisible(false);
        add(display);

        //Add Cable/ SFP
        serialInput = new TextField();
        serialInput.setSize(120,20);
        lengthInput = new TextField();
        floorLocationOneInput = new TextField();
        floorLocationTwoInput = new TextField();
        deviceOneInput = new TextField();
        deviceTwoInput = new TextField();
    }

    private void createItemChoice(){
        itemChoice = new Choice();
        itemChoice.add("SFP");
        itemChoice.add("Cable");
        itemChoice.addItemListener(this);
    }

    private void createQueryChoice(){
        queryChoice = new Choice();
        queryChoice.add("SerialNumber");
        queryChoice.add("Equipment");
        queryChoice.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent ie){
        String itemChoiceState = itemChoice.getSelectedItem();
        String queryChoiceState = queryChoice.getSelectedItem();

        switch(itemChoiceState){

        }

        switch(queryChoiceState){

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        
    }
    
    class MenuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            switch(ae.getActionCommand()){
                case "Find":
                //Enable Add option components
                itemChoice.setEnabled(true);
                queryChoice.setEnabled(true);
                queryInput.setEnabled(true);
                submitButton.setEnabled(true);
                display.setEnabled(true);

                itemChoice.setVisible(true);
                queryChoice.setVisible(true);
                queryInput.setVisible(true);
                submitButton.setVisible(true);
                display.setVisible(true);

                //Disable Find option components
                serialInput.setEnabled(false);
                lengthInput.setEnabled(false);
                floorLocationOneInput.setEnabled(false);
                floorLocationTwoInput.setEnabled(false);
                deviceOneInput.setEnabled(false);
                deviceTwoInput.setEnabled(false);

                serialInput.setVisible(false);
                lengthInput.setVisible(false);
                floorLocationOneInput.setVisible(false);
                floorLocationTwoInput.setVisible(false);
                deviceOneInput.setVisible(false);
                deviceTwoInput.setVisible(false);
                break;
                
                
                case "Add":
                //Enable File option components
                itemChoice.setEnabled(true);
                serialInput.setEnabled(true);
                lengthInput.setEnabled(true);
                floorLocationOneInput.setEnabled(true);
                floorLocationTwoInput.setEnabled(true);
                deviceOneInput.setEnabled(true);
                deviceTwoInput.setEnabled(true);

                
                itemChoice.setVisible(true);
                serialInput.setVisible(true);
                lengthInput.setVisible(true);
                floorLocationOneInput.setVisible(true);
                floorLocationTwoInput.setVisible(true);
                deviceOneInput.setVisible(true);
                deviceTwoInput.setVisible(true);

                //Disable and remove Add option Components
                queryInput.setEnabled(false);                
                queryChoice.setEnabled(false);

                display.setVisible(false);
                queryInput.setVisible(false);
                queryChoice.setVisible(false);
                break;
                
                case "Exit":
                dispose();
                break;
            }
        }
    }
}


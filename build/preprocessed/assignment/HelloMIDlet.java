/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Fomotio Egoko Elvine Lea, Glenn Faison and Eddy Franck
 */
public class HelloMIDlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;

/*Defining variuos widget that will be used in the application*/

    private StringItem stringItem;
    private TextField textField;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private TextField textField7;
    private Command exitCommand;
    private Command backCommand;
    private Command okCommand;
    private Command okCommand1;
    private Form form1;
    private Form form;
    private Spacer spacer;
    private Spacer spacer1;

    private String output = "The is is high probability you are pregnant";
    
    public String getOutput(){
        return output ;
    }
    
    public void setOutput(String outputResult){
        this.textField7.setString(outputResult);
    }
    
    
     /**
     * The HelloMIDlet constructor.
     */  



    public HelloMIDlet() {
    }
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {
}
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {

      switchDisplayable(null, getForm());
    }
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {}
    /**
     * Switches a current displayable in a display. The <code>display</code>
     * instance is taken from <code>getDisplay</code> method. This method is
     * used by all actions in the design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display; if
     * <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alertMessage, Displayable nextDisplayable) {
        Display display = getDisplay();
        if (alertMessage == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alertMessage, nextDisplayable);
        }
}
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {

// pre-action user code here
if (displayable == form) {
            if (command == exitCommand) {
                exitMIDlet();

// post-action user code here
} else if (command == okCommand1) {

 //pre-action user code here
    if(this.textField.getString().length() <= 0 || this.textField1.getString().length() <= 0 || this.textField2.getString().length() <= 0 ||
            this.textField3.getString().length() <= 0 || this.textField4.getString().length() <= 0 || this.textField5.getString().length() <= 0){
        setOutput("Kindly fill all the required fields");
        switchDisplayable(null, getForm1());
    } else {
        int val = Integer.parseInt(this.textField4.getString()) - Integer.parseInt(this.textField2.getString());
        if(val < 0){
            setOutput("Please enter the correct months.");
            switchDisplayable(null, getForm1());
        } else if(val > 1){
            setOutput(this.textField.getString() + " High probability you are pregnant");
            switchDisplayable(null, getForm1());
        } else{
            int day1 = Integer.parseInt(this.textField3.getString());
            int day2 = Integer.parseInt(this.textField5.getString());
            int days = 0;
            
            if(Integer.parseInt(this.textField2.getString()) == 2){
                days = 28 - day1;
                days += day2;
                if(days > 30){
                    setOutput(this.textField.getString() + " High probability you are pregnant");
                    switchDisplayable(null, getForm1());
                } else {
                    setOutput(this.textField.getString() + " You are not pregnant");
                }
            } else {
                days = 30 - day1;
                days += day2;
                if(days > 30){
                    setOutput(this.textField.getString() + " High probability you are pregnant");
                    switchDisplayable(null, getForm1());
                } else {
                    setOutput(this.textField.getString() + " You are not pregnant.");
                }
            }
        }
    }
    }

} else if (displayable == form1) {
    if (command == backCommand) {

switchDisplayable(null, getForm());

} else if (command == okCommand) {
 
}
        }
       
}

    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {

exitCommand = new Command("Exit", Command.EXIT, 0);
          
}
        return exitCommand;
    }

    /**
     * Returns an initialized instance of form component.
     *
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {
            form = new Form("Welcome", new Item[]{getStringItem(), getTextField(), getTextField1(), getSpacer(), getTextField2(), getTextField3(), getSpacer1(), getTextField4(), getTextField5(), getTextField7()});                                    
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand1());
            form.setCommandListener(this);
            
}
        return form;
    }

    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {
           backCommand = new Command("Back", Command.BACK, 0);
}
        return backCommand;
    }

    /**
     * Returns an initialized instance of okCommand component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {
            okCommand = new Command("Ok", Command.OK, 0);
}
        return okCommand;
    }

    /**
     * Returns an initialized instance of okCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {
           okCommand1 = new Command("View Results", Command.OK, 0);
 
}
        return okCommand1;
    }

    /**
     * Returns an initialized instance of form1 component.
     *
     * @return the initialized component instance
     */
    public Form getForm1() {
        if (form1 == null) {
            form1 = new Form("Results", new Item[]{getTextField6()});
            form1.addCommand(getBackCommand());
            form1.addCommand(getOkCommand());
            form1.setCommandListener(this);
}
        return form1;
    }

    /**
     * Returns an initialized instance of stringItem component.
     *
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {
           stringItem = new StringItem("Pregnancy Calculator", "Appropriately fill the form:");
 
}
        return stringItem;
    }

    /**
     * Returns an initialized instance of textField component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {
          textField = new TextField("Name", null, 32, TextField.ANY);
}
        return textField;
    }

    /**
     * Returns an initialized instance of textField1 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {
        textField1 = new TextField("Age", null, 32, TextField.ANY);
}
        return textField1;
    }

    /**
     * Returns an initialized instance of spacer component.
     *
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {
           spacer = new Spacer(16, 1);
}
        return spacer;
    }

    /**
     * Returns an initialized instance of textField2 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {
          textField2 = new TextField("Last Period Month", null, 32, TextField.ANY);
 }
        return textField2;
    }

    /**
     * Returns an initialized instance of textField3 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {
        textField3 = new TextField("Last Period day", null, 32, TextField.ANY);
}
        return textField3;
    }
    /**
     * Returns an initialized instance of spacer1 component.
     *
     * @return the initialized component instance
     */
    public Spacer getSpacer1() {
        if (spacer1 == null) {
        spacer1 = new Spacer(16, 1);
 
}
        return spacer1;
    }

    /**
     * Returns an initialized instance of textField4 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {

         textField4 = new TextField("Current Month", null, 32, TextField.ANY);
}
        return textField4;
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">
    /**
     * Returns an initialized instance of textField5 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {
         textField5 = new TextField("Current Day", null, 32, TextField.ANY);

}
        return textField5;
    }


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField6 ">
    /**
     * Returns an initialized instance of textField6 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField6() {
        if (textField6 == null) {
          textField6 = new TextField("Results", null, 32, TextField.ANY);
 }
        return textField6;
    }

    /**
     * Returns an initialized instance of textField7 component.
     *
     * @return the initialized component instance
     */
    public TextField getTextField7() {
        if (textField7 == null) {
         textField7 = new TextField("Results", null, 32, TextField.ANY);
 }
        return textField7;
    }


    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
    
}

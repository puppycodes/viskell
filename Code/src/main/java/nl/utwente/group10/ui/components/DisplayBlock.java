package nl.utwente.group10.ui.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import nl.utwente.ewi.caes.tactilefx.fxml.TactileBuilderFactory;

import java.io.IOException;

/**
 * DisplayBlock is an extension of Block that only provides a display of the input
 * it receives through it's inputAnchor.
 * The input will be rendered visually on the Block.
 * DisplayBlock can be empty and contain no value at all, the value can be altered at any time
 * by providing a different input source using a Connection.
 */
public class DisplayBlock extends Block {

    /** The output this Block is displaying.**/
    private StringProperty output;
    
    /**
     * Creates a new instance of DisplayBlock.
     * @return new DisplayBlock instance
     * @throws IOException
     */
    public DisplayBlock() throws IOException {
        super("DisplayBlock", null);

        output = new SimpleStringProperty("New Output");
        
        this.getLoader().load();
    }

    /**
     * Sets the output flowing into the DisplayBlock and refresh the display.
     * @param output
     */
    public void setOutput(String inputValue) {
        output.set(inputValue);
    }

    /**
     * Returns the output value this Block has.
     * @return outputValue
     */
    public String getOutput() {
        return output.get();
    }
    
    /**
     * Property getter for the output property.
     * @return outputProperty
     */
    public StringProperty outputProperty() {
    	return output;
    }
}
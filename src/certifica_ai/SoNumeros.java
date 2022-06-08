
package certifica_ai;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoNumeros extends PlainDocument{

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(i, string.replaceAll("[^0-9]", ""), as); //To change body of generated methods, choose Tools | Templates.
    }
    
}

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassGenerator {
    private JLabel ClassName;
    private JTextField ClassNameField;
    private JCheckBox MainFunction;
    private JPanel MainPanel;

    private GeneratedClass generatedClass;

    public ClassGenerator (GeneratedClass generatedClass) {
        this.generatedClass = generatedClass;
        MainFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatedClass.setHasMain(MainFunction.isSelected());
            }
        });
        ClassNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                generatedClass.setName(ClassNameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                generatedClass.setName(ClassNameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                generatedClass.setName(ClassNameField.getText());
            }
        });
    }
    public JComponent getContent() {
        return MainPanel;
    }


}

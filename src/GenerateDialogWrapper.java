import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;

import javax.annotation.Nullable;
import javax.swing.*;

public class GenerateDialogWrapper extends DialogWrapper {
    private ClassGenerator classGenerator;

    public GenerateDialogWrapper(@Nullable Project project) {
        super(project);
        classGenerator = new ClassGenerator(GeneratedClass.INSTANCE);
        init();
        setTitle("Class generator");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel () {
        return classGenerator.getContent();
    }
}

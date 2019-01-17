import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.psi.*;

public class GenerateClassAction extends AnAction {
    private PsiDirectory selectedDir;

    @Override
    public void update (AnActionEvent e) {
        PsiElement selectedElement = CommonDataKeys.PSI_ELEMENT.getData(e.getDataContext());
        if (selectedElement instanceof PsiDirectory)
            selectedDir = (PsiDirectory) selectedElement;
        else if (selectedElement instanceof PsiClass) {
            PsiFile psiFile = selectedElement.getContainingFile();
            selectedDir = psiFile.getContainingDirectory();
        }
        else
            e.getPresentation().setEnabledAndVisible(false);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        GenerateDialogWrapper dialogWrapper = new GenerateDialogWrapper(anActionEvent.getProject());
        dialogWrapper.show();
        String temp = null;
        if (dialogWrapper.isOK()) {

            if (GeneratedClass.INSTANCE.isHasMain())
                temp = "Class With Main.java";
            else
                temp = "Class.java";
        }
        JavaDirectoryService.getInstance().createClass(selectedDir, GeneratedClass.INSTANCE.getName(), temp, true);
    }
}

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.popup.PopupComponent;

import java.awt.*;

/**
 * Created by Chan_Woo_Kim on 2016-12-21.
 */
public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Project project = e.getProject();

        Messages.showMessageDialog(project, "Hello todd", "Greet", Messages.getInformationIcon());
    }
}

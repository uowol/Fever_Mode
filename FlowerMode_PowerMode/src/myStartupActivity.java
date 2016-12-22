import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Chan_Woo_Kim on 2016-12-21.
 */
public class myStartupActivity implements StartupActivity {
    @Override
    public void runActivity(@NotNull Project project) {
        System.out.println("꺄르르ㅡ긁");
    }
}

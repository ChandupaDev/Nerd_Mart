package Model;

import com.formdev.flatlaf.IntelliJTheme;

/**
 *  
 * @author TUF_Heat_
 */
public class Tcthemes {

    public static void setup(String theme) {
        if (theme.equals(Tcthemes.githubLight)) {
            IntelliJTheme.setup(Tcthemes.class.getResourceAsStream(Tcthemes.githubLight));
        } else if (theme.equals(Tcthemes.githubDark)) {
            IntelliJTheme.setup(Tcthemes.class.getResourceAsStream(Tcthemes.githubDark));
        }
    }

    public static final String githubLight = "/themes/GitHub.theme.json";
    public static final String githubDark = "/themes/GitHubDark.theme.json";
}

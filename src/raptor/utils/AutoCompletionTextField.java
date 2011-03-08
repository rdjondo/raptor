package raptor.utils;

import java.util.Set;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;

/**
 * This class is used to provide an example of showing completion feature in a
 * text field.
 * 
 * @author Debadatta Mishra(PIKU)
 * 
 */
public class AutoCompletionTextField {
  /**
   * A String for key press
   */
  private final static String KEY_PRESS = "Ctrl+Space";

  /**
   * This method is used to provide the implementaion of eclipse autocompletion
   * feature. User has to press "CTRL+Space" to see the autocompletion effect.
   * 
   * @param text
   *          of type {@link Text}
   * @param prefix
   *          of type String
   * @author Debadatta Mishra (PIKU)
   */
  private static void setAutoCompletion(Text text, String prefix,
      Set<String> proposals) {
    if (prefix.equals(null)) {
      prefix = "";
    }
    try {
      String[] defaultProposals = new String[proposals.size()];
      proposals.toArray(defaultProposals);
      SimpleContentProposalProvider scp = new SimpleContentProposalProvider(
          defaultProposals);
      scp.setProposals(defaultProposals);
      KeyStroke ks = KeyStroke.getInstance(KEY_PRESS);
      ContentProposalAdapter adapter = new ContentProposalAdapter(text,
          new TextContentAdapter(), scp, ks, null);
      adapter
          .setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method used to create a text field.
   */
  public static void addAutoCompleter(final Text text) {
    // Method for autocompletion
    final GetCIndexJob indexJob = new GetCIndexJob();
    indexJob.setPriority(Job.SHORT);
    indexJob.schedule();
    setAutoCompletion(text, "", indexJob.getBindingSet());

    text.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent ke) {
        // Method for autocompletion
        setAutoCompletion(text, text.getText(), indexJob.getBindingSet());
      }
    });
  }
}

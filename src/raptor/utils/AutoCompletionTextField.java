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

  private Text text;
  
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
  private void setAutoCompletion(String prefix,
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
  public void addAutoCompleter(Text txt) {
    // Method for autocompletion
	text = txt;
    GetCIndexJob indexJob = new GetCIndexJob();
    indexJob.setPrefix(text.getText());
    indexJob.setPriority(Job.SHORT);
    indexJob.schedule();
    setAutoCompletion("", indexJob.getBindingSet());
    KeyAdapterText kt = new KeyAdapterText(txt,indexJob);
    txt.addKeyListener(kt);
  }
  
  private class KeyAdapterText extends KeyAdapter{
	  Text text;
	  GetCIndexJob indexJob ;
	  public KeyAdapterText(Text txt, GetCIndexJob job){
		  text = txt;
			indexJob = job;
		}

		public void keyReleased(KeyEvent ke) {
			// Method for autocompletion
			indexJob.setPrefix(text.getText());
			indexJob.setPriority(Job.SHORT);
			indexJob.schedule();
			setAutoCompletion(text.getText(), indexJob.getBindingSet());
		}

  }
}

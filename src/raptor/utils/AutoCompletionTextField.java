package raptor.utils;

import java.util.Set;
import java.util.Vector;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;

public class AutoCompletionTextField {

	private Text text;
	char[] autoActivationChars;

	GetCIndexJob indexJob;

	public AutoCompletionTextField() {
		// Sets all characters between 0 and z as activation characters
	  int index = 0;
	  Vector<Character> characVect = new Vector<Character>();
	  characVect.add('0');
	  while(characVect.get(index).charValue() < 'z' ){
		  characVect.add(new Character((char)(characVect.get(index).charValue()+1)));
		  index++;
	  }
	  autoActivationChars = new char[characVect.size()];
	  for(int i=0; i<characVect.size(); i++){
		  autoActivationChars[i]=characVect.get(i).charValue();
	  }
  }
  
  /**
   * 
   * @param text
   *          of type {@link Text}
   * @param prefix
   *          of type String
   */
  private void setAutoCompletion(String prefix,
      Set<String> proposals) {
    if (prefix.equals(null)) {
      prefix = "";
    }
    if(proposals.size()==0){
    	return;
    }
    try {
      String[] prop = new String[proposals.size()];
      proposals.toArray(prop);
      System.out.println("********************");
      for (int i = 0; i < prop.length; i++) {
		System.out.println(prop[i]);
	}
	SimpleContentProposalProvider scp = new SimpleContentProposalProvider(
          prop);
      scp.setProposals(prop);
      ContentProposalAdapter adapter = new ContentProposalAdapter(text,
          new TextContentAdapter(), scp, null, autoActivationChars);
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
    indexJob = new GetCIndexJob();
    IndexJobChangeAdapter listener = new IndexJobChangeAdapter(indexJob);
    indexJob.addJobChangeListener(listener);
    indexJob.setPrefix(text.getText());
    indexJob.setPriority(Job.SHORT);
    indexJob.schedule();
    
    KeyAdapterText kt = new KeyAdapterText(txt,indexJob);
    txt.addKeyListener(kt);
  }

	private class IndexJobChangeAdapter extends JobChangeAdapter {

		
		public IndexJobChangeAdapter(GetCIndexJob job){
			indexJob = job;
		}
		public void done(IJobChangeEvent event) {
			if (event.getResult().isOK())
				setAutoCompletion("", indexJob.getBindingSet());
			else
				System.out.println("Job did not complete successfully");
		}
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
		    IndexJobChangeAdapter listener = new IndexJobChangeAdapter(indexJob);
		    indexJob.addJobChangeListener(listener);
			indexJob.setPrefix(text.getText());
			System.out.println("text.getText()"+text.getText());
			indexJob.setPriority(Job.SHORT);
			indexJob.schedule();
			//setAutoCompletion(text.getText(), indexJob.getBindingSet());
		}

  }
}

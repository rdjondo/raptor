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

	private final Text text;
	private char[] autoActivationChars = {'\0'};
	private GetCIndexJob indexJob;
	private SimpleContentProposalProvider scp;
	private ContentProposalAdapter adapter;

	public AutoCompletionTextField(Text txt) {
		// Sets all characters between 0 and z as activation characters
		int index = 0;
		text = txt;

		KeyAdapterText kt = new KeyAdapterText();
		text.addKeyListener(kt);
		
		final String[] autoActivationStringDefault = { "" };
		scp = new SimpleContentProposalProvider(
				autoActivationStringDefault);
		Vector<Character> characVect = new Vector<Character>();
		characVect.add('0');
		while (characVect.get(index).charValue() < 'z') {
			characVect.add(new Character((char)(characVect.get(index).charValue()+1)));
			index++;
		}
		autoActivationChars = new char[characVect.size()];
		for (int i = 0; i < characVect.size(); i++) {
			autoActivationChars[i] = characVect.get(i).charValue();
		}

		adapter = new ContentProposalAdapter(text,
				new TextContentAdapter(), scp, null, autoActivationChars);
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		indexJob = new GetCIndexJob();
		IndexJobChangeAdapter listener = new IndexJobChangeAdapter();
		indexJob.addJobChangeListener(listener);
		indexJob.setPrefix(text.getText());
		indexJob.setPriority(Job.SHORT);
		indexJob.schedule();

	}

	/**
	 * 
	 * @param text
	 *            of type {@link Text}
	 * @param prefix
	 *            of type String
	 */
	private void setAutoCompletion(Set<String> proposals) {
		System.out.println("************setAutoCompletion********");
		if (proposals.size() == 0) {
			System.out.println("proposals.size()==0");
			return;
		}
		try {
			String[] propStrArray = new String[proposals.size()];
			proposals.toArray(propStrArray);
			for (int i = 0; i < propStrArray.length; i++) {
				System.out.print("prop :"  + propStrArray[i] + " ");
			}
			scp.setProposals(propStrArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class IndexJobChangeAdapter extends JobChangeAdapter {

		public IndexJobChangeAdapter() {
		}

		@Override
		public void done(IJobChangeEvent event) {
			if (event.getResult().isOK()) {
				System.out.println("Job completed successfully");

				setAutoCompletion(indexJob.getBindingSet());
			} else {
				System.out.println("Job did not complete successfully");
			}
		}
	}

	private class KeyAdapterText extends KeyAdapter {

		public KeyAdapterText() {
		}

		public void keyReleased(KeyEvent ke) {
			// Method for autocompletion
			System.out.println("text.getText()" + text.getText() + " " + text.getText().length());
			indexJob = new GetCIndexJob();
			indexJob.addJobChangeListener(new IndexJobChangeAdapter());
			indexJob.setPrefix(text.getText());
			indexJob.setPriority(Job.SHORT);
			indexJob.schedule();

		}

	}
}

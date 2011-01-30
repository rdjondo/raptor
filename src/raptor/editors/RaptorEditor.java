package raptor.editors;


import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.*;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import forms.FormView;

import raptor.Activator;

public class RaptorEditor extends FormEditor implements IResourceChangeListener{
  
  public RaptorEditor() {
  }
  
  
  /*
   *  (non-Javadoc)
   * @see org.eclipse.ui.forms.editor.FormEditor#createToolkit(org.eclipse.swt.widgets.Display)
   */
  protected FormToolkit createToolkit(Display display) {
    // Create a toolkit that shares colors between editors.
    return new FormToolkit(Activator.getDefault().getFormColors(
        display));
  }
  
  @Override
  public void resourceChanged(IResourceChangeEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void addPages() {
    // TODO Auto-generated method stub
    try {
      int indexFormView = addPage(new FormView(this));
      
      
    } catch (PartInitException e) {
      // TODO: handle exception
    }
  }

  @Override
  public void doSave(IProgressMonitor arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void doSaveAs() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean isSaveAsAllowed() {
    // TODO Auto-generated method stub
    return false;
  }

  
}

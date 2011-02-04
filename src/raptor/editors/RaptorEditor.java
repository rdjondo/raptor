package raptor.editors;


import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.*;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;

import forms.DependenciesFormView;
import forms.OverviewFormView;

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
    // TODO What does this code here ? Auto-generated method stub
    
  }

  @Override
  protected void addPages() {
    // TODO add the rest of the forms
    try {
      int indexOverviewFormView = addPage(new OverviewFormView(this));
      int DependenciesFormView = addPage(new DependenciesFormView(this));  
    } catch (PartInitException e) {
      // TODO: handle exception
    }
  }

  @Override
  public void doSave(IProgressMonitor arg0) {
    // TODO make a save function
    
  }

  @Override
  public void doSaveAs() {
    // TODO make a save as function
    
  }

  @Override
  public boolean isSaveAsAllowed() {
    // TODO Allow to save
    return false;
  }

  
}

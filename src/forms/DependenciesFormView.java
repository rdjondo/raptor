package forms;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class DependenciesFormView extends FormPage {

  private FormToolkit toolkit;
  private ScrolledForm form;
  static final public String TITLE = "Dependencies";
  /**
   * The constructor.
   */
  public DependenciesFormView(FormEditor editor) {
    super(editor, "second", TITLE);
  }
  

  protected void createFormContent(IManagedForm managedForm) {
    
  }

  /**
   * Passing the focus request to the form.
   */
  public void setFocus() {
   form.setFocus();
  }

  /**
   * Disposes the toolkit
   */
  public void dispose() {
   toolkit.dispose();
   super.dispose();
  }
  
}

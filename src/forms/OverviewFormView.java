package forms;

import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import raptor.utils.AutoCompletionTextField;


public class OverviewFormView extends FormPage {

  private FormToolkit toolkit;
  private ScrolledForm form;
  static final public String TITLE = "Raptor - Unit Test Editor";
  static final public String TITLE_TAB = "Overview";
  /**
   * The constructor.
   */
  public OverviewFormView(FormEditor editor) {
    super(editor, "second", TITLE_TAB);
  }

  protected void createFormContent(IManagedForm managedForm) {
    ScrolledForm form = managedForm.getForm();
    FormToolkit toolkit = managedForm.getToolkit();
    TableWrapLayout  layout = new TableWrapLayout();
    form.setText(TITLE);
    Composite parent = form.getBody();
    parent.setLayout(layout);
    layout.numColumns = 2;
    
    /*Label function Function’s name (unit to test)*/
    TableWrapData td = new TableWrapData(TableWrapData.FILL);
    Label unitLabel = toolkit.createLabel(parent, "Function: ");
    unitLabel.setLayoutData(td);

    td = new TableWrapData(TableWrapData.FILL);
    Text unitname = toolkit.createText(parent, "Enter function to test");
    unitname.setLayoutData(td);
    AutoCompletionTextField autocomp = new AutoCompletionTextField(unitname);
    
    td = new TableWrapData(TableWrapData.FILL);
    Label pathLabel = toolkit.createLabel(parent, "Path: ");
    pathLabel.setLayoutData(td);
    
    td = new TableWrapData(TableWrapData.FILL);
    Text utrootpath = toolkit.createText(parent, "Enter root path of the unit test project (Double click)");
    utrootpath.setLayoutData(td);
    utrootpath.addMouseListener(new PathFieldContributor(utrootpath,parent.getShell()));
    
    td = new TableWrapData(TableWrapData.FILL);
    Label authorLabel = toolkit.createLabel(parent, "Author: ");
    authorLabel.setLayoutData(td);
    
    td = new TableWrapData(TableWrapData.FILL);
    Text author = toolkit.createText(parent, "Enter author the unit test");
    author.setLayoutData(td);
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
   if(!toolkit.equals(null)) toolkit.dispose();
   super.dispose();
  }

}

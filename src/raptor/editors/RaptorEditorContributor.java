package raptor.editors;

import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;

public class RaptorEditorContributor extends
    MultiPageEditorActionBarContributor {

  private IEditorPart activeEditorPart;
  private Action sampleAction;
  /**
   * Creates a multi-page contributor.
   */
  public RaptorEditorContributor() {
    super();
    createActions();
  }
  /**
   * Returns the action registed with the given text editor.
   * @return IAction or null if editor is null.
   */
  protected IAction getAction(ITextEditor editor, String actionID) {
    return (editor == null ? null : editor.getAction(actionID));
  }
  
  /* (non-JavaDoc)
   * Method declared in AbstractMultiPageEditorActionBarContributor.
   */
  public void setActivePage(IEditorPart part) {
    if (activeEditorPart == part)
      return;

    activeEditorPart = part;

    IActionBars actionBars = getActionBars();
    if (actionBars != null) {
    }
  }
  private void createActions() {
    sampleAction = new Action() {
      public void run() {
        MessageDialog.openInformation(null, "Raptor", "Sample Action Executed");
      }
    };
    sampleAction.setText("Sample Action");
    sampleAction.setToolTipText("Sample Action tool tip");
    sampleAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
        getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
  }
  public void contributeToMenu(IMenuManager manager) {
    IMenuManager menu = new MenuManager("Editor &Menu");
    manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
    menu.add(sampleAction);
  }
  public void contributeToToolBar(IToolBarManager manager) {
    manager.add(new Separator());
    manager.add(sampleAction);
  }
}

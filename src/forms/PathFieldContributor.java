package forms;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This class supports the path field events
 */
class PathFieldContributor implements MouseListener{
  /**
   * Field text
   */
  private Text text;
  private Shell shell;
  
  //Forbid usage of default constructor
  @SuppressWarnings("unused")
  private PathFieldContributor(){};
  public PathFieldContributor(Text text,Shell shell){
    this.text = text;
    this.shell = shell;
  }
  
  public void openDialog() {
    DirectoryDialog dlg = new DirectoryDialog(shell);
    
    // Set the initial filter path according
    // to anything they've selected or typed in
    dlg.setFilterPath(text.getText());

    // Change the title bar text
    dlg.setText("Select path");

    // Customizable message displayed in the dialog
    dlg.setMessage("Select a directory");

    // Calling open() will open and run the dialog.
    // It will return the selected directory, or
    // null if user cancels
    String dir = dlg.open();
    if (dir != null) {
      // Set the text box to the new selection
      text.setText(dir);
    }
  }
  @Override
  public void mouseDoubleClick(MouseEvent arg0) {
    openDialog();
  }
  @Override
  public void mouseDown(MouseEvent arg0) {
    //nothing
  }
  @Override
  public void mouseUp(MouseEvent arg0) {
  //nothing
    
  }
}
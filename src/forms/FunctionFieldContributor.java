package forms;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



public class FunctionFieldContributor implements MouseListener {
  
  private TextFunction textfunction;
  
  @SuppressWarnings("unused")
  private FunctionFieldContributor(){};
  
  public FunctionFieldContributor(TextFunction textfunction){
    this.textfunction = textfunction;
  };
  
  @Override
  public void mouseDoubleClick(MouseEvent e) {
    // TODO Auto-generated method stub
    
    String replacementString = "test";
    int replacementOffset = 0;
    int replacementLength = 1;
    Image image = null;
    String displayString = "test";
    int relevance = 1000;
    
  }

  @Override
  public void mouseDown(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseUp(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

}

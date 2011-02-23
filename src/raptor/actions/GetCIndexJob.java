package raptor.actions;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.*;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.index.IIndexBinding;
import org.eclipse.cdt.core.index.IIndexFile;
import org.eclipse.cdt.core.index.IndexFilter;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class GetCIndexJob extends Job {
  private String prefix;
  private IndexFilter filter;

  public GetCIndexJob(String pre) {
    super("GetCIndexJob");
    prefix = pre;
    filter = new IndexFilter() {
      @Override
      public boolean acceptBinding(IBinding binding) throws CoreException {
        if( binding instanceof IFunction){
          System.out.println( " ** "+binding.getName() + " ** "  +  " ** " );
          return true;
        } else{
          return false;
        }
      }
    };
  }

  @Override
  protected IStatus run(IProgressMonitor monitor) {
    try {
      IIndex index = CCorePlugin.getIndexManager().getIndex(
          CoreModel.getDefault().getCModel().getCProjects());
      try {
        index.acquireReadLock();
        char[] prefixChar = new char[prefix.length()];
        prefix.getChars(0, prefix.length(), prefixChar, 0);
        IIndexBinding[] bindings = index.findBindingsForPrefix(prefixChar,
            false, filter, monitor);
        System.out.println("Get getQualifiedName");
        for (IIndexBinding binding : bindings) {
          System.out.println(binding.toString());
        }
        System.out.println("Get getAllFiles");
        for(IIndexFile file: index.getAllFiles()){
          System.out.println(file.toString());
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        index.releaseReadLock();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Status.OK_STATUS;

  }
}

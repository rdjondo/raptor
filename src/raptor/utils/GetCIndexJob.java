package raptor.utils;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.*;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.index.IIndexBinding;
import org.eclipse.cdt.core.index.IndexFilter;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class GetCIndexJob extends Job {

  /**
   * Prefix used to retrieve the functions
   */
  private String prefix = "";

  /**
   * Filter required for filtering the different bindings
   */
  private IndexFilter filter;

  /**
   * Contains the list of functions
   */
  private static Set<String> bindingSet;

  public GetCIndexJob() {
    super("GetCIndexJob");
    bindingSet = new TreeSet<String>();
    filter = new IndexFilter() {
      @Override
      public boolean acceptBinding(IBinding binding) throws CoreException {
        if (binding instanceof IFunction) {
          return true;
        } else {
          return false;
        }
      }
    };
  }
  
  public void setPrefix(String prefx){
    prefix = prefx;
  }

  @Override
  protected IStatus run(IProgressMonitor monitor) {
    try {
      IIndex index = CCorePlugin.getIndexManager().getIndex(
          CoreModel.getDefault().getCModel().getCProjects());
      if (monitor.isCanceled()) return Status.CANCEL_STATUS;
      try {
        index.acquireReadLock();
        char[] prefixChar = new char[prefix.length()];
        
        /*Copy prefix String to prefixChar array*/
        prefix.getChars(0, prefix.length(), prefixChar, 0);
        
        IIndexBinding[] bindings = index.findBindingsForPrefix(prefixChar,
            false, filter, monitor);
        System.out.println("Get getQualifiedName");
        for (IIndexBinding binding : bindings) {
          bindingSet.add(binding.getName());
        }
        /*
        System.out.println("Get getAllFiles");
        for (IIndexFile file : index.getAllFiles()) {
          System.out.println(file.toString());
        }*/
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
  
  public Set<String> getBindingSet(){
    return bindingSet;
  }
  
}

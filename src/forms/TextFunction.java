package forms;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.widgets.*;

public class TextFunction implements IDocument {

  private Text text;
  
  public TextFunction(Composite parent, int style) {
    text = new Text(parent, style);
    // TODO Auto-generated constructor stub
  }
  
  public TextFunction(Text text){
    this.text = text;
  }
  
  public Text getText() {
    // TODO Auto-generated method stub
    return text;
  }
  
  @Override
  public char getChar(int offset) throws BadLocationException {
    // TODO Auto-generated method stub
    
    return 0;
  }

  @Override
  public int getLength() {
    // TODO Auto-generated method stub
    return text.getCharCount();
  }

  @Override
  public String get() {
    // TODO Auto-generated method stub
    return text.getText();
  }

  @Override
  public String get(int offset, int length) throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void set(String txt) {
    // TODO Auto-generated method stub
    text.setText(txt);
  }

  @Override
  public void replace(int offset, int length, String text)
      throws BadLocationException {
    // TODO Auto-generated method stub

  }

  @Override
  public void addDocumentListener(IDocumentListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeDocumentListener(IDocumentListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePrenotifiedDocumentListener(
      IDocumentListener documentAdapter) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPositionCategory(String category) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePositionCategory(String category)
      throws BadPositionCategoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public String[] getPositionCategories() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean containsPositionCategory(String category) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void addPosition(Position position) throws BadLocationException {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePosition(Position position) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPosition(String category, Position position)
      throws BadLocationException, BadPositionCategoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePosition(String category, Position position)
      throws BadPositionCategoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public Position[] getPositions(String category)
      throws BadPositionCategoryException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean containsPosition(String category, int offset, int length) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int computeIndexInCategory(String category, int offset)
      throws BadLocationException, BadPositionCategoryException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void addPositionUpdater(IPositionUpdater updater) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePositionUpdater(IPositionUpdater updater) {
    // TODO Auto-generated method stub

  }

  @Override
  public void insertPositionUpdater(IPositionUpdater updater, int index) {
    // TODO Auto-generated method stub

  }

  @Override
  public IPositionUpdater[] getPositionUpdaters() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String[] getLegalContentTypes() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getContentType(int offset) throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ITypedRegion getPartition(int offset) throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ITypedRegion[] computePartitioning(int offset, int length)
      throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addDocumentPartitioningListener(
      IDocumentPartitioningListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeDocumentPartitioningListener(
      IDocumentPartitioningListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
    // TODO Auto-generated method stub

  }

  @Override
  public IDocumentPartitioner getDocumentPartitioner() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getLineLength(int line) throws BadLocationException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getLineOfOffset(int offset) throws BadLocationException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getLineOffset(int line) throws BadLocationException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public IRegion getLineInformation(int line) throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IRegion getLineInformationOfOffset(int offset)
      throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getNumberOfLines() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getNumberOfLines(int offset, int length)
      throws BadLocationException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int computeNumberOfLines(String text) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String[] getLegalLineDelimiters() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getLineDelimiter(int line) throws BadLocationException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int search(int startOffset, String findString, boolean forwardSearch,
      boolean caseSensitive, boolean wholeWord) throws BadLocationException {
    // TODO Auto-generated method stub
    return 0;
  }

  public void addMouseListener(FunctionFieldContributor functionFieldContributor) {
    // TODO Auto-generated method stub
    text.addMouseListener(functionFieldContributor);
  }

}

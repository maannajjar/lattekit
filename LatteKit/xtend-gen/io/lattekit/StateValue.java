package io.lattekit;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class StateValue {
  @Accessors
  private Object value;
  
  private ArrayList<Object> listeners = CollectionLiterals.<Object>newArrayList();
  
  public void setValue(final Object newValue) {
    this.value = newValue;
    for (final Object li : this.listeners) {
      ((Procedure1<? super Object>) li).apply(newValue);
    }
  }
  
  public void watch(final Procedure1<? super Object> listener) {
    this.listeners.add(listener);
  }
  
  @Pure
  public Object getValue() {
    return this.value;
  }
}

package io.lattekit.android;

import io.lattekit.LatteView;
import io.lattekit.Layout;
import io.lattekit.State;
import io.lattekit.ui.Button;
import io.lattekit.ui.LinearLayout;
import io.lattekit.ui.View;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@LatteView
@SuppressWarnings("all")
public class VirtualGroup extends View {
  @State
  @SuppressWarnings(value = "all")
  private int _totalButtons = 3;
  
  @State
  @SuppressWarnings(value = "all")
  private int _totalRows = 1;
  
  @State
  @SuppressWarnings(value = "all")
  private Procedure1<? super View> _onButtonTap;
  
  @Layout
  @Override
  public View render() {
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout> _createAttributes_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout>() {
    public void apply(final io.lattekit.ui.LinearLayout it) {
    		// setOrientation
    		it.setOrientation("vertical");
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout> _createChildren_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout>() {
    public void apply(final io.lattekit.ui.LinearLayout it) {
    
    for (int i =0; i<getTotalRows(); i++) {final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout> _createAttributes_2 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout>() {
    public void apply(final io.lattekit.ui.LinearLayout it) {
    		// setOrientation
    		it.setOrientation("horizontal");
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout> _createChildren_2 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.LinearLayout>() {
    public void apply(final io.lattekit.ui.LinearLayout it) {
    
    for (int y = 0;y<getTotalButtons(); y++) {
    				final int z = y;final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createAttributes_3 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    		// setWidth
    		it.setWidth(wrap_content);
    		// setHeight
    		it.setHeight(wrap_content);
    		// setLabel
    		it.setLabel("Hello "+z);
    		// setOnTap
    		final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View> _onTap_handler = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View>() {
    								public void apply(final io.lattekit.ui.View $0) {
    									VirtualGroup self =  VirtualGroup.this;
    									self.getOnButtonTap().apply($0);
    								} 
    							};
    							it.setOnTap(_onTap_handler);
    							
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createChildren_3 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    
    	}
    };
    io.lattekit.ui.Button.Button(it, _createAttributes_3, _createChildren_3);}	}
    };
    io.lattekit.ui.LinearLayout.LinearLayout(it, _createAttributes_2, _createChildren_2);}	}
    };
    return io.lattekit.ui.LinearLayout.LinearLayout(this, _createAttributes_1, _createChildren_1);
  }
  
  public LinearLayout renderX() {
    final Procedure1<LinearLayout> _function = new Procedure1<LinearLayout>() {
      @Override
      public void apply(final LinearLayout it) {
        it.setOrientation("vertical");
        it.width = it.MATCH_PARENT;
        it.height = it.WRAP_CONTENT;
      }
    };
    final Procedure1<LinearLayout> _function_1 = new Procedure1<LinearLayout>() {
      @Override
      public void apply(final LinearLayout it) {
        int _totalRows = VirtualGroup.this.getTotalRows();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _totalRows, true);
        for (final Integer i : _doubleDotLessThan) {
          final Procedure1<LinearLayout> _function = new Procedure1<LinearLayout>() {
            @Override
            public void apply(final LinearLayout it) {
              it.setOrientation("horizontal");
              it.width = it.MATCH_PARENT;
              it.height = it.WRAP_CONTENT;
            }
          };
          final Procedure1<LinearLayout> _function_1 = new Procedure1<LinearLayout>() {
            @Override
            public void apply(final LinearLayout it) {
              int _totalButtons = VirtualGroup.this.getTotalButtons();
              IntegerRange _upTo = new IntegerRange(0, _totalButtons);
              for (final Integer z : _upTo) {
                final Procedure1<Button> _function = new Procedure1<Button>() {
                  @Override
                  public void apply(final Button it) {
                    it.width = it.WRAP_CONTENT;
                    it.height = it.WRAP_CONTENT;
                    it.setLabel(("Hello " + z));
                    final Procedure1<View> _function = new Procedure1<View>() {
                      @Override
                      public void apply(final View it) {
                        Procedure1<? super View> _onButtonTap = VirtualGroup.this.getOnButtonTap();
                        _onButtonTap.apply(((Button) it));
                      }
                    };
                    it.onTap = _function;
                  }
                };
                final Procedure1<Button> _function_1 = new Procedure1<Button>() {
                  @Override
                  public void apply(final Button it) {
                  }
                };
                Button.Button(it, _function, _function_1);
              }
            }
          };
          LinearLayout.LinearLayout(it, _function, _function_1);
        }
      }
    };
    return LinearLayout.LinearLayout(this, _function, _function_1);
  }
  
  private String viewVariant;
  
  public static VirtualGroup VirtualGroup(final View parentView, final String id, final Procedure1<VirtualGroup> attrs, final Procedure1<VirtualGroup> children) {
    VirtualGroup me = new VirtualGroup();
    me.processNode(parentView,id,attrs,children);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public static VirtualGroup VirtualGroup(final View parentView, final Procedure1<VirtualGroup> attrs, final Procedure1<VirtualGroup> children) {
    VirtualGroup me = new VirtualGroup();
    me.processNode(parentView,null,attrs,children);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public static VirtualGroup VirtualGroup(final View parentView, final String id, final Procedure1<VirtualGroup> attrs) {
    VirtualGroup me = new VirtualGroup();
    me.processNode(parentView,id,attrs,null);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public static VirtualGroup VirtualGroup(final View parentView, final Procedure1<VirtualGroup> attrs) {
    VirtualGroup me = new VirtualGroup();
    me.processNode(parentView,null,attrs,null);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public static VirtualGroup VirtualGroup(final View parentView, final String id) {
    VirtualGroup me = new VirtualGroup();;
    me.processNode(parentView,id,null,null);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public static VirtualGroup VirtualGroup(final View parentView) {
    VirtualGroup me = new VirtualGroup();
    me.processNode(parentView,null,null,null);
    me.viewVariant = "VirtualGroup";
    return me;
  }
  
  public int getTotalButtons() {
    return _totalButtons;
  }
  
  public void setTotalButtons(final int newValue) {
    _totalButtons = newValue;
    onStateChanged("totalButtons");
  }
  
  public int getTotalRows() {
    return _totalRows;
  }
  
  public void setTotalRows(final int newValue) {
    _totalRows = newValue;
    onStateChanged("totalRows");
  }
  
  public Procedure1<? super View> getOnButtonTap() {
    return _onButtonTap;
  }
  
  public void setOnButtonTap(final Procedure1<? super View> newValue) {
    _onButtonTap = newValue;
    onStateChanged("onButtonTap");
  }
}

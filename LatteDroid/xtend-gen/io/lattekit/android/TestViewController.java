package io.lattekit.android;

import android.graphics.Color;
import io.lattekit.LatteView;
import io.lattekit.Layout;
import io.lattekit.State;
import io.lattekit.ui.Style;
import io.lattekit.ui.View;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@LatteView
@SuppressWarnings("all")
public class TestViewController extends View {
  @State
  @SuppressWarnings(value = "all")
  private int _red = 50;
  
  @State
  @SuppressWarnings(value = "all")
  private int _green = 50;
  
  @State
  @SuppressWarnings(value = "all")
  private int _blue = 50;
  
  @State
  @SuppressWarnings(value = "all")
  private int _totalRows = 2;
  
  @State
  @SuppressWarnings(value = "all")
  private String _anchor = "Button1";
  
  private Style style = ObjectExtensions.<Style>operator_doubleArrow(new Style(), new Procedure1<Style>() {
    @Override
    public void apply(final Style it) {
      it.backgroundColor = "#E53935";
      it.borderWidth = Integer.valueOf(5);
      it.borderColor = "#B71C1C";
      it.textColor = Integer.valueOf(Color.WHITE);
      it.marginTop = Integer.valueOf(30);
      it.marginLeft = Integer.valueOf(30);
      it.marginRight = Integer.valueOf(30);
      it.cornerRadius = Integer.valueOf(50);
      it.elevation = Integer.valueOf(5);
      it.translationY = Integer.valueOf(0);
    }
  });
  
  private Style touchStyle = ObjectExtensions.<Style>operator_doubleArrow(new Style(), new Procedure1<Style>() {
    @Override
    public void apply(final Style it) {
      int _parseColor = Color.parseColor("#FFEBEE");
      it.backgroundColor = Integer.valueOf(_parseColor);
      it.borderWidth = Integer.valueOf(3);
      it.borderColor = Integer.valueOf(Color.WHITE);
      it.marginTop = Integer.valueOf(50);
      it.elevation = Integer.valueOf(0);
      it.translationY = Integer.valueOf(2);
      it.translationX = Integer.valueOf(2);
    }
  });
  
  private Style disabledStyle = ObjectExtensions.<Style>operator_doubleArrow(new Style(), new Procedure1<Style>() {
    @Override
    public void apply(final Style it) {
      it.backgroundColor = Integer.valueOf(Color.GRAY);
      it.borderColor = Integer.valueOf(Color.DKGRAY);
      it.borderWidth = Integer.valueOf(3);
      it.elevation = Integer.valueOf(0);
      it.marginTop = Integer.valueOf(50);
    }
  });
  
  private Style helloStyle = ObjectExtensions.<Style>operator_doubleArrow(new Style(), new Procedure1<Style>() {
    @Override
    public void apply(final Style it) {
      it.backgroundColor = "#0288D1";
      it.borderWidth = Integer.valueOf(5);
      it.borderColor = "#0277BD";
      it.textColor = Integer.valueOf(Color.WHITE);
      it.marginTop = Integer.valueOf(30);
      it.marginLeft = Integer.valueOf(30);
      it.marginRight = Integer.valueOf(30);
      it.cornerRadius = Integer.valueOf(50);
      it.elevation = Integer.valueOf(5);
      it.translationY = Integer.valueOf(0);
    }
  });
  
  @Layout
  @Override
  public View render() {
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.RelativeLayout> _createAttributes_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.RelativeLayout>() {
    public void apply(final io.lattekit.ui.RelativeLayout it) {
    		// setWidth
    		it.setWidth(match_parent);
    		// setHeight
    		it.setHeight(match_parent);
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.RelativeLayout> _createChildren_1 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.RelativeLayout>() {
    public void apply(final io.lattekit.ui.RelativeLayout it) {
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createAttributes_2 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    		// setId
    		it.setId("Button1");
    		// setAlignParentStart
    		it.setAttribute("alignParentStart",true);
    		// setStyle
    		it.setStyle(style);
    		// setTouchedStyle
    		it.setTouchedStyle(touchStyle);
    		// setLabel
    		it.setLabel("Hi there");
    		// setOnTap
    		final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View> _onTap_handler = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View>() {
    								public void apply(final io.lattekit.ui.View $0) {
    									TestViewController self =  TestViewController.this;
    									self.setMyAnchor("Button1");
    								} 
    							};
    							it.setOnTap(_onTap_handler);
    							
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createChildren_2 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    
    	}
    };
    io.lattekit.ui.Button.Button(it, _createAttributes_2, _createChildren_2);final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createAttributes_3 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    		// setId
    		it.setId("Button2");
    		// setAlignParentEnd
    		it.setAttribute("alignParentEnd",true);
    		// setStyle
    		it.setStyle(style);
    		// setTouchedStyle
    		it.setTouchedStyle(touchStyle);
    		// setLabel
    		it.setLabel("Button 2");
    		// setOnTap
    		final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View> _onTap_handler = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.View>() {
    								public void apply(final io.lattekit.ui.View $0) {
    									TestViewController self =  TestViewController.this;
    									self.setMyAnchor("Button2");
    								} 
    							};
    							it.setOnTap(_onTap_handler);
    							
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createChildren_3 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    
    	}
    };
    io.lattekit.ui.Button.Button(it, _createAttributes_3, _createChildren_3);final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createAttributes_4 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    		// setBelow
    		it.setAttribute("below","Button1");
    		// setStyle
    		it.setStyle(helloStyle);
    		// setTouchedStyle
    		it.setTouchedStyle(touchStyle);
    		// setAlignStart
    		it.setAttribute("alignStart",getAnchor());
    		// setLabel
    		it.setLabel("Hello 2");
    	}
    };
    
    final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button> _createChildren_4 = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<io.lattekit.ui.Button>() {
    public void apply(final io.lattekit.ui.Button it) {
    
    	}
    };
    io.lattekit.ui.Button.Button(it, _createAttributes_4, _createChildren_4);	}
    };
    return io.lattekit.ui.RelativeLayout.RelativeLayout(this, _createAttributes_1, _createChildren_1);
  }
  
  public void setMyAnchor(final String a) {
    this.setAnchor(a);
  }
  
  private String viewVariant;
  
  public static TestViewController TestViewController(final View parentView, final String id, final Procedure1<TestViewController> attrs, final Procedure1<TestViewController> children) {
    TestViewController me = new TestViewController();
    me.processNode(parentView,id,attrs,children);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public static TestViewController TestViewController(final View parentView, final Procedure1<TestViewController> attrs, final Procedure1<TestViewController> children) {
    TestViewController me = new TestViewController();
    me.processNode(parentView,null,attrs,children);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public static TestViewController TestViewController(final View parentView, final String id, final Procedure1<TestViewController> attrs) {
    TestViewController me = new TestViewController();
    me.processNode(parentView,id,attrs,null);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public static TestViewController TestViewController(final View parentView, final Procedure1<TestViewController> attrs) {
    TestViewController me = new TestViewController();
    me.processNode(parentView,null,attrs,null);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public static TestViewController TestViewController(final View parentView, final String id) {
    TestViewController me = new TestViewController();;
    me.processNode(parentView,id,null,null);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public static TestViewController TestViewController(final View parentView) {
    TestViewController me = new TestViewController();
    me.processNode(parentView,null,null,null);
    me.viewVariant = "TestViewController";
    return me;
  }
  
  public int getRed() {
    return _red;
  }
  
  public void setRed(final int newValue) {
    _red = newValue;
    onStateChanged("red");
  }
  
  public int getGreen() {
    return _green;
  }
  
  public void setGreen(final int newValue) {
    _green = newValue;
    onStateChanged("green");
  }
  
  public int getBlue() {
    return _blue;
  }
  
  public void setBlue(final int newValue) {
    _blue = newValue;
    onStateChanged("blue");
  }
  
  public int getTotalRows() {
    return _totalRows;
  }
  
  public void setTotalRows(final int newValue) {
    _totalRows = newValue;
    onStateChanged("totalRows");
  }
  
  public String getAnchor() {
    return _anchor;
  }
  
  public void setAnchor(final String newValue) {
    _anchor = newValue;
    onStateChanged("anchor");
  }
}

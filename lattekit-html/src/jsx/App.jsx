import React from 'react';
import ReactDOM from 'react-dom'

class LatteView extends React.Component {
  constructor(props) {
    super(props);
  }
  
  getEl(view,i) {
   if (view.type == "io.lattekit.ui.view.ListView") {
      return (<ListView key={i} layout={view} {...view.props}/>)
    } else if (view.type == "io.lattekit.ui.view.ImageView") {
      return (<ImageView key={i} layout={view} {...view.props}/>)
    } else if (view.type == "android.widget.TextView") {
      return (<TextView key={i} layout={view} {...view.props}/>)
    }  else if (view.type == "io.lattekit.ui.view.LinearLayout") {
      return (<LinearLayout key={i} layout={view} {...view.props}/>)
    } else if (view.type == "io.lattekit.ui.view.RelativeLayout") {
      return (<LinearLayout key={i} layout={view} {...view.props}/>)
    } else if (view.type == "andorid.view.View") {
      return (<View key={i} layout={view} {...view.props}/>)
    } else if(!view.is_native) {
      return (<LatteView type={view.type} layout={view} {...view.props}/>)
    }
    return (<div>Unknown El {view.type}</div>)
  }

  render() {
    var subView = this.props.layout.subViews[0];
    return this.getEl(subView)
  }
}

class RelativeLayout extends LatteView {
  render() {
    return (<div className={"latte-relativelayout "+this.props.cls}>
        {this.props.layout.subViews.map((subView,i) => {
          return this.getEl(subView,i)
        })}
    </div>)
  }
}

class LinearLayout extends LatteView {
  render() {
    return (<div className={"latte-linearlayout "+this.props.cls}>
        {this.props.layout.subViews.map((subView,i) => {
          return this.getEl(subView,i)
        })}
    </div>)
  }
}

class ListView extends LatteView {
  render() {
    return (<div className={"latte-listview "+this.props.cls}>
        {this.props.layout.subViews.map((subView,i) => {
          return this.getEl(subView,i)
        })}
    </div>)
  }
}

class ImageView extends LatteView {
  render() {
    return (<div className={"latte-imageview "+this.props.cls}>Image</div>)
  }
}

class TextView extends LatteView {
  render() {
    return (<div className={"latte-textview "+this.props.cls}>{this.props.layout.props.text}</div>)
  }
}


class View extends LatteView {
  render() {
    return (<div className={"latte-view "+this.props.cls}>Image</div>)
  }
}

$.ajax({
    type: "GET",  
    url: "http://localhost:4567/layout",  
    data: {
      format:"json"
    }
}).done((data) => {
  ReactDOM.render( (<LatteView layout={JSON.parse(data)} />) , document.getElementById('content'));  
});





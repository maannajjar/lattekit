package io.lattekit.android

import android.graphics.Color
import io.lattekit.Latte
import io.lattekit.Layout
import io.lattekit.State
import io.lattekit.ui.LatteView
import io.lattekit.ui.Style

@Latte
class TestViewController extends LatteView {
	
	@State var int red = 50;
	@State var int green = 50;
	@State var int blue = 50;
	@State var int totalRows = 2;
	
	@State var String anchor = "Button1";
	
	var style = new Style() => [
		backgroundColor = "#E53935";
		borderWidth = 5
		borderColor = "#B71C1C"
		textColor = Color.WHITE
		marginLeft = 30
		marginRight = 30
		cornerRadius = 100
		paddingLeft = 30
		paddingRight = 30
		it.width = WRAP_CONTENT
		it.height = 200
		elevation = 0
		transitions = #[
			#[ "width", 200, null,300],
			#[ "height", 10000, null,0],
			#[ "marginLeft", 200, null,300],
			#[ "marginRight", 200, null,300],			
			#[ "cornerRadius", 300, null,0],
			#[ "borderWidth", 300, null,0],
			#[ "elevation", 600, null,0]
		]		
	]
	
	var touchStyle = new Style() => [
		backgroundColor = "#0288D1";
		borderWidth = 20
		cornerRadius = 0
		it.width = MATCH_PARENT
		it.height = MATCH_PARENT
		elevation = 10
		borderColor = "#0277BD"
		marginLeft = 0
		marginRight = 0
		transitions = #[
			#[ "width", 200, null,0],
			#[ "height", 10000, null,300],
			#[ "cornerRadius", 300, null,0],
			#[ "borderWidth", 300, null,0],
			#[ "marginLeft", 200, null,0],
			#[ "marginRight", 200, null,0],
			#[ "elevation", 300, null,0]
			
		]
	]
	
	
	var disabledStyle = new Style() => [
		backgroundColor = Color.GRAY;
		borderColor = Color.DKGRAY
		borderWidth = 3
		elevation = 0
		marginTop = 50
	]
	
	
	var helloStyle = new Style() => [
		backgroundColor = "#0288D1";
		borderWidth = 5
		borderColor = "#0277BD"
		textColor = Color.WHITE
		marginTop = 30
		marginLeft = 30
		marginRight = 30
		cornerRadius = 50
		elevation = 5
		translationY = 0;
		paddingLeft = 20;
		paddingRight = 20;
	]
	var helloStyleB = new Style() => [
		backgroundColor = "#BBDEFB";
		elevation = 30
	]
	
	
	var layoutStyle = new Style() => [
		width = MATCH_PARENT
		height = MATCH_PARENT
	]
	
	
	@Layout(imports=#["io.lattekit.android"])
	override render() '''
		<RelativeLayout style={layoutStyle}>
			<Button id="Button1" alignParentStart={true} style={style} touchedStyle={touchStyle} label="Button 1" onTap={self.setMyAnchor("Button1")}/>
			<Button id="Button2" alignParentEnd={true}  style={style} touchedStyle={touchStyle} label="Button 2" onTap={self.setMyAnchor("Button2")}/>
			
			<Button below="Button1" style={helloStyle} touchedStyle={helloStyleB} label={@anchor}/>
		</RelativeLayout>
	'''

	def void addRow(VirtualGroup virtualGroup) {
		virtualGroup.totalRows = virtualGroup.totalRows+1; 
	}
	def void setMyAnchor(String a) {
//		this.anchor = a;
	}

}
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
		marginTop = 30
		marginLeft = 30
		marginRight = 30
		cornerRadius = 100
		elevation = 5
		translationY = 0;
	]
	
	var touchStyle = new Style() => [
		backgroundColor = "#B71C1C";
		borderWidth = 10
		cornerRadius = 10
		borderColor = Color.WHITE
		marginTop = 50
		elevation = 0
		translationY = 10;
		translationX = 10;
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
	
	@Layout
	override render() '''
		<RelativeLayout width={match_parent} height={match_parent}>
			<Button id="Button1" alignParentStart={true} style={style} touchedStyle={touchStyle} label="Hi there" onTap={self.setMyAnchor("Button1")}/>
			<Button id="Button2" alignParentEnd={true}  style={style} touchedStyle={touchStyle} label="Button 2" onTap={self.setMyAnchor("Button2")}/>
			
			<Button below="Button1" style={helloStyle}  touchedStyle={helloStyleB} label={@anchor}/>
		</RelativeLayout>
	'''

	def void setMyAnchor(String a) {
		this.anchor = a;
	}

}
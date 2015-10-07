package io.lattekit.android

import android.graphics.Color
import io.lattekit.Latte
import io.lattekit.Layout
import io.lattekit.State
import io.lattekit.ui.LatteView
import io.lattekit.ui.Style

@Latte
class VirtualGroup extends LatteView {
	
	@State var int totalButtons = 3; 
	@State var int totalRows = 1; 
	@State var (LatteView)=>void onButtonTap
	@State var int color = Color.WHITE;
	
	Style myStyle = new Style() => [
		width = match_parent
		height = match_parent
		backgroundColor = Color.BLUE
	]
	
	@Layout
	override render() '''
		<LinearLayout orientation="vertical" style={myStyle}>
		for (int i =0; i< @totalRows; i++) {
			final int j = i;
			if (j%2 == 0) {
				<Button label={"Button "+@totalButtons} onTap={self.myTap(j); } />
			} else {
				<Button label={"Button "+@totalButtons} onTap={@onButtonTap.apply($0); android.util.Log.d("Latte", "Total buttons"+@totalButtons); } />
			}
		} 
		</LinearLayout>
	'''
	
	def myTap(int j ) {
		setTotalButtons(j);
	}
	
//			if (j%2 == 0) {
//				<Button label={"Button "+@totalButtons} onTap={self.myTap(j); } />
//			} else {
//				<Button label={"Button "+@totalButtons} onTap={@onButtonTap.apply($0); android.util.Log.d("Latte", "Total buttons"+@totalButtons); } />
//			}	
//	override render() {
//		LinearLayout([orientation="vertical"; style = new Style()=>[width=match_parent; height=match_parent]]) [
//			for (i : 0..<totalRows) {
//				LinearLayout([ orientation="horizontal"; style = new Style()=>[width=match_parent; height=wrap_content] ]) [ 
//					for (z : 0 ..<totalButtons) {
//						Button([ style = this.style 
//								 touchedStyle = this.touchedStyle 
//								 label = "Hello "+z; 
//								 onTap = [if (onButtonTap!=null) onButtonTap.apply(it as Button)] ]) []
//					}
//				]
//			}
//			
//			
//		]
//	}
}
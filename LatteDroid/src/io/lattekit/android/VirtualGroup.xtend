package io.lattekit.android

import android.util.Log
import io.lattekit.Latte
import io.lattekit.State
import io.lattekit.ui.Button
import io.lattekit.ui.LatteView
import io.lattekit.ui.Style

import static extension io.lattekit.ui.Button.*
import static extension io.lattekit.ui.LinearLayout.*

@Latte
class VirtualGroup extends LatteView {
	
	@State var int totalButtons = 3; 
	@State var int totalRows = 1; 
	@State var (LatteView)=>void onButtonTap
	 
//	
//	@Layout
//	override render() '''
//		<LinearLayout orientation="vertical">
//		for (int i =0; i< @totalRows; i++) {
//			<LinearLayout orientation="horizontal">
//			for (int y = 0;y < @totalButtons; y++) {
//				final int z = y; 
//				<Button label={"Hello "+z} onTap={self.@onButtonTap.apply($0)} />
//			}
//			</LinearLayout>
//		} 
//		</LinearLayout>
//	'''
	
	override render() {
		LinearLayout([orientation="vertical"; style = new Style()=>[width=match_parent; height=match_parent]]) [
			for (i : 0..<totalRows) {
				LinearLayout([ orientation="horizontal"; style = new Style()=>[width=match_parent; height=wrap_content] ]) [ 
					for (z : 0 ..<totalButtons) {
						Button([ style = this.style 
								 touchedStyle = this.touchedStyle 
								 label = "Hello "+z; 
								 onTap = [if (onButtonTap!=null) onButtonTap.apply(it as Button)] ]) []
					}
				]
			}
			
			
		]
	}
}
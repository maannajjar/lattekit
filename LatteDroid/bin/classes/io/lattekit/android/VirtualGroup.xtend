package io.lattekit.android

import io.lattekit.LatteView
import io.lattekit.Layout
import io.lattekit.State
import io.lattekit.ui.Button
import io.lattekit.ui.View

import static extension io.lattekit.ui.Button.*
import static extension io.lattekit.ui.LinearLayout.*

@LatteView
class VirtualGroup extends View {
	
	@State var int totalButtons = 3; 
	@State var int totalRows = 1; 
	@State var (View)=>void onButtonTap
	 
	
	@Layout
	override render() '''
		<LinearLayout orientation="vertical">
		for (int i =0; i< @totalRows; i++) {
			<LinearLayout orientation="horizontal">
			for (int y = 0;y < @totalButtons; y++) {
				final int z = y; 
				<Button width={wrap_content} height={wrap_content} label={"Hello "+z} onTap={self.@onButtonTap.apply($0)} />
			}
			</LinearLayout>
		} 
		</LinearLayout>
	'''
	
	def renderX() {
		LinearLayout([orientation="vertical"; width = MATCH_PARENT; height = WRAP_CONTENT]) [
			for (i : 0..<totalRows) {
				LinearLayout([ orientation="horizontal"; width = MATCH_PARENT; height = WRAP_CONTENT ]) [ 
					for (z : 0 ..totalButtons) {
						Button([ width = WRAP_CONTENT; 
								 height = WRAP_CONTENT; 
								 label = "Hello "+z; 
								 onTap = [onButtonTap.apply(it as Button)] ]) []
					}
				]
			}
			
			
		]
	}
}
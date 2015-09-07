package io.lattekit

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

class StateValue {
	@Accessors Object value;
	var listeners = newArrayList;
	
	def void setValue(Object newValue) {
		this.value = newValue;
		
		for (Object li : listeners) {
			(li as Procedure1<? super Object>).apply(newValue);
		}
	}
	
	def void watch((Object)=>void listener) {
		listeners += listener;
	}
}
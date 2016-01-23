package io.lattekit.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.lattekit.Layout
import io.lattekit.ui.style.Stylesheet
import io.lattekit.ui.view.LatteView
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
//
//class LatteFragment extends Fragment {
//	@Accessors var LatteView latteView;
//	var View androidView;
//	
//	override onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		super.onCreateView(inflater,container,savedInstanceState);
//		latteView =  LatteFragment.this.render();
////		latteView.loadStylesheet(cssFiles);
////		latteView.onViewMounted = [LatteFragment.this.onViewMounted() ]
//		androidView = latteView.buildView(activity);
//	}
//	
//	def onViewMounted() {
//
//	}
//	
//	def onStateChanged() {
//		latteView.onStateChanged();		
//	}
//	
//	def List<Stylesheet> getCssFiles() {
//		return #[]		
//	}
//
//	
//}
//
//
//class LatteSupportFragment extends android.support.v4.app.Fragment {
//	var View androidView;
//	
//	override onActivityCreated(Bundle savedInstanceState) {
//		super.onActivityCreated(savedInstanceState)
//	}
//	
//	def onViewMounted() {
//	}
//	
//	def getAndroidActivity() {
//		return getActivity();
//	}
//		
//	override onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		super.onCreateView(inflater,container,savedInstanceState);
////		androidView = latteView.buildView(activity);
//	}
//	
//	
//	
//	def List<Stylesheet> getCssFiles() {
//		return #[]		
//	}
//	
//}
package io.lattekit.transformer


class Main {
	var static testCase ='''
package com.digg2.ui

import android.util.Log
import com.digg2.api.ApiManager
import com.digg2.data.model.Story
import io.lattekit.Layout
import io.lattekit.ui.view.LatteView
import io.realm.Realm
import java.util.List
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by maan on 12/16/15.
 */
 
class HomeFeed extends LatteView {

    List<Story> items = newArrayList();
    var Realm realm;
	
    override onViewMounted() {
    	realm = Realm.getInstance(this.activity)
        downloadFeed();
        displayFeed();    	
    }
    
    def downloadFeed() {
        ApiManager.getApi().getNews("top")
	        .subscribeOn(Schedulers.newThread)
	        .observeOn(AndroidSchedulers.mainThread)
	        .subscribe[ response |
	        	realm.executeTransaction[ realm.copyToRealmOrUpdate(response.data.feed) ]
	        ]    	
    }
    
    def displayFeed() {
       realm.where(Story).findAllAsync().asObservable.subscribe[ results |
       		items = results;
       		Log.d("Digg","Got "+items.length +" Items ")
       		onStateChanged();
       ];
    }
	
	def void handleStoryClick(Story story) {
		new ArticleView(story).show(this);
	}
	
    @Layout(imports=#["com.digg2.ui"])
    override render() {
		return $(/*		<LinearLayout orientation="vertical" cls="container">
					<ListView data={items}  cls="container" dividerHeight={0} onItemClick=[ Story s | handleStoryClick(s) ]>
		                <MarqueeStoryCell when=[ Story item, Integer index | index == 0] />
		                <CompactStoryCell defaultView="true"  />
					</ListView>
				</LinearLayout>*/)
	}
	
}	
	'''
	
	def static void main(String[] args) {
		var compiler = new Transformer();
		System.out.println(compiler.transform(testCase));
	}	
}
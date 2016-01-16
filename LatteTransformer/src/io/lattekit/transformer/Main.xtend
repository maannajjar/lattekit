package io.lattekit.transformer


class Main {
	var static testCase ='''

package com.digg2.ui;

import io.lattekit.ui.view.LatteView;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Conversions;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.util.Log;

import com.digg2.api.ApiManager;
import com.digg2.api.DiggApi;
import com.digg2.data.model.ApiResponse;
import com.digg2.data.model.ApiResponseData;
import com.digg2.data.model.Story;

public class HomeFeed extends LatteView {

    List<Story> items = new ArrayList<Story>();
    Realm realm;
	
    public void onViewMounted() {
    	realm = Realm.getInstance(this.activity);
        downloadFeed();
        displayFeed();    	
    }

    public Subscription downloadFeed() {
      DiggApi _api = ApiManager.getApi();
      Observable<ApiResponse<Story>> _news = _api.getNews("top");
      Scheduler _newThread = Schedulers.newThread();
      Observable<ApiResponse<Story>> _subscribeOn = _news.subscribeOn(_newThread);
      Scheduler _mainThread = AndroidSchedulers.mainThread();
      Observable<ApiResponse<Story>> _observeOn = _subscribeOn.observeOn(_mainThread);
      final Action1<ApiResponse<Story>> _function = new Action1<ApiResponse<Story>>() {
        @Override
        public void call(final ApiResponse<Story> response) {
          final Realm.Transaction _function = new Realm.Transaction() {
            @Override
            public void execute(final Realm it) {
              ApiResponseData<Story> _data = response.getData();
              RealmList<Story> _feed = _data.getFeed();
              HomeFeed.this.realm.<Story>copyToRealmOrUpdate(_feed);
            }
          };
          HomeFeed.this.realm.executeTransaction(_function);
        }
      };
      return _observeOn.subscribe(_function);
    }
    
    public Subscription displayFeed() {
      RealmQuery<Story> _where = this.realm.<Story>where(Story.class);
      RealmResults<Story> _findAllAsync = _where.findAllAsync();
      Observable<RealmResults<Story>> _asObservable = _findAllAsync.asObservable();
      final Action1<RealmResults<Story>> _function = new Action1<RealmResults<Story>>() {
        @Override
        public void call(final RealmResults<Story> results) {
          HomeFeed.this.items = results;
          int _length = ((Object[])Conversions.unwrapArray(HomeFeed.this.items, Object.class)).length;
          String _plus = ("Got " + Integer.valueOf(_length));
          String _plus_1 = (_plus + " Items ");
          Log.d("Digg", _plus_1);
          HomeFeed.this.onStateChanged();
        }
      };
      return _asObservable.subscribe(_function);
    }
	
	public Object handleStoryClick(Story story) {
		new ArticleView(story).show(this);
		return null;
	}
	
	public LatteView render() {
		return $(/*
		<io.lattekit.ui.view.LinearLayout orientation="vertical" cls="container">
			<io.lattekit.ui.view.ListView data={items}  cls="container" dividerHeight={0} onItemClick=[ Story s | handleStoryClick(s) ]>
                <com.digg2.ui.MarqueeStoryCell when=[ Story item, Integer index | index == 0] />
                <com.digg2.ui.CompactStoryCell defaultView="true"  />
			</io.lattekit.ui.view.ListView>
		</io.lattekit.ui.view.LinearLayout>		
		*/);
	}
	
}



'''
	
	def static void main(String[] args) {
		var compiler = new Transformer();
		System.out.println(compiler.transform(testCase));
	}	
}
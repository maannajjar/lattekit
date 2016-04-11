package io.lattekit.samples.view

import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import io.lattekit.Latte
import io.lattekit.annotation.Bind
import io.lattekit.annotation.Prop
import io.lattekit.plugin.css.declaration.css
import io.lattekit.samples.model.Person
import io.lattekit.view.LatteView

/**
 * Created by maan on 4/11/16.
 */

open class PeopleDirectoryView : LatteView() {

    @Bind("@id/toolbar") var toolbar : Toolbar? = null;
    @Bind("@id/ctLayout") var collapsingToolbarLayout : CollapsingToolbarLayout? = null;
    @Bind("@id/peopleList") var peopleListView : PeopleListView? = null;
    @Prop var directory : List<Person>? = emptyList();

    init {
        css("io.lattekit.samples.style/main.css")
    }

    override fun onViewCreated() {
        super.onViewCreated()
        (peopleListView?.rootAndroidView?.layoutParams as CoordinatorLayout.LayoutParams).behavior = AppBarLayout.ScrollingViewBehavior()
        (toolbar?.layoutParams as CollapsingToolbarLayout.LayoutParams).collapseMode = CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
        (collapsingToolbarLayout?.layoutParams as AppBarLayout.LayoutParams).scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED

    }

    override fun layout() = xml("""
        <android.support.design.widget.CoordinatorLayout  fitsSystemWindows="true" layout_height="match_parent" layout_width="match_parent">
            <android.support.design.widget.AppBarLayout id="@+id/appBar" fitsSystemWindows="true" layout_height="193dp" layout_width="match_parent">
                <android.support.design.widget.CollapsingToolbarLayout expandedTitleColor=${Color.parseColor("#ffffff")} collapsedTitleTextColor=${Color.parseColor("#ffffff")} fitsSystemWindows="true" id="@+id/ctLayout" title="People" layout_width="match_parent" layout_height="match_parent">
                    <android.support.v7.widget.Toolbar id="@+id/toolbar" layout_height="60dp" />
                </android.support.design.widget.CollapsingToolbarLayout>
            </android.support.design.widget.AppBarLayout>

            <io.lattekit.samples.view.PeopleListView id="@+id/peopleList" directory=${directory} />

        </android.support.design.widget.CoordinatorLayout>
    """)

}


open class PeopleListView: LatteView() {
    @Prop var directory : List<Person>? = emptyList();

    override fun layout() = xml("""
        <android.support.v7.widget.RecyclerView data=${directory} layout_width="match_parent" layout_height="match_parent"  >
            <io.lattekit.samples.view.PersonRowView defaultView="true" />
        </android.support.v7.widget.RecyclerView>
    """)
}


open class PersonRowView : LatteView() {
    @Prop("model") var person : Person? = null;

    fun showProfile() {
        Latte.showActivity(this, "<io.lattekit.samples.view.ProfileView />", mutableMapOf<String,Any?>("profile" to person))
    }

    override fun layout() = xml("""
    <RelativeLayout class="personRowContainer" onClick=${{showProfile()}} clickable="true" layout_width="match_parent">
        <ImageView id="@+id/profileImage" class="profileRowImage" src=${person?.imageUrl} />
        <TextView id="@+id/personName" class="personRowName" layout_toEndOf="@id/profileImage" text=${"${person?.firstName} ${person?.lastName}"} />
        <TextView class="personJob" layout_toEndOf="@id/profileImage" layout_below="@id/personName" text=${person?.job} />
    </RelativeLayout>
    """)
}
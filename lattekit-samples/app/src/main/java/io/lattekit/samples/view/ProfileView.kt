package io.lattekit.samples.view

import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ListView
import io.lattekit.annotation.Bind
import io.lattekit.annotation.Prop
import io.lattekit.plugin.css.declaration.css
import io.lattekit.samples.model.Person
import io.lattekit.view.LatteView

/**
 * Created by maan on 4/11/16.
 */


open class ProfileView : LatteView() {
    @Prop var profile : Person? = null;
    @Bind("@id/listView") var listView : ListView? = null;
    @Bind var header : LinearLayout? = null;
    var listData : List<Any> = emptyList()
    var isAnimatingOut = false;
    var isAnimatingIn = false;
    init {
        css("io.lattekit.samples.style/main.css")
    }

    override fun onViewCreated() {
        super.onViewCreated()

        // The list contains Profile card, "person's Friends" header, and friend list
        listData = listOf(profile!!, "${profile?.firstName}'s Friends") + profile?.friends!!;

        // Make floating header invisible initially
        header?.visibility = View.INVISIBLE;
        activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        notifyStateChanged()
    }

    fun handleScroll() {
        if (listView != null && listView!!.firstVisiblePosition > 0) {
            if (!isAnimatingIn && (header?.visibility != View.VISIBLE || header?.translationY!! < 0f)) {
                // Animate the header in
                isAnimatingOut = false;
                isAnimatingIn = true;
                header?.visibility = View.VISIBLE;
                header?.translationY = -header?.height!!.toFloat()
                header?.animate()?.setDuration(200)?.translationY(0f)?.start()
            }
        } else if (listView != null && listView!!.firstVisiblePosition == 0) {
            if (header?.visibility == View.VISIBLE && !isAnimatingOut ) {
                // Animate the header out
                isAnimatingOut = true;
                isAnimatingIn = false;
                header?.animate()?.setDuration(200)?.translationY(-header?.height!!.toFloat())?.start()
            }
        }
    }

    override fun layout() = xml("""
        <RelativeLayout>
            <ListView dividerHeight="0" id="@+id/listView" data=${listData} layout_width="match_parent" layout_height="match_parent" onScroll=${{ handleScroll(); }} >
                <io.lattekit.samples.view.PersonProfileCard when=${{ it : Person, index : Int -> index == 0 }} />
                <io.lattekit.samples.view.ListHeader when=${{ it : Any -> it is String }} />
                <io.lattekit.samples.view.PersonRowView defaultView="true" />
            </ListView>
            <LinearLayout id="@+id/header" orientation="horizontal" class="profileHeader" layout_width="match_parent" layout_height="wrap_content">
                <ImageView class="profileHeaderImage" src=${profile?.imageUrl} />
                <TextView layout_gravity="center" class="profileHeaderName" text=${profile?.firstName +" "+profile?.lastName} />
            </LinearLayout>
        </RelativeLayout>
    """)

}

open class ListHeader : LatteView() {
    init {
        css("""
        .headerText {
            background-color: #e0e0e0;
            color: #777777;
            padding: 10dp;
            padding-left: 15dp;
            font-size: 17sp;
            font-weight: bold;
            border-bottom: 1dp solid #dddddd;
        }
        """)
    }
    override fun layout() = xml("""
        <TextView class="headerText" text=${props["model"]} />
    """)
}


open class PersonProfileCard: LatteView() {
    @Prop("model") var person : Person? = null;

    override fun layout() = xml("""
        <RelativeLayout class="profileCard">
            <ImageView src=${person?.coverImageUrl} class="coverImage" id="@+id/cover" scaleType="centerCrop" />
            <ImageView src=${person?.imageUrl} class="profileCardImage" id="@+id/profileImage" layout_below="@id/cover" />
            <TextView layout_toEndOf="@id/profileImage" class="profileCardName" layout_below="@id/cover" text=${person?.firstName +" "+person?.lastName} />
        </RelativeLayout>
    """)
}



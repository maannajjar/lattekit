package io.lattekit.util;

import static spark.Spark.*;
import spark.*

import io.lattekit.ui.view.LatteView
import io.lattekit.LatteLayout
import android.app.Activity
import java.util.Map

/**
 * Created by maan on 2/2/16.
 */

class WebSimulator {

    static LatteView currentView;
    static Map<String,LatteView> objects = newHashMap();

    def static String toJson(Object obj) {
        return '''"«obj.toString().replace('"',"\\\"")»"'''
    }
    def static String toJson(LatteView view) {
        objects.put(view.objectId,view);
        return '''
            {
                "objectId": "«view.objectId»",
                "type": "«view.viewType»",
                "subViews": [«view.renderedViews.map[toJson].join(",")»],
                "children": [«view.children.map[toJson].join(",")»],
                "is_native": «view instanceof io.lattekit.ui.view.NativeView»,
                "is_view_group": «view instanceof io.lattekit.ui.view.NativeViewGroup»,
                "props": { «view.props.keySet().map[
                    '''"«it»": «toJson(view.props.get(it))»'''
                ].join(",")» }
            }
        '''
    }

    def static void render(LatteView view) {
        LatteView.RENDER_TARGET = LatteView.WEB;
        currentView = view;
        view.buildView(new Activity(),null);

        externalStaticFileLocation("/Users/maan/git/lattekit-android/lattekit-html/build/");

        get(new Route("/")  {
            override handle(Request request, Response response) {
                '''
            <!DOCTYPE html>
            <html>
              <head>
                <title>LatteKit</title>
                <meta name="viewport" content="user-scalable=no, width=device-width">
              </head>
              <body>
                <script src='/js/jquery.js'></script>
                <script src='/js/jquery.jscrollpane.min.js'></script>
                <div id="content"></div>
                <script src="/js/app.min.js"></script>
              </body>
            </html>

                '''
            }
        })

        get(new Route("/layout/:id") {
            override handle(Request request, Response response) {
                val view = objects.get(request.params(":id"))
                '''«view.toJson»'''
            }

        });

        get(new Route("/layout")  {
            override handle(Request request, Response response) {
                '''«view.toJson»'''
            }
        })
    }
}
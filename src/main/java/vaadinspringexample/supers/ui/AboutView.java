package vaadinspringexample.supers.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "about")
public class AboutView extends VerticalLayout {

    private H1 aboutUsTitle;

    private Text aboutUsInfo;

    public AboutView() {

        this.aboutUsTitle = new H1("About Us");
        this.aboutUsInfo = new Text("This app CRUDs Super Heroes, Super Villains and their Powers");

        add(aboutUsTitle);
        add(aboutUsInfo);
    }

}

package vaadinspringexample.supers.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import vaadinspringexample.supers.services.DataService;

@Route(value = "about")
public class AboutView extends VerticalLayout {

    private H1 aboutUsTitle;

    private Text aboutUsInfo;

    private DataService dataService;

    public AboutView(DataService dataService) {

        this.dataService = dataService;
        this.aboutUsTitle = new H1("About Us");
        this.aboutUsInfo = new Text(String.format("This app CRUDs Super Heroes, Super Villains and their %s Powers",
            dataService.fetchAllPowers().size()));

        add(aboutUsTitle);
        add(aboutUsInfo);
    }

}

package vaadinspringexample.supers.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import vaadinspringexample.supers.listeners.AddSuperClickListener;
import vaadinspringexample.supers.services.DataService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Route(value = "")
public class ManagementView extends VerticalLayout {

    private Tabs tabs;
    private DataService dataService;

    public ManagementView(DataService dataService) {
        this.tabs = new Tabs();
        this.dataService = dataService;

        init();
    }

    private void init() {

        // Supers Pain
        HorizontalLayout supersPaneLayout = new HorizontalLayout();
        supersPaneLayout.setMargin(true);
        supersPaneLayout.setSizeFull();

        TextField tfNickname = new TextField("Nickname");
        tfNickname.setPlaceholder("e.g. \"Big Bear\"");

        ListBox<String> lbSuperTypes = new ListBox<>();
        lbSuperTypes.setItems("Hero", "Villain");

        List<String> powers = dataService.fetchAllPowers();
        VerticalLayout cbLayout = new VerticalLayout();
        for (String power : powers) {
            Checkbox cbPower = new Checkbox();
            cbPower.setLabel(power);

            cbLayout.add(cbPower);
        }

        Button btnAddSuper = new Button("Add", new Icon(VaadinIcon.PLUS));
        btnAddSuper.addClickListener(new AddSuperClickListener(tfNickname, lbSuperTypes, cbLayout, dataService));

        supersPaneLayout.add(tfNickname, lbSuperTypes, cbLayout, btnAddSuper);

        ListBox<String> lbPowers = new ListBox<>();
        lbPowers.setItems(powers);
        lbPowers.setVisible(false);

        Div masterDiv = new Div(supersPaneLayout, lbPowers);

        Tab tbSupers = new Tab("Supers");
        Tab tbPowers = new Tab("Powers");

        tbSupers.setFlexGrow(2);
        tbPowers.setFlexGrow(2);


        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tbSupers, supersPaneLayout);
        tabsToPages.put(tbPowers, lbPowers);

        Set<Component> pagesShown = Stream.of(supersPaneLayout)
                .collect(Collectors.toSet());
        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });


        tabs.setFlexGrowForEnclosedTabs(2);

        tabs.add(tbSupers, tbPowers);


        setHorizontalComponentAlignment(Alignment.CENTER, tabs);

        add(tabs);
        add(masterDiv);

    }
}



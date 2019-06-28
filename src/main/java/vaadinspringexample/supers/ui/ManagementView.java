package vaadinspringexample.supers.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import vaadinspringexample.supers.domain.Power;


@Route(value = "")
public class ManagementView extends HorizontalLayout {

    private Tabs tabs;

    public ManagementView() {
        this.tabs = new Tabs();

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

        VerticalLayout cbLayout = new VerticalLayout();
        for (Power power : Power.values()) {
            Checkbox cbPower = new Checkbox();
            cbPower.setLabel(power.getLabel());

            cbLayout.add(cbPower);
        }

        Button btnAddSuper = new Button("Add", new Icon(VaadinIcon.PLUS));

        supersPaneLayout.add(tfNickname, lbSuperTypes, cbLayout, btnAddSuper);


        // Tabbed pane
        Tab tbSupers = new Tab("Supers");
        tbSupers.add(supersPaneLayout);

        Tab tbPowers = new Tab("Powers");

        tabs.add(tbSupers, tbPowers);


        setVerticalComponentAlignment(Alignment.CENTER, tabs);

        add(tabs);
    }

}

package vaadinspringexample.supers.listeners;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import vaadinspringexample.supers.domain.Super;
import vaadinspringexample.supers.domain.SuperType;
import vaadinspringexample.supers.services.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddSuperClickListener implements ComponentEventListener<ClickEvent<Button>> {
    private TextField tfNickname;
    private ListBox<String> lbSuperTypes;
    private VerticalLayout cbLayout;
    private DataService dataService;

    public AddSuperClickListener(TextField tfNickname, ListBox<String> lbSuperTypes, VerticalLayout cbLayout,
                                 DataService dataService) {

        this.tfNickname = tfNickname;
        this.lbSuperTypes = lbSuperTypes;
        this.cbLayout = cbLayout;
        this.dataService = dataService;

    }

    @Override
    public void onComponentEvent(ClickEvent<Button> event) {

        String nickname = tfNickname.getValue();
        String superType = lbSuperTypes.getValue();

        List<String> powers = new ArrayList<>();
        List<Component> componentList = cbLayout.getChildren().filter(child -> child instanceof Checkbox).collect(Collectors.toList());
        List<Checkbox> cbPowers = componentList.stream().map(cb -> (Checkbox) cb).collect(Collectors.toList());
        powers.addAll(cbPowers.stream().map(cbPower -> cbPower.getLabel()).collect(Collectors.toList()));

        Super newSuper = new Super(nickname, SuperType.lookup(superType), powers);

        System.out.println("Adding a new Super");

        dataService.createSuper(newSuper);

    }
}

package com.example.application.views.register;

import com.example.application.services.AuthService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Register")
@Route(value = "register", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class RegisterView extends Composite<VerticalLayout> {
    private final AuthService authService;

    public RegisterView(AuthService authService) {
        this.authService = authService;
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        textField.setLabel("Text field");
        textField.setWidth("min-content");
        textField2.setLabel("Text field");
        textField2.setWidth("min-content");
        textField3.setLabel("Text field");
        textField3.setWidth("min-content");
        getContent().add(textField);
        getContent().add(textField2);
        getContent().add(textField3);
        Button registerButton = new Button("Register");
        registerButton.addClickListener(e ->{


            this.authService.register(textField, textField2, textField3);
            Notification.show("Registered");
            UI.getCurrent().navigate("login");
        });
        getContent().add(registerButton);
    }
}

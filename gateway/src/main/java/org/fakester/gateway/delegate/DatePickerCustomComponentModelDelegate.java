package org.fakester.gateway.delegate;

import com.inductiveautomation.ignition.common.gson.JsonObject;
import com.inductiveautomation.perspective.gateway.api.Component;
import com.inductiveautomation.perspective.gateway.api.ComponentModelDelegate;
import com.inductiveautomation.perspective.gateway.messages.EventFiredMsg;

/**
 * Model Delegate for the DatePickerCustom component.
 */
public class DatePickerCustomComponentModelDelegate extends ComponentModelDelegate {

    public DatePickerCustomComponentModelDelegate(Component component) {
        super(component);
    }

    @Override
    protected void onStartup() {
        log.infof("Starting DatePickerCustom delegate for '%s'", component.getComponentAddressPath());
    }

    @Override
    protected void onShutdown() {
        log.infof("Shutting down DatePickerCustom delegate for '%s'", component.getComponentAddressPath());
    }

    @Override
    public void handleEvent(EventFiredMsg message) {
        log.infof("DatePickerCustom received event: %s", message.getEventName());

        // Ejemplo simple de evento personalizado
        JsonObject payload = message.getEvent();
        JsonObject response = new JsonObject();

        if (payload != null && payload.has("selectedDate")) {
            response.addProperty("acknowledged", true);
            response.addProperty("receivedDate", payload.get("selectedDate").getAsString());
        } else {
            response.addProperty("error", "Missing 'selectedDate' in payload");
        }

        fireEvent("datepickercustom-response", response);
    }

    @Override
    public void fireEvent(String eventName, JsonObject event) {
        component.fireEvent("model", eventName, event);
    }
}

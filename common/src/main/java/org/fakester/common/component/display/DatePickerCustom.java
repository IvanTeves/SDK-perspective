package org.fakester.common.component.display;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import org.fakester.common.RadComponents;

public class DatePickerCustom {

    public static final String COMPONENT_ID = "rad.display.datepickercustom";

    public static final JsonSchema SCHEMA = JsonSchema.parse(
            RadComponents.class.getResourceAsStream("/datepickercustom.props.json")
    );

    public static final ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory(RadComponents.COMPONENT_CATEGORY)
            .setId(COMPONENT_ID)
            .setModuleId(RadComponents.MODULE_ID)
            .setSchema(SCHEMA)
            .setName("Date Picker Custom")
            .addPaletteEntry("", "Date Picker Custom", "A customizable date picker.", null, null)
            .setDefaultMetaName("datePickerCustom")
            .setResources(RadComponents.BROWSER_RESOURCES)
            .build();
}

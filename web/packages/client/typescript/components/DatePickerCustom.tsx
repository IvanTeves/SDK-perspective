// DatePickerCustom.tsx

import React from 'react';
import { ComponentMeta, ComponentStoreDelegate, PComponent, PropertyTree, SizeObject } from '@inductiveautomation/perspective-client';
import { DatePickerComponentGatewayDelegate } from './DatePickerComponentGatewayDelegate';
import { DatePickerPropConfig, DEFAULT_DATEPICKER_CONFIG } from './types';

export const COMPONENT_TYPE = "rad.display.datepickercustom";

export class DatePickerCustom extends React.Component<any> {
    render() {
        return (
            <div>
                <input type="date" />
            </div>
        );
    }
}

export class DatePickerCustomMeta implements ComponentMeta {
    getComponentType(): string {
        return COMPONENT_TYPE;
    }

    getDefaultSize(): SizeObject {
        return {
            width: 160,
            height: 50
        };
    }

    createDelegate(component): ComponentStoreDelegate | undefined {
        return new DatePickerComponentGatewayDelegate(component);
    }

    getViewComponent(): PComponent {
        return DatePickerCustom;
    }

    getPropsReducer(tree: PropertyTree): DatePickerPropConfig {
        return {
            selectedDate: tree.read("selectedDate", DEFAULT_DATEPICKER_CONFIG.selectedDate),
            placeholder: tree.read("placeholder", DEFAULT_DATEPICKER_CONFIG.placeholder),
            disabled: tree.read("disabled", DEFAULT_DATEPICKER_CONFIG.disabled),
            styles: tree.read("styles", DEFAULT_DATEPICKER_CONFIG.styles)
        };
    }
}

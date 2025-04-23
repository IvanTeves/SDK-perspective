// types.ts

export interface DatePickerPropConfig {
    selectedDate: string;
    placeholder: string;
    disabled: boolean;
    styles: Record<string, any>;
}

export const DEFAULT_DATEPICKER_CONFIG: DatePickerPropConfig = {
    selectedDate: "",
    placeholder: "Select a date...",
    disabled: false,
    styles: {}
};

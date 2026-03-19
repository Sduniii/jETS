package de.sduni.jets.ui;

import de.sduni.jets.model.v20.KnxBase;
import de.sduni.jets.project.DptTranslator;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class ProjectTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Property", "Value"};
    private final List<PropertyRow> rows = new ArrayList<>();

    public ProjectTableModel(Object targetObject) {
        if (targetObject == null) return;
        
        try {
            Method[] methods = targetObject.getClass().getMethods();
            for (Method method : methods) {
                // Only look at getters that don't take parameters
                if (method.getName().startsWith("get") && method.getParameterCount() == 0 && !method.getName().equals("getClass")) {
                    Object value = method.invoke(targetObject);
                    String propName = method.getName().substring(3);

                    // We only want to show simple properties in the table, not complex nested objects or lists
                    // (Those are displayed in the tree instead)
                    if (value == null || isSimpleType(value.getClass())) {
                        rows.add(new PropertyRow(propName, value, targetObject, method));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSimpleType(Class<?> clazz) {
        return clazz.isPrimitive() || 
               clazz == String.class || 
               clazz == Boolean.class ||
               clazz == Integer.class ||
               clazz == Long.class ||
               clazz == Double.class ||
               clazz == Float.class ||
               clazz == Short.class ||
               clazz == Byte.class ||
               clazz == byte[].class ||
               java.time.LocalDateTime.class.isAssignableFrom(clazz);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PropertyRow row = rows.get(rowIndex);
        if (columnIndex == 0) {
            return row.name;
        } else {
            Object val = row.value;
            if ("Value".equals(row.name) && val instanceof String) {
                // Heuristic: Try to find DPT context from parent or object
                // For now, let's just do a generic translation if it looks like hex/base64
                // We could enhance this by passing DPT info to the constructor
                return val + " (" + DptTranslator.translate(0, 0, (String) val) + ")";
            }
            return val;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Value column is editable if there is a corresponding setter
        return columnIndex == 1 && rows.get(rowIndex).hasSetter();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            PropertyRow row = rows.get(rowIndex);
            if (row.setValue(aValue)) {
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        }
    }

    private static class PropertyRow {
        String name;
        Object value;
        Object targetObject;
        Method getter;
        Method setter;

        PropertyRow(String name, Object value, Object targetObject, Method getter) {
            this.name = name;
            this.value = value;
            this.targetObject = targetObject;
            this.getter = getter;
            
            // Try to find the corresponding setter
            try {
                this.setter = targetObject.getClass().getMethod("set" + name, getter.getReturnType());
            } catch (NoSuchMethodException e) {
                this.setter = null;
            }
        }

        boolean hasSetter() {
            return setter != null;
        }

        boolean setValue(Object newValue) {
            if (setter == null) return false;
            try {
                // Handle basic string-to-type conversions for the UI
                Object convertedValue = newValue;
                if (newValue instanceof String && getter.getReturnType() != String.class) {
                    String str = (String) newValue;
                    Class<?> type = getter.getReturnType();
                    if (type == int.class || type == Integer.class) convertedValue = Integer.parseInt(str);
                    else if (type == long.class || type == Long.class) convertedValue = Long.parseLong(str);
                    else if (type == boolean.class || type == Boolean.class) convertedValue = Boolean.parseBoolean(str);
                    else if (type == double.class || type == Double.class) convertedValue = Double.parseDouble(str);
                    else if (type == float.class || type == Float.class) convertedValue = Float.parseFloat(str);
                    else if (type == short.class || type == Short.class) convertedValue = Short.parseShort(str);
                }
                
                setter.invoke(targetObject, convertedValue);
                this.value = convertedValue;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}

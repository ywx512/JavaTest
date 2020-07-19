package annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 0:30
 * @Description:
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("no annotated classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> clazz = Class.forName(className);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = clazz.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();

            for (Field field : clazz.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    continue;
                }

                for(int i = 0; i < annotations.length; i++){

                    if (annotations[0] instanceof SQLString) {
                        SQLString sqlString = (SQLString) annotations[0];
                        if (sqlString.name().length() < 1) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlString.name();
                        }
                        columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints((sqlString.constrains())));
                    }

                    if (annotations[0] instanceof SQLInteger) {
                        SQLInteger sqlInteger = (SQLInteger) annotations[0];
                        if (sqlInteger.name().length() < 1) {
                            columnName = field.getName().toUpperCase();
                        } else {
                            columnName = sqlInteger.name();
                        }
                        columnDefs.add(columnName + " INT" + getConstraints((sqlInteger.constrains())));
                    }
                }

            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n    " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("SQL: \n" + tableCreate);
        }
    }

    private static String getConstraints(Constrains con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}

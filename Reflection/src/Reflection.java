import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class Reflection{
    private Class<?> myClass;
    private MyClass myObject;
    private Constructor<?>[] constructors;
    private Method[] methods;
    private Field[] fields;

    public  Reflection(){
        infoClass();
        infoCostruttoreMetodiCampi();
    }
    public void infoClass()  {
        try {
            Class<?> myClass;
            myClass = MyClass.class;
            //OPPURE
            MyClass myObject = new MyClass();
            myClass = myObject.getClass();
            //OPPURE
            String className = "src/MyClass.java";
                myClass = Class.forName(className);
            this.myClass = myClass;
            this.myObject = myObject;
        }
        catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
        }
    }

    private void infoCostruttoreMetodiCampi(){
        this.constructors = this.myClass.getConstructors();
        this.methods = this.myClass.getMethods();
        this.fields = this.myClass.getFields();
    }

    private void CreazioneDinamicheInstanze() {
        try {
            Class<?> myClass = MyClass.class;
            Constructor<?> constructor = myClass.getConstructor();
            MyClass myObject = (MyClass) constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private void AcessoDatiDinamico(){
        try {
            MyClass myObject = new MyClass();
            Class<?> myClass = MyClass.class;

            Field field = myClass.getField("id");
            field.set(myObject,3);

            Method method = myClass.getMethod("print");
            method.invoke(myObject);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}




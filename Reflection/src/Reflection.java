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
        myClass = null;
        myObject = null;
        constructors = null;
        methods = null;
        fields = null;

        //System.out.println("Class path: "+System.getProperty("java.class.path"));

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
            String className = "MyClass";
            myClass = Class.forName(className);
            this.myClass = myClass;
            this.myObject = myObject;
        }
        catch (ClassNotFoundException e) {
                System.out.println("Non trovo il percorso");
                throw new RuntimeException(e);
        }
    }

    public void infoCostruttoreMetodiCampi(){
        this.constructors = this.myClass.getConstructors();
        this.methods = this.myClass.getMethods();
        this.fields = this.myClass.getFields();
    }

    public void CreazioneDinamicheInstanze() {
        try {
            Class<?> myClass = MyClass.class;
            Constructor<?> constructor = myClass.getConstructor();
            MyClass myObject = (MyClass) constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public void AcessoDatiDinamico(){
        try {
            MyClass myObject = new MyClass();
            Class<?> myClass = MyClass.class;

            Field field = myClass.getDeclaredField("id");  //getDeclareField, perchè la variabile è provata
            //field.set(myObject,3); Non si puo' usare con le variabili private

            Method method = myClass.getDeclaredMethod("print");
            //method.invoke(myObject); Non si puo' usare con le variabili private
        } catch (NoSuchFieldException  | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}




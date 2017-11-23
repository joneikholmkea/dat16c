package reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Plugin {

    static {
        System.out.println("Static blok i gang...");
    }

    public static void main(String[] args) {
        new Plugin();
    }

    static int aNUmber = 3;

    public Plugin(){

        //1. få den rigtige path
        String rootPath = System.getProperty("user.dir");
        System.out.println("path:" +rootPath);

        File root = new File(rootPath);
        File sourceFile = new File(root, "src/reflection/Person.java");

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int res = compiler.run(null,null,null, sourceFile.getPath());
        System.out.println("Kompilering resultat:" + res);

        //2. Hent en ClassLoader, som kan loade en ny klasse ind i dette kørende program:
        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            Class clazz =  Class.forName("reflection.Person", true, classLoader);
            if(clazz != null){
                System.out.println("det lykkedes!");
                System.out.println("Navn på klasse: " + clazz.getSimpleName());
                Object person = clazz.newInstance();
                Person personObj = (Person)person;

            }else {
                System.out.println("ingen clazz");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
